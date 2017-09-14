(ns project-euler.p1
  (:require [project-euler.util :refer :all]
            [project-euler.util.predicates :as p]))

; 5 ms
;(defn solve []
;  (->> (range 1000)
;       (filter (p/or (p/div? 3) (p/div? 5)))
;       (sum)))

; 0.15ms
(defn solve []
  (let [limit 1000]
    (letfn [(sum-of-div [n]
              (let [nums (quot (dec limit) n)]
                (quot (* n nums (inc nums)) 2)))]
      (- (+ (sum-of-div 3) (sum-of-div 5)) (sum-of-div 15)))))
