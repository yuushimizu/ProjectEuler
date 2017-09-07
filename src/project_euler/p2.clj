(require '[project-euler.util :refer :all])

(->> (fib)
     (take-while (p-< 4000000))
     (filter even?)
     (sum))
