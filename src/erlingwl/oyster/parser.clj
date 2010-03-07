(ns erlingwl.oyster.parser
  (:import
    (java.lang Exception)
    (java.io ByteArrayInputStream)
    )
  (:require [clojure.contrib.lazy-xml :as xml])
  (:require [clojure.contrib.str-utils2 :as strutils2])
)
(use 'clojure.xml)
(use 'clojure.contrib.str-utils)
(use 'clojure.stacktrace)

(defn parse-body [rawhtml]
  (nth (re-find #"(?s)<table.*(<table.*</table>).*</table>" rawhtml) 1)
)

(defn- trs [feed] (filter #(= :tr (:tag %)) feed))

(defn- strip-pound [input] (re-gsub #"&pound;" "" input))

(defn- encode-ampersand [input] (re-gsub #"&" "&amp;" input))

(defn- format-as-valid-xml [input]
  (encode-ampersand
    (strip-pound (str "" input))
  )
)

(defn parse-trs [innertable]
  (let [input-stream (ByteArrayInputStream. (.getBytes (format-as-valid-xml innertable) "UTF-8"))]
    (trs (xml-seq (parse input-stream)))
  )
)

(defn date-match [tr]
  (if (nil? tr)
    nil
    (re-find #"(\d+/\d+/\d+)" tr)
  )
)

(defn first-td-content [trlist]
  (let [content (first (:content (first (:content (first trlist)))))]
    (if (string? content)
      content
      ""
    )
  )
)

(defn get-list-of-next-non-dates [trlist]
  (loop [trs (seq trlist) nondates []]
    (if (empty? trs)
      (throw (Exception. "No more date content.. EOF"))
      (if (or (not (nil? (date-match (first-td-content trs)))))
        (conj nondates (first trs))
        (recur (rest trs) (conj nondates (first trs)))
      )
    )
  )
)

(defn get-list-of-first-date [trlist]
  (loop [trs (seq trlist)]
    (if (or (not (nil? (date-match (first-td-content trs)))) (empty? trs))
      (list* (first trs) (get-list-of-next-non-dates (rest trs)))
      (recur (rest trs))
    )
  )
)

(defn parse-balance [tr]
  (let [tds (:content tr)]
    (if (not (date-match (first (:content (first tds)))))
      (if (re-find #".*top-up.*" (first (:content (nth tds 3))))
        (BigDecimal. (strutils2/trim (first (:content (nth tds 4)))))
        (BigDecimal. 0)
      )
      (BigDecimal. (first (:content (nth tds 6))))
    )
  )
)

(defn calculate-cost-of-date [datetrs]
  (loop [trs (rest datetrs) sum (parse-balance (first datetrs))]
    (if (empty? trs)
      sum
      (recur (rest trs)
        (let [balance (parse-balance (first trs))]
          (- sum balance)
        )
      )
    )
  )
)

(defn calculate-cost-of-first-date [trlist]
  (let [firstdatetrs (get-list-of-first-date trlist)]
    (calculate-cost-of-date firstdatetrs)
  )
)

(defn calculate-cost-of-all-dates [trlist]
  (loop [trs (seq trlist) sumlist []]
    (if (empty? trs)
      sumlist
      (recur (rest trs)
        (let [datematch (date-match (first-td-content trs))]
          (if (not (nil? datematch))
            (try
              (conj sumlist [(nth datematch 1) (calculate-cost-of-first-date trs)])
              (catch Exception e
                sumlist
              )
            )
            sumlist
          )
        )
      )
    )
  )
)