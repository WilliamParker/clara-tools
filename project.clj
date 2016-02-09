(defproject org.toomuchcode/clara-tools "0.1.2-SNAPSHOT"

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.145"]
                 [prismatic/schema "1.0.1"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [compojure "1.4.0"]
                 [org.toomuchcode/clara-rules "0.10.0"]
                 [cljs-ajax "0.2.6"]
                 [hiccup "1.0.5"]
                 [secretary "1.2.3"]
                 [reagent "0.5.1"]]

  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :java-source-paths ["src/main/java"]
  :lein-release {:deploy-via :clojars}
  :plugins [[lein-cljsbuild "1.1.0"]
            [lein-ring "0.9.7"]]
  :hooks [leiningen.cljsbuild]

  :cljsbuild {:builds
              [{:source-paths ["src/main/clojurescript"]
                :compiler {
                           :output-to "resources/public/js/clara-tools.js"
                           :optimizations :whitespace
                           :pretty-print true}}]}

  ; See https://github.com/weavejester/lein-ring#web-server-options for the
  ; various options available for the lein-ring plugin
  :ring {:handler clara.tools.ui.server/routes
         :nrepl {:start? true
                 :port 9998}}

  :scm {:name "git"
        :url "https://github.com/rbrush/clara-tools"}

  :pom-addition [:developers [:developer
                              [:id "rbrush"]
                              [:name "Ryan Brush"]
                              [:url "http://www.toomuchcode.org"]]]
  :deploy-repositories [["snapshots" {:url "https://oss.sonatype.org/content/repositories/snapshots/"
                                      :creds :gpg}]])
