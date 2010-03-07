(ns erlingwl.oyster.features
  (use clojure.contrib.duck-streams)
  (use clojure.contrib.test-is)
  )

(use 'erlingwl.oyster.parser)

(defn inputfilename [] "")
(defn expectedfilename [] "onlytable.html")
(defn parseresult [] "")

(def getfile (fn [inputfile] (str (pwd) "/features/testdata/" inputfile)))

(def slurpfile (fn [inputfilefn](slurp (getfile (inputfilefn)))))

(After)

(Before)

(Given #"^I have the (.*) from tfl$"
  #(defn inputfilename [] (String. %1))
  )

(When #"^I parse it$"
  #(defn parseresult [] (parse-body (slurpfile inputfilename)))
  )

(When #"^I parse the trs$"
  #(defn parseresult [] (parse-trs (slurpfile inputfilename)))
  )

(When #"^I ask it to calculate all costs$"
  #(defn parseresult [] (calculate-cost-of-all-dates(parse-trs (slurpfile inputfilename))))
  )

(Then #"^I should get a result matching (.*)$"
  (fn [expected]
    (defn expectedfilename [] (String. expected))
    (is (= (parseresult) (slurpfile expectedfilename)))
    (assert (= (parseresult) (slurpfile expectedfilename)))
    ))

(Then #"^I should get (\d+) trs$"
  (fn [expected]
    (is (= (count (parseresult)) (Integer. expected)))
    (assert (= (count (parseresult)) (Integer. expected)))
    ))

(Then #"^I should get a list of (\d+) costs$"
  (fn [expected]
    (is (= (count (parseresult)) (Integer. expected)))
    (assert (= (count (parseresult)) (Integer. expected)))
    )
  )