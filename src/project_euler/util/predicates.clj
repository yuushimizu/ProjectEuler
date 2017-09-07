(ns project-euler.util.predicates
  (:refer-clojure :exclude [or <])
  (:require [clojure.core :as core]
            [project-euler.util :as util]))

(defn div? [n]
  #(util/div? % n))

(defn or [f & fns]
  (reduce (fn [pred f] #(core/or (pred %) (f %))) f fns))

(defn < [n]
  #(core/< % n))
