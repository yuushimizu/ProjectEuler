(ns project-euler.p6
  (:require [project-euler.util :refer :all]
            [project-euler.util.predicates :as p]))

(defn solve []
  (let [nums (range 1 101)]
    (- (square (sum nums))
       (sum (map square nums)))))
