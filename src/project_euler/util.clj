(ns project-euler.util)

(defn div? [n m]
  (zero? (mod n m)))

(defn sum [s]
  (reduce + 0 s))
