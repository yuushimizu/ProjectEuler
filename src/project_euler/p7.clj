(ns project-euler.p7
  (:require [project-euler.util :refer :all]
            [project-euler.util.predicates :as p]))

(defn solve []
  (nth (primes) 10000))
