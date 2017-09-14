(ns project-euler.p9
  (:require [project-euler.util :refer :all]
            [project-euler.util.predicates :as p]))

(defn pythagorean-triplet? [a b c]
  (= (+ (square a) (square b)) (square c)))

(defn solve []
  (->> (range)
       (mapcat (fn [a] (->> (range (inc a) (/ (- 1000 a) 2))
                            (map #(vector a % (- 1000 a %))))))
       (filter #(apply pythagorean-triplet? %))
       (first)
       (reduce *)))
