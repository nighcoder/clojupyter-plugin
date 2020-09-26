(ns leiningen.new.clojupyter-plugin
  (:require [clojure.string :as str]
            [leiningen.new.templates :refer
              [renderer name-to-path ->files project-name year sanitize-ns multi-segment]]
            [leiningen.core.main :as main]))


(def render (renderer "clojupyter-plugin"))

(defn clojupyter-plugin
  "Clojupyter plugins template"
  [name]
  (let [ns (multi-segment (sanitize-ns name))
        data {:raw-name name
              :namespace ns
              :year (year)
              :name (project-name name)
              :sanitized (name-to-path ns)}]
    (main/info "Generating new clojupyter-plugin project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["src/{{sanitized}}.clj" (render "core.clj" data)]
             ["README.md" (render "README.md" data)]
             ["LICENSE.md" (render "LICENSE.md" data)]
             [".gitignore" (render "gitignore" data)]
             ["bin/install" (render "install" data) :executable true]
             ["bin/uninstall" (render "uninstall" data) :executable true]
             ["bin/version" (render "version" data) :executable true]
             ["bin/install.ps1" (render "install.ps1" data)]
             ["bin/uninstall.ps1" (render "uninstall.ps1" data)]
             ["bin/version.ps1" (render "version.ps1" data)]
             ["examples/{{name}}.ipynb" (render "example.ipynb" data)]
             "resources")))
