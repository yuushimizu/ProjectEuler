(ns project-euler.p10
  (:require [project-euler.util :refer :all]
            [project-euler.util.predicates :as p]))

(defn solve []
  (->> (primes)
       (take-while (p/< 2000000))
       (sum)))
