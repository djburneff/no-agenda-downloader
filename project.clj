(defproject no-agenda-downloader "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "GNU GENERAL PUBLIC LICENSE"
            :url "http://www.gnu.org/licenses/"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot no-agenda-downloader.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
