(ns project-euler.test.solve
  (:require [clojure.test :refer :all]
            [project-euler.util :refer [solve]]))

(deftest test-solve
  (are [n answer] (= answer (solve n))
    1 233168
    2 4613732
    3 6857))
