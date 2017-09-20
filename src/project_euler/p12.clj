(ns project-euler.p12
  (:require [project-euler.util :refer :all]
            [project-euler.util.predicates :as p]))

(defn triangle-numbers []
  (reductions + (range-from 1)))

(defn solve []
  (->> (triangle-numbers)
       (filter #(> (factor-count %) 500))
       (first)))
