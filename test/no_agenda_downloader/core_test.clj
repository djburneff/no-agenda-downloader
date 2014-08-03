;   Copyright (c) D James Burneff. All rights reserved.
;   This program is free software: you can redistribute it and/or modify
;   it under the terms of the GNU General Public License as published by
;   the Free Software Foundation, either version 3 of the License, or
;   (at your option) any later version.
;
;   This program is distributed in the hope that it will be useful,
;   but WITHOUT ANY WARRANTY; without even the implied warranty of
;   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
;   GNU General Public License for more details.
;
;   You should have received a copy of the GNU General Public License
;   along with this program.  If not, see http://www.gnu.org/licenses/.

(ns no-agenda-downloader.core-test
  (:require [clojure.test :refer :all]
            [no-agenda-downloader.feed :refer :all]))

(def test-url "http://feed.nashownotes.com/rss.xml")
(def file-name "NA-628-2014-06-22-Final.mp3")
(def file-name-url "http://mp3s.nashownotes.com/NA-628-2014-06-22-Final.mp3")
(def url-map { :attrs {
                      :url file-name-url
                      :length "144478324"
                      :type "audio/mpeg" }})

(deftest rss-test
  (testing "url doesn't match"
    (is (= test-url
          (#'no-agenda-downloader.feed/get-rss)))))

(deftest file-name-test
  (testing "file name didn't match"
    (is file-name
        (#'no-agenda-downloader.feed/get-file-name file-name-url))))

(deftest url-map-test
  (testing "URL's do not match"
    (is file-name-url
        (#'no-agenda-downloader.feed/get-link url-map))))
