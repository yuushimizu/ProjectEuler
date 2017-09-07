(require '[project-euler.util :refer :all])

(->> (range)
     (filter #(or (div? % 3) (div? % 5)))
     (take-while #(< % 1000))
     (sum))
