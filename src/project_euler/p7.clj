(require '[project-euler.util :refer :all]
         '[project-euler.util.predicates :as p])

(nth (->> (range-from 2)
          (keep-reductions (fn [[_ primes] n]
                             (if (not-any? #(div? n %) primes) [n (conj primes n)]))
                           [nil []])
          (map first))
     10000)
