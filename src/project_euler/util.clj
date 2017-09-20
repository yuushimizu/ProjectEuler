(ns project-euler.util)

(defn div? [n m]
  (zero? (mod n m)))

(defn div-if-can [n m]
  (if (div? n m) (/ n m) n))

(defn div-while-possible [n m]
  (->> (iterate (fn [[n count]] [(quot n m) (inc count)]) [n 0])
       (drop-while #(div? (first %) m))
       (first)))

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

(defn reverse-number [n]
  (->> (iterate #(quot % 10) n)
       (take-while #(> % 0))
       (map #(mod % 10))
       (reduce #(+ (* %1 10) %2) 0)))

(defn factors [n]
  (let [sqrt (Math/sqrt n)
        small-factors (->> (range 2 sqrt)
                           (filter #(div? n %)))]
    (concat [1]
            small-factors
            (if (== sqrt (int sqrt)) [(int sqrt)])
            (map #(quot n %) (reverse small-factors))
            [n])))

(defn fib []
  (->> (iterate (fn [[n m]] [(+ n m) n]) [0 1])
       (map first)))

(defn primes []
  ;; ignores 2x
  (let [first-limit 1000000
        is-not-prime (java.util.BitSet. first-limit)]
    (letfn [(set-is-not-prime [^long limit ^long from]
              (let [sqrt (Math/sqrt limit)]
                (doseq [^long n (->> (range-from 3 2)
                                     (take-while #(< % sqrt)))]
                  (when-not (.get is-not-prime n)
                    (let [n2 (* n 2)]
                      (doseq [^long x (range (max (square n)
                                                  (+ (* (quot (+ (dec from) n) n2) n2) n))
                                             limit
                                             n2)]
                        (.set is-not-prime x)))))))
            (primes* [^long limit ^long start]
              (set-is-not-prime limit start)
              (concat (->> (range start limit 2)
                           (remove #(.get is-not-prime %)))
                      (lazy-seq (primes* (* limit 2) (inc limit)))))]
      (cons 2 (primes* first-limit 3)))))

(defn prime-candidates []
  (letfn [(rec [n]
            (lazy-seq (cons n (cons (+ n 2) (rec (+ n 6))))))]
    (cons 2 (cons 3 (rec 5)))))

(defn prime-factors [n]
  (letfn [(rec [n [candidate & rest]]
            (cond (= n 1) []
                  (> (square candidate) n) [n]
                  (div? n candidate) (lazy-seq (cons candidate (rec (quot n candidate) (cons candidate rest))))
                  :else (lazy-seq (rec n rest))))]
    (rec n (prime-candidates))))

(defn factor-count [n]
  (->> (prime-factors n)
       (frequencies)
       (vals)
       (map inc)
       (reduce *)))

(defn divisors-count [n]
  (* 2 (count (filter #(zero? (rem n %))
                      (range 1 (Math/sqrt n))))))
