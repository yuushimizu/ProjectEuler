(ns project-euler.core)

(defn -main [n]
  (println (load-file (format "src/project_euler/p%s.clj" n))))
