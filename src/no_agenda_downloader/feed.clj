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

(ns no-agenda-downloader.feed
  (:use [clojure.xml :only (parse)])
  (:require [clojure.java.io :as io]))

;; private

(defn- get-rss []
  "returns the rss url or file location"
  "http://feed.nashownotes.com/rss.xml")


;(defn- get-feed-seq [location]
;  "returns an xml map sequence from the specified rss file/stream"
;  (xml-seq (parse location)))


;(defn- get-xml-elements [rss-data]
;  "returns a sequence of xml elements which contain the link to the mp3"
;  (filter #(= :enclosure (:tag %)) rss-data))


(defn- get-url-sequence [location]
  (filter #(= :enclosure (:tag %))
          (xml-seq (parse location))))

;; public

(defn get-link [n]
  "returns the link from the hashmap"
  ((n :attrs) :url))


(defn get-file-name [url]
  "returns the mp3 file name from the url"
  (.getName (clojure.java.io/file url)))


(defn get-urls []
  "returns a sequence of urls"
  (let [link-seq (get-url-sequence (get-rss))]
    (map get-link link-seq)))


(defn download-episode [url]
  "downloads the file from the specified url"
  (with-open [in (io/input-stream url)
              out (io/output-stream (get-file-name url))]
    (println "Now downloading episode" (get-file-name url))
    (io/copy in out)))
