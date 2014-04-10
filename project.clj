(defproject hello-world "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring "1.2.1"]]
  :profiles {:dev {:dependencies [[ring-mock "0.1.5"]]}}
  :plugins [[lein-ring "0.8.10"]]
  :source-paths ["src/clj"]
  :main hello-world.server
  :ring {:handler hello-world.server/app})

