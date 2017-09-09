(require '[project-euler.util :refer :all]
         '[project-euler.util.predicates :as p])

(let [nums (range 1 101)]
  (- (square (sum nums))
     (sum (map square nums))))
