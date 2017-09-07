(require '[project-euler.util :refer :all]
         '[project-euler.util.predicates :as p])

(->> (fib)
     (take-while (p/< 4000000))
     (filter even?)
     (sum))
