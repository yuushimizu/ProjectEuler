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

(deftest test-reverse-number
  (are [n result] (= (reverse-number n) result)
    1234 4321
    800 8
    0 0))

(deftest test-fib
  (is (= (take 15 (fib)) [0 1 1 2 3 5 8 13 21 34 55 89 144 233 377] (take 15 (fib)))))

(deftest test-primes
  (is (= (take-while #(< % 1000) (primes))
         [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 103 107 109 113 127 131 137 139 149 151 157 163 167 173 179 181 191 193 197 199 211 223 227 229 233 239 241 251 257 263 269 271 277 281 283 293 307 311 313 317 331 337 347 349 353 359 367 373 379 383 389 397 401 409 419 421 431 433 439 443 449 457 461 463 467 479 487 491 499 503 509 521 523 541 547 557 563 569 571 577 587 593 599 601 607 613 617 619 631 641 643 647 653 659 661 673 677 683 691 701 709 719 727 733 739 743 751 757 761 769 773 787 797 809 811 821 823 827 829 839 853 857 859 863 877 881 883 887 907 911 919 929 937 941 947 953 967 971 977 983 991 997])))
