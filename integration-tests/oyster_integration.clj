(ns oyster_integration)

(use 'erlingwl.oyster.global)

(binding [*propertiesfile* (get-sys-prop-or-use-default "../config/production/oyster.properties")]
  (use 'erlingwl.oyster.printer)
  )
