(ns project-euler.p14
  (:require [project-euler.util :refer :all]
            [project-euler.util.predicates :as p]))

(defn collatz [n]
  (if (even? n)
    (/ n 2)
    (inc (* n 3))))

(def collatz-chain-count
  (let [memo (atom {1 1})]
    (fn [n]
      (loop [n n
             route []]
        (if-let [memoized (@memo n)]
          (do
            (doseq [[x count] (map-indexed (fn [i x] [x (+ (inc i) memoized)]) route)]
              (swap! memo assoc x count))
            (+ (count route)  memoized))
          (recur (collatz n) (cons n route)))))))

;; 6500 ms
(defn solve []
  (apply max-key collatz-chain-count (range 1 1000000)))
