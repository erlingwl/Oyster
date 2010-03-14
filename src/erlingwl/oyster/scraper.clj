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

(defn- login-headers [] (:headers (login)))
(defn- login-location [] (first (get (login-headers) "Location")))

(defn getpage [url] (http/get url :as :string))

(defn journey-history-url [logged-in-page]
  (str domain
  (nth (re-find #"<a href=\"(.*)\">Journey.*history</a>" logged-in-page) 1)
))

(defn parse-first-card-no [logged-in-page]
  (nth (re-find #"<option\s*value=\"(\d+)\"\s*>" logged-in-page) 1)
  )

(defn parse-hidden-input [logged-in-page]
  (let [match (re-find #"<input type=\"hidden\" name=\"(.+)\" value=\"(.*)\"/>" logged-in-page)]
    {:key (nth match 1) :value (nth match 2)}
    )
  )

(defn choose-card [card-id hidden-key-pair]
  (http/post (str domain "/oyster/selectCard.do")
    :parameter ({:Content-Type "application/x-www-form-urlencoded"} :parammap)
    :query {:cardId card-id :method "input" (:key hidden-key-pair) (:value hidden-key-pair)}
    :as :string
    :headers-as :map
  )
)

(defn logged-in-page-for-first-card [logged-in-page]
  (println logged-in-page)
  (let [card-no (parse-first-card-no logged-in-page) hidden-key-pair (parse-hidden-input logged-in-page)]
    (if (not (nil? card-no))
      (let [content (:content (choose-card card-no hidden-key-pair))]
        content
        )
      logged-in-page
      )
    )
)

(defn printer-friendly-url [] (
  (str domain
  (let [logged-in-page (logged-in-page-for-first-card (:content (getpage (login-location))))]
  (nth
    (re-find #"<p><a href=\"(.*)\".*target=\"_new\".*>Printer friendly version</a></p>"
      (let [go-to-journey-history-page-url (journey-history-url logged-in-page)]
        (let [journey-history-page (:content (getpage go-to-journey-history-page-url))]
        journey-history-page)
        )
    )
  1)
    )
  )
))

(defn printer-friendly-page [](:content (getpage (printer-friendly-url))))
