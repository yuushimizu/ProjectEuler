(require '[project-euler.util :refer :all]
         '[project-euler.util.predicates :as p])

(->> (primes)
     (take-while (p/< 2000000))
     (sum))
