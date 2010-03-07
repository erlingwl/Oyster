(ns erlingwl.oyster.printer
  (use erlingwl.oyster.parser)
  (use erlingwl.oyster.scraper)
  )

(defn parsed-trs [] (parse-trs (parse-body (printer-friendly-page))))

(defn print-costs [] (doseq [date-and-cost (calculate-cost-of-all-dates (parsed-trs))]
  (println (str (first date-and-cost) " : " (second date-and-cost)))
))

(print-costs)
