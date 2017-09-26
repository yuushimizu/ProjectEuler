(ns project-euler.util.predicates
  (:refer-clojure :exclude [and or = not= < <= > >=])
  (:require [clojure.core :as core]
            [project-euler.util :as util]))

(defn div? [n]
  #(util/div? % n))

(defn and [f & fns]
  (reduce (fn [pred f] #(core/and (pred %) (f %))) f fns))

(defn or [f & fns]
  (reduce (fn [pred f] #(core/or (pred %) (f %))) f fns))

(defn = [x]
  #(core/= x %))

(defn not= [x]
  #(core/not= x %))

(defn < [n]
  #(core/< % n))

(defn <= [n]
  #(core/<= % n))

(defn > [n]
  #(core/> % n))

(defn >= [n]
  #(core/>= % n))
