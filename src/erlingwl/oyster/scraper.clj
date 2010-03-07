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

(defn- getpage [url] (http/get url :as :string))

(defn- journey-history-url [](str domain
  (nth (re-find #"<li><a href=\"(.*)\">Journey history</a>" (:content (getpage (login-location)))) 1)
))

(defn- printer-friendly-url [] (str domain
  (nth
    (re-find #"<p><a href=\"(.*)\".*target=\"_new\".*>Printer friendly version</a></p>"
      (:content (getpage (journey-history-url)))
    )
  1)
))

(defn printer-friendly-page [](:content (getpage (printer-friendly-url))))
