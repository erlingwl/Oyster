(ns erlingwl.oyster.scraper
  (:import
    (java.io ByteArrayInputStream)
    )
  (:require [com.twinql.clojure.http :as http])
)
(use 'clojure.contrib.java-utils)
(use 'erlingwl.oyster.global)

(def domain "https://oyster.tfl.gov.uk")

(def password (.getProperty (read-properties *propertiesfile*) "password"))
(def username (.getProperty (read-properties *propertiesfile*) "username"))

(defn- login []
  (http/post (str domain "/oyster/security_check")
    :parameter ({:Content-Type "application/x-www-form-urlencoded"} :parammap)
    :query {:j_username username :j_password password}
    :as :string
    :headers-as :map
  )
)

(defn login-headers [] (:headers (login)))

(defn login-location [login-headers-map] (first (get login-headers-map "Location")))

(defn parse-jsession-id [headers-map]
  (let [cookies (first (get headers-map "Set-Cookie"))]
    (nth (re-find #"(JSESSIONID=\S*);" cookies) 1)   
  )
)

(defn journey-history-url [logged-in-page]
  (str domain
  (nth (re-find #"<a href=\"(.*)\">Journey.*history</a>" logged-in-page) 1)
))

(defn parse-first-card-no [logged-in-page]
  (nth (re-find #"<option\s*value=\"(\d+)\"\s*>" logged-in-page) 1)
  )

(defn parse-hidden-input [logged-in-page]
  (let [match (re-find #"<input type=\"hidden\" name=\"(.+)\" value=\"(.+)\"/?>" logged-in-page)]
    {:key (nth match 1) :value (nth match 2)}
    )
  )

(defn append-url-params [base-url hidden-key-pair card-id]
   (str domain base-url "?" (:key hidden-key-pair) "=" (:value hidden-key-pair) "&cardId=" card-id "&method=input")
  )

(defn create-query-params [hidden-key-pair card-id]
  (assoc {:cardId card-id :method "input"} (:key hidden-key-pair) (:value hidden-key-pair))
  )

(defn get-page-for-jsessionid [url jsessionid]
    (http/get url :headers {"Cookie" jsessionid} :as :string)
)

(defn choose-card [card-id hidden-key-pair jsessionid]
  (let [url (append-url-params "/oyster/selectCard.do" hidden-key-pair card-id)]
    (get-page-for-jsessionid url jsessionid)
  )
)

(defn logged-in-page-for-first-card [logged-in-page jsessionid]
  (let [card-no (parse-first-card-no logged-in-page) hidden-key-pair (parse-hidden-input logged-in-page)]
    (if (not (nil? card-no))
      (let [content (:content (choose-card card-no hidden-key-pair jsessionid))]
        content
        )
      logged-in-page
      )
    )
)

(defn parse-printer-friendly-url [page]
  (nth
    (re-find #"<a href=\"(.*)\".*target=\".*\".*>Printer friendly version</a>" page)
  1)
)

(defn printer-friendly-url [login-headers-map]
    (let [jsessionid (parse-jsession-id login-headers-map)]
        (str domain
            (let [logged-in-page (logged-in-page-for-first-card (:content (get-page-for-jsessionid (login-location login-headers-map) jsessionid)) jsessionid)]
                (let [go-to-journey-history-page-url (journey-history-url logged-in-page)]
                    (let [journey-history-page (:content (get-page-for-jsessionid go-to-journey-history-page-url jsessionid))]
                        (let [parsed-printer-friendly-url (parse-printer-friendly-url journey-history-page)]
                            parsed-printer-friendly-url
                        )
                    )
                )
            )
        )
    )
)

(defn printer-friendly-page []
  (let [login-headers-map (login-headers)]
    (let [jsessionid (parse-jsession-id login-headers-map)]
      (:content (get-page-for-jsessionid (printer-friendly-url login-headers-map) jsessionid))
    )
  )
)
