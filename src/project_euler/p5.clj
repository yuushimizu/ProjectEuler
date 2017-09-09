(require '[project-euler.util :refer :all]
         '[project-euler.util.predicates :as p])

(->> (range 2 21)
     (reduce (fn [factors n]
               (let [rest (reduce (fn [n factor] (if (div? n factor) (/ n factor) n)) n factors)]
                 (if (= 1 rest) factors (conj factors rest))))
             [])
     (reduce *))
