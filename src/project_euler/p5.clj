(ns project-euler.p5
  (:require [project-euler.util :refer :all]
            [project-euler.util.predicates :as p]))

(defn solve []
  (->> (range 2 21)
       (reduce (fn [factors n]
                 (let [rest (reduce div-if-can n factors)]
                   (if (= 1 rest) factors (conj factors rest))))
               [])
       (reduce *)))
