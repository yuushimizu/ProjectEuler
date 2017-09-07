(require '[project-euler.util :refer :all]
         '[project-euler.util.predicates :as p])

(defn palindromic? [n]
  (let [digits (digits n)]
    (= digits (reverse digits))))

(defn three-digit-numbers [from]
  (range from 99 -1))

(->> (three-digit-numbers 999)
     (mapcat (fn [n] (map #(* n %) (three-digit-numbers n))))
     (filter palindromic?)
     (apply max))
