(ns project-euler.util)

(defn solve [n]
  (load-file (format "src/project_euler/p%s.clj" (str n))))

(defn div? [n m]
  (zero? (mod n m)))

(defn sum [nums]
  (reduce + 0 nums))

(defn fib []
  (->> (iterate (fn [[n m]] [(+ n m) n]) [1 1])
       (map first)))

(defn range-from
  ([start step]
   (iterate #(+ % step) start))
  ([start]
   (range-from start 1)))
