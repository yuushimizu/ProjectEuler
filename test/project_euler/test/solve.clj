(ns project-euler.test.solve
  (:require [clojure.test :refer :all]
            [project-euler.core :refer [load-solve]]))

(deftest test-solve
  (are [n answer] (= answer ((load-solve n)))
    1 233168
    2 4613732
    3 6857
    4 906609
    5 232792560
    6 25164150
    7 104743
    8 23514624000
    9 31875000
    10 142913828922
    11 70600674
    12 76576500
    13 5537376230
    14 837799))
