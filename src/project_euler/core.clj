(ns project-euler.core)

(defn load-solve [n]
  (let [ns (symbol (format "project-euler.p%s" n))]
    (require ns)
    (ns-resolve ns 'solve)))

(defn -main [n]
  (let [solve (load-solve n)
        result (time (solve))]
    (println result)))
