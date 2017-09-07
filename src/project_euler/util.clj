(ns project-euler.util)

(defn div? [n m]
  (zero? (mod n m)))

(defn sum [s]
  (reduce + 0 s))

(defn fib []
  (->> (iterate (fn [[n m]] [(+ n m) n]) [1 1])
       (map first)))
