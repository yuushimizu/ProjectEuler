(require '[project-euler.util :refer :all]
         '[project-euler.util.predicates :as p])

(->> (prime-candidates)
     (reductions (fn [[_ n] candidate]
                   [candidate
                    (->> (iterate #(/ % candidate) n)
                         (drop-while (p/div? candidate))
                         (first))])
                 [1 600851475143])
     (filter (fn [[_ n]] (= n 1)))
     (first)
     (first))
