(require '[project-euler.util :refer :all])

(->> (fib)
     (take-while #(< % 4000000))
     (filter even?)
     (sum))
