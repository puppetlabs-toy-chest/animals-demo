(ns hello-world.test.server
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer [request]]
            [hello-world.server :refer :all]))

(deftest does-it-respond?
  (let [{:keys [status body]} (app (request :get "/app"))]
    (testing "the app responds to a 200"
      (is (= status 200)
          (re-find #"Click me!" body)))))
