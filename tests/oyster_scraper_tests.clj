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
  (is (= (parse-hidden-input select-card-form) {:key "1173511920" :value "24-4-6375FCE6C08010C5E54FABA04C074E29"}))
  )

(deftest should-create-query-params
  (let [query-params-map (create-query-params {:key "1234" :value "4567"} "8978")]
    (is (= (get query-params-map :cardId) "8978"))
    (is (= (get query-params-map :method) "input"))
    (is (= (get query-params-map "1234") "4567"))
    )
)

(deftest should-append-url-params
  (let [hidden-input {:key "1234" :value "4567"} card-id "8978"]
    (is (= (append-url-params "/first-part" hidden-input card-id) (str domain "/first-part?1234=4567&cardId=8978&method=input")))
  )
)

(deftest should-return-original-logged-in-page-for-first-card-if-no-cards-to-select
  (let [original-logged-in-page "original"]
    (expect [parse-first-card-no (returns nil)]
      (expect [parse-hidden-input (returns nil)]
        (is (= original-logged-in-page (logged-in-page-for-first-card original-logged-in-page "JSESSIONID=1234")))
    ))
  )
)

(deftest should-return-page-for-first-card-if-cards-to-select
  (let [first-card-logged-in-page "first-card-logged-in"]
    (expect [parse-first-card-no (returns "1234")]
      (expect [parse-hidden-input (returns {:key "123" :value "345"})]
        (expect [choose-card (returns {:content first-card-logged-in-page})]
          (is (= first-card-logged-in-page (logged-in-page-for-first-card "original-logged-in-page" "JSESSIONID=1234")))
        )
      )
    )
  )
)

(deftest test-printer-friendly-page
  (expect [login-headers (returns {"Location" ["http://location"] "Set-Cookie" ["JSESSIONID=12345A.portal2; Path=/; Secure"]})]
    (expect [get-page-for-jsessionid (returns {:content "Mocked page"})]
      (expect [printer-friendly-url (returns "http://irrelevant/url")]
        (is (= (printer-friendly-page) "Mocked page"))
      )
    )
  )
)

(deftest should-parse-printer-friendly-url
  (is (= (parse-printer-friendly-url test-printer-friendly-url) "/printer-friendly"))
)

(deftest should-return-printer-friendly-url
  (let [login-headers {"Location" ["http://location"] "Set-Cookie" ["JSESSIONID=12345A.portal2; Path=/; Secure"]}]
    (expect [logged-in-page-for-first-card (returns nil)]
      (expect [get-page-for-jsessionid (returns {:content test-printer-friendly-url})]
        (expect [login-location (returns nil)]
          (expect [journey-history-url (returns "http://journey-history")]
              (is (= (printer-friendly-url login-headers) (str domain "/printer-friendly")))
          )
        )
      )
    )
  )
)

(deftest return-login-location
  (let [login-headers {"Location" ["http://location"]}]
    (is (= (login-location login-headers) "http://location"))
  )
)

(deftest should-parse-jsessionid-from-cookie
  (is (= (parse-jsession-id {"Set-Cookie" ["JSESSIONID=12345A.portal2; Path=/; Secure"]}) "JSESSIONID=12345A.portal2"))
  )

(clojure.test/run-tests)
(defn runtests [] (clojure.test/run-tests))
