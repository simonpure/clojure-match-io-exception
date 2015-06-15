(ns match.core
  (:require [clojure.core.match :refer [match]])
  (:gen-class))

;; in a REPL try
;; (compile 'match.core)
;;
;; or try lein uberjar
(defn compile-io-exception [m]
  (match [m]
         [1] :foo
         [2] :foo
         [3] :foo
         [4] :foo
         [5] :foo
         [6] :foo
         [7] :foo
         [8] :foo
         [9] :foo
         [10] :foo
         [11] :foo
         [12] :foo
         [13] :foo
         [14] :foo
))

(defn -main [& args]
  (println "compilation issue")
  (compile-io-exception 1))
