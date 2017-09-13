(ns project-euler.core
  (:require [project-euler.util :refer [solve]]))

(defn -main [n]
  (time (println (solve n))))
