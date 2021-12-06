(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "Clojupyter plugin"
  :url "http://example.com/FIXME"
  :license {:name "MIT"}

  :dependencies [[clojupyter/clojupyter "0.4.0"]]

  :profiles {:dev           {:plugins [[org.clojars.nighcoder/lein-metajar "0.1.3"]]}
             :metajar       {:libdir "../lib"}}

  :target-path "target/plugins")
