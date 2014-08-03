(ns no-agenda-downloader.core-test
  (:require [clojure.test :refer :all]
            [no-agenda-downloader.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest rss-test
  (testing "url doesn't match"
    (is (= "e:/downloads/rss.xml"
          (no-agenda-downloader.core/get-rss)))))
