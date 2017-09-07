(require '[project-euler.util :refer :all])

(->> (range)
     (filter (p-or (p-div? 3) (p-div? 5)))
     (take-while (p-< 1000))
     (sum))
