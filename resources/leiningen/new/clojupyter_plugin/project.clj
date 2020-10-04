(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "Clojupyter plugin"
  :url "http://example.com/FIXME"
  :license {:name "MIT"}

  :dependencies [[org.clojars.nighcoder/clojupyter "0.4.0"]]

  :profiles {:dev           {:plugins [[org.clojars.nighcoder/lein-metajar "0.1.2"]]}
             :metajar       {:libdir "../lib"}}

  :target-path "target/plugins")
