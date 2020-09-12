(ns leiningen.new.clojupyter-plugin
  (:require [clojure.string :as str]
            [leiningen.new.templates :refer
              [renderer name-to-path ->files project-name year sanitize-ns multi-segment]]
            [leiningen.core.main :as main]))


(def render (renderer "clojupyter-plugin"))

(defn clojupyter-plugin
  "Clojupyter plugins template"
  [name]
  (let [data {:raw-name (if (str/includes? name "/")
                          name
                          (str "clojupyter/" name))
              :namespace (multi-segment (sanitize-ns name))
              :year (year)
              :name (project-name name)
              :sanitized (name-to-path name)}]
    (main/info "Generating new clojupyter-plugin project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["README.md" (render "README.md" data)]
             ["LICENSE.md" (render "LICENSE.md" data)]
             [".gitignore" (render "gitignore" data)]
             ["bin/install" (render "install" data)]
             ["resources"])))
