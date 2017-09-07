(ns project-euler.p1
  (:require [project-euler.util :refer :all]))

(println
 (->> (range)
      (filter #(or (div? % 3) (div? % 5)))
      (take-while #(< % 1000))
      (sum)))
