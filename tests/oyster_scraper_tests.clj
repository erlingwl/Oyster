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

(deftest should-return-original-logged-in-page-for-first-card-if-no-cards-to-select
  (let [original-logged-in-page "original"]
    (expect [parse-first-card-no (returns nil)]
      (expect [parse-hidden-input (returns nil)]
        (is (= original-logged-in-page (logged-in-page-for-first-card original-logged-in-page)))
    ))
  )
)

(deftest should-return-page-for-first-card-if-cards-to-select
  (let [first-card-logged-in-page "first-card-logged-in"]
    (expect [parse-first-card-no (returns "1234")]
      (expect [parse-hidden-input (returns {:key "123" :value "345"})]
        (expect [choose-card (returns {:content first-card-logged-in-page})]
          (is (= first-card-logged-in-page (logged-in-page-for-first-card "original-logged-in-page")))
        )
      )
    )
  )
)

(deftest test-printer-friendly-page
  (expect [getpage (returns {:content "Mocked page"})]
    (expect [printer-friendly-url (returns "http://irrelevant/url")]
      (is (= (printer-friendly-page) "Mocked page"))
    )
  )
)

(clojure.test/run-tests)
(defn runtests [] (clojure.test/run-tests))
