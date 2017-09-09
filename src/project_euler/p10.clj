(require '[project-euler.util :refer :all]
         '[project-euler.util.predicates :as p])

(let [limit 2000000
      is-not-prime (boolean-array limit)]
  (doseq [n (prime-candidates (Math/sqrt limit))]
    (when-not (aget is-not-prime n)
      (doseq [x (drop 1 (range n limit n))]
        (aset is-not-prime x true))))
  (->> (prime-candidates limit)
       (filter #(not (aget is-not-prime %)))
       (sum)))
