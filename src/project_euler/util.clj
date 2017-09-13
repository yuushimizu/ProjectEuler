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

(defn range-from
  ([start step]
   (iterate #(+ % step) start))
  ([start]
   (range-from start 1)))

(defn keep-reductions [f initial-value coll]
  (->> coll
       (reductions (fn [[acc _] x]
                     (if-let [result (f acc x)] [result true] [acc false]))
                   [initial-value nil])
       (filter second)
       (map first)))

(defn remove-from-set [f set]
  (reduce (fn [result x] (cond-> result (f x) (disj x))) set set))

(defn digits [n]
  (if (zero? n)
    [0]
    (->> (iterate #(quot % 10) n)
         (take-while #(> % 0))
         (map #(mod % 10))
         (reverse))))

(defn fib []
  (->> (iterate (fn [[n m]] [(+ n m) n]) [0 1])
       (map first)))

(defn prime-candidates
  ([]
   (cons 2 (range-from 3 2)))
  ([limit]
   (take-while #(< % limit) (prime-candidates))))

(defn primes []
  ;; ignores 2x
  (letfn [(set-is-not-prime [^booleans is-not-prime ^long from]
            (let [length (alength is-not-prime)
                  sqrt (Math/sqrt (alength is-not-prime))]
              (doseq [^long n (->> (range-from 3 2)
                                   (take-while #(< % sqrt)))]
                (when-not (aget is-not-prime n)
                  (let [n2 (* n 2)]
                    (doseq [^long x (range (max (square n)
                                                (+ (* (quot (+ (dec from) n) n2) n2) n))
                                           length
                                           n2)]
                      (aset is-not-prime x true)))))))
          (expand-is-not-prime [^booleans current]
            (let [expanded (boolean-array (* (alength current) 2))]
              (System/arraycopy current 0 expanded 0 (alength current))
              expanded))
          (primes* [^booleans is-not-prime ^long start]
            (set-is-not-prime is-not-prime start)
            (concat (->> (range start (alength is-not-prime) 2)
                         (remove #(aget is-not-prime %)))
                    (lazy-seq (primes* (expand-is-not-prime is-not-prime) (inc (alength is-not-prime))))))]
    (cons 2 (primes* (boolean-array 100000) 3))))

(take 20 (primes))
