(ns no-agenda-downloader.core
  (:gen-class)
  (:use [clojure.xml :only (parse)])
  (:require [clojure.java.io :as io]))


(defn get-rss []
  "returns the rss url or file location"
  "http://feed.nashownotes.com/rss.xml")


(defn get-feed-seq [location]
  "returns a sequence of xml maps from the specified file"
  (xml-seq (parse location)))


(defn get-xml-elements [rss-data]
  "returns a sequence of xml elements which contain the link to the mp3"
  (filter #(= :enclosure (:tag %)) rss-data))


(defn get-link [n]
  "returns the link from the hashmap"
  ((n :attrs) :url))


(defn get-file-name [url]
  "returns the mp3 file name from the url"
  (.getName (clojure.java.io/file url)))


(defn get-urls []
  "returns a sequence of urls"
  (let [link-seq
        (get-xml-elements
          (get-feed-seq
            (get-rss)))]
    (map get-link link-seq)))


;; helper functions that use the core functions
;; above to process the xml and download the mp3
;; files


(defn print-urls []
  "prints the urls to standard out"
  (let [links (get-urls)]
    (doall (map println links))))


(defn download-episode [url]
  "downloads the file from the specified url"
  (with-open [in (io/input-stream url)
              out (io/output-stream (get-file-name url))]
    (println "Now downloading episode" (get-file-name url))
    (io/copy in out)))


(defn grab-first []
  "returns the first item in the sequence"
  (let [links (get-urls)]
    (download-episode (first links))))


(defn download-all []
  "downloads all files in the url sequence"
  (let [links (get-urls)]
    (doseq [l links]
      (download-episode l))))


(defn -main
  "main method for the no agenda downloader"
  [& args]
  (download-all))
