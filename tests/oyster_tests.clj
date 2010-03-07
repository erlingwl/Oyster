(ns oyster_tests
  (:import
    (java.lang Exception)
    (java.util Properties)
    )
  )
(use 'oyster_test_data)
(use 'clojure.contrib.test-is)
(use 'erlingwl.oyster.global)

(binding [*propertiesfile* (get-sys-prop-or-use-default "../config/test/oyster.properties")]
  (use 'erlingwl.oyster.parser)
  (use 'erlingwl.oyster.scraper)
  )

(deftest test-datematch
  (is (= (date-match "dadksjfs") nil))
  (is (= (nth (date-match "19/01/02") 1) "19/01/02"))
  (is (= (date-match nil) nil))
  )

(deftest should-return-content-of-first-td
  (is (= (first-td-content trlist) "15/01/10"))
)

(deftest should-return-list-of-trs-belonging-to-first-date
  (is (= (count (get-list-of-first-date trlist)) 6)))

(deftest should-return-map-of-fares
  (is (= (calculate-cost-of-all-dates trlist) [["15/01/10" (- 3.70)] ["14/01/10" (- 7.40)]])))

(deftest should-return-list-of-non-date-trs-including-next-date
  (is (= (count (get-list-of-next-non-dates nondatestrlist)) 4)))

(deftest should-calculate-cost-of-first-date
  (is (== (calculate-cost-of-first-date (get-list-of-first-date trlist)) (- 3.7))))

(deftest should-parse-balance-from-tr-with-date
  (is (== (parse-balance trwithfare) 18.00)))

(deftest should-not-parse-balance-from-tr-without-date
  (is (== (parse-balance trwithoutdate) 0.00)))

(deftest should-calculate-cost-of-first-date-with-top-up
  (is (= (calculate-cost-of-first-date (get-list-of-first-date trlistwithtopup)) (- 3.7))))

(deftest should-parse-balance-from-tr-with-top-up-to-top-up-value
  (is (== (parse-balance trwithtopup) 20.00)))

(deftest should-calculate-cost-of-first-date-with-lots-of-data
  (is (= (calculate-cost-of-first-date (get-list-of-first-date trwithlotsofshit)) (- 7.4))))

(deftest should-return-list-of-trs-belonging-to-first-date-with-lots-of-stuff
  (is (= (count (get-list-of-first-date trwithlotsofshit)) 8)))

(deftest should-throw-exception-when-no-next-date
  (try (
        (get-list-of-next-non-dates nondatestrlistwithoutdate)
        (throw (Exception. "msg: Expected method to throw excpetion, but it didn't"))
       )
       (catch Exception e ())
  )
)

(deftest should-get-password
  (is (= password "testpass")))

(deftest should-get-username
  (is (= username "testuser")))

(clojure.test/run-tests)
(defn runtests [] (clojure.test/run-tests))
