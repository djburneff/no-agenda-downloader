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

(ns no-agenda-downloader.core
  (:gen-class)
  (:require [no-agenda-downloader.feed :as feed]))


(defn print-urls []
  "prints the urls to standard out"
  (let [links (feed/get-urls)]
    (doall (map println links))))


(defn grab-first []
  "returns the first item in the sequence"
  (let [links (feed/get-urls)]
    (feed/download-episode (first links))))


(defn download-all []
  "downloads all files in the url sequence"
  (let [links (feed/get-urls)]
    (doseq [l links]
      (feed/download-episode l))))


(defn -main
  "main method for the no agenda downloader"
  [& args]
  (print-urls))
