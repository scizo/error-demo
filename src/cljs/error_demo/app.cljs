(ns error-demo.app
  (:require [om.core :as om :include-macros true]
            [om-bootstrap.nav :as n]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as dom :include-macros true]))

(def app-state
  (atom {}))

(defcomponent navbar [data owner]
  (render [_]
    (n/navbar
      {:brand (dom/a {:class "navbar-brand row" :href "/"}
                (dom/img {:src "images/removed.png" :width "200" :height "52" :alt "removed"})
                (dom/span "something"))})))

(defcomponent main [data owner]
  (render [_]
    (dom/div {:class "app"}
      (->navbar {})
      (dom/div {:class "container"} "hello, world")
      )
    ))

(defn init []
  (om/root main app-state
           {:target (. js/document (getElementById "container"))}))
