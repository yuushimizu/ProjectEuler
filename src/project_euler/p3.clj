(require '[project-euler.util :refer :all]
         '[project-euler.util.predicates :as p])

(->> (cons 2 (range-from 3 2))
     (reductions (fn [{n :n} candidate]
                   (let [factor? (div? n candidate)]
                     {:candidate candidate
                      :n (if factor? (/ n candidate) n)
                      :factor? factor?}))
                 {:candidate 1 :n 600851475143 :factor? false})
     (filter (fn [{factor? :factor?}] factor?))
     (take-while (fn [{n :n}] (> n 1)))
     (last)
     :n)
