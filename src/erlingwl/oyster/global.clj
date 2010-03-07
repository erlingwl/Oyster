(ns erlingwl.oyster.global)
(use 'clojure.contrib.java-utils)

(def get-sys-prop-or-use-default (fn [default](get-system-property "oyster.config" default)))

(def *propertiesfile* "/config/production/oyster.properties")