(ns project-euler.util)

(defn solve [n]
  (load-file (format "src/project_euler/p%s.clj" (str n))))

(defn div? [n m]
  (zero? (mod n m)))

(defn div-if-can [n m]
  (if (div? n m) (/ n m) n))

(defn square [n]
  (* n n))

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

(defn digits [n]
  (if (zero? n)
    [0]
    (->> (iterate #(quot % 10) n)
         (take-while #(> % 0))
         (map #(mod % 10))
         (reverse))))

(defn keep-reductions [f initial-value coll]
  (->> coll
       (reductions (fn [[acc _] x]
                     (if-let [result (f acc x)] [result true] [acc false]))
                   [initial-value nil])
       (filter second)
       (map first)))
