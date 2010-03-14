(ns oyster_tests
  (:import
    (java.lang Exception)
    (java.util Properties)
    )
  )
(use 'oyster_test_data)
(use 'clojure.contrib.test-is)
(use 'erlingwl.oyster.global)
(use 'clojure.contrib.mock)

(binding [*propertiesfile* (get-sys-prop-or-use-default "../config/test/oyster.properties")]
  (use 'erlingwl.oyster.parser)
  (use 'erlingwl.oyster.scraper)
  )

(deftest should-parse-journey-history-url
  (is (= (journey-history-url "<li><a href=\"/url\">Journey history</a>") (str domain "/url")))
)

(deftest should-parse-first-card-number-from-select-card-form
  (is (= (parse-first-card-no select-card-form) "12345"))
  )

(deftest should-parse-first-card-number-from-select-card-form
  (is (= (parse-first-card-no "<option value=\"12345\" >12345</option>") "12345"))
  )

(deftest should-parse-hidden-input
  (is (= (parse-hidden-input select-card-form) {:key "123456789" :value "9-5-1234E"}))
  )

;(defn printer-friendly-page [](:content (getpage (printer-friendly-url))))

(deftest test-printer-friendly-page
  (expect [getpage (returns {:content "Mocked page"})]
    (expect [printer-friendly-url (returns "http://irrelevant/url")]
      (is (= (printer-friendly-page) "Mocked page"))
    )
  )
)

(clojure.test/run-tests)
(defn runtests [] (clojure.test/run-tests))
