(ns animals.test.server
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer [request]]
            [animals.server :refer :all]))

(deftest does-it-respond?
  (testing "the app responds to a 200"
    (let [{:keys [status body]} (app (request :get "/app"))]
      (is (= status 200)))))

(deftest is-there-a-cat?
  (testing "there is a cat on the page"
    (let [{:keys [body]} (app (request :get "/app"))]
      (is (re-find #"img\s+src=[^\s]+kitten[^\s]+\.jpg" body)))))

(deftest is-there-a-dog?
  (testing "there is a dog on the page"
    (let [{:keys [body]} (app (request :get "/app"))]
      (is (re-find #"img\s+src=[^\s]+doggie[^\s]+\.php" body)))))
