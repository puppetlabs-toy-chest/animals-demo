(ns animals.server
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.resource :as resources]
            [ring.util.response :as response])
  (:gen-class))

(defn render-app []
  (let [rand-index (->> (rand 100)
                     int
                     (format "%03d"))
        random-kitten (str "http://stupidstuff.org/kitten/kitten" rand-index ".jpg")
        random-puppy "http://www.randomdoggiegenerator.com/randomdoggie.php"]
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body
     (str "<!DOCTYPE html>"
          "<html>"
          "<head>"
          "<link rel=\"stylesheet\" href=\"css/page.css\" />"
          "</head>"
          "<body>"
          "<div>"
          "<p><img src=\"" random-kitten "\"></p>"
          "<p><img src=\"" random-puppy "\"></p>"
          "</div>"
          "<script src=\"js/cljs.js\"></script>"
          "</body>"
          "</html>")}))

(defn handler [request]
  (if (= "/" (:uri request))
      (response/redirect "/help.html")
      (render-app)))

(def app
  (-> handler
    (resources/wrap-resource "public")))

(defn -main [& args]
  (jetty/run-jetty app {:port 3000}))

