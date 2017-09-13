(require '[project-euler.util :refer :all]
         '[project-euler.util.predicates :as p])

(defn palindromic? [n]
  (= n (reverse-number n)))

(->> (range 100 1000)
     (mapcat (fn [n] (map #(* n %) (range n 1000))))
     (reduce (fn [max n]
               (if (and (> n max) (palindromic? n)) n max))))
