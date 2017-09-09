(ns project-euler.test.util
  (:require [clojure.test :refer :all]
            [project-euler.util :refer :all]))

(deftest test-div?
  (are [n m result] (= (div? n m) result)
    15 3 true
    72 9 true
    11 4 false
    56 12 false))

(deftest test-div-if-can
  (are [n m result] (= (div-if-can n m) result)
    18 6 3
    19 4 19))

(deftest test-square
  (are [n result] (= (square n) result)
    4 16
    9 81
    0 0))

(deftest test-sum
  (are [nums result] (= (sum nums) result)
    (range 11) 55
    [8 91 0 1] 100
    [] 0))

(deftest test-range-from
  (is (= (take 4 (range-from 5)) [5 6 7 8]))
  (is (= (take 5 (range-from 10 3)) [10 13 16 19 22])))

(deftest test-keep-reductions
  (is (= (keep-reductions (fn [sum n] (if (even? n) (+ sum n))) 100 (range 11)) [100 102 106 112 120 130]))
  (is (= (keep-reductions (fn [a b] (throw :unexpected)) 100 [])) []))

(deftest test-remove-from-set
  (is (= (remove-from-set even? (set (range 11))) #{1 3 5 7 9}))
  (is (= (remove-from-set (fn [x] false) (set []))) #{}))

(deftest test-digits
  (are [n result] (= (digits n) result)
    1487 [1 4 8 7]
    6 [6]
    0 [0]))

(deftest test-fib
  (is (= (take 15 (fib)) [0 1 1 2 3 5 8 13 21 34 55 89 144 233 377] (take 15 (fib)))))

(deftest test-prime-candidates
  (is (every? #(some (fn [n] (= n %)) (prime-candidates))
              [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71])))

