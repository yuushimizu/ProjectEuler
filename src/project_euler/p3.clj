(ns project-euler.p3
  (:require [project-euler.util :refer :all]
            [project-euler.util.predicates :as p]))

(defn solve []
  (->> (primes)
       (reductions (fn [[_ n] candidate] [candidate (first (div-while-possible n candidate))])
                   [1 600851475143])
       (filter (fn [[_ n]] (= n 1)))
       (first)
       (first)))
