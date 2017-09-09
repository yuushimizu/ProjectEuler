(require '[project-euler.util :refer :all]
         '[project-euler.util.predicates :as p])

(->> (cons 2 (range-from 3 2))
     (reductions (fn [[_ n] candidate] [candidate (if (div? n candidate) (/ n candidate) n)])
                 [1 600851475143])
     (filter (fn [[_ n]] (= n 1)))
     (first)
     (first))
