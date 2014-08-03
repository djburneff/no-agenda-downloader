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

(defproject no-agenda-downloader "0.1.0-SNAPSHOT"
  :description "This application wil download the latest
episodes from the No Agenda Show Podcast"
  :url "https://github.com/djburneff/no-agenda-downloader"
  :license {:name "GNU GENERAL PUBLIC LICENSE"
            :url "http://www.gnu.org/licenses/"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot no-agenda-downloader.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
