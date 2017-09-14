(ns project-euler.p2
  (:require [project-euler.util :refer :all]
            [project-euler.util.predicates :as p]))

(defn solve []
  (->> (fib)
       (take-while (p/< 4000000))
       (filter even?)
       (sum)))
