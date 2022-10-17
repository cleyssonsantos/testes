(ns bpteste.core
  (:require [java-time :as time]))

(defn can-access? [object purchase]
  (cond
    (= (:type object) :movie)
    (and (or (= (:type purchase) :patriota)
             (= (:type purchase) :premium)
             (= (:type purchase) :mecenas))
         (time/before? (:subscription-start purchase)
                       (:released-at object)
                       (:subscription-end purchase)))

    (= (:type object) :series)
    (and (or (= (:type purchase) :patriota)
             (= (:type purchase) :premium)
             (= (:type purchase) :mecenas))
         (time/before? (:subscription-start purchase)
                       (:released-at object)
                       (:subscription-end purchase)))

    (= (:type object) :podcast)
    (and (or (= (:type purchase) :patriota)
             (= (:type purchase) :premium)
             (= (:type purchase) :mecenas))
         (time/before? (:subscription-start purchase)
                       (:released-at object)
                       (:subscription-end purchase)))

    (= (:type object) :debate)
    (and (or (= (:type purchase) :patriota)
             (= (:type purchase) :premium)
             (= (:type purchase) :mecenas))
         (time/before? (:subscription-start purchase)
                       (:released-at object)
                       (:subscription-end purchase)))

    (= (:type object) :interview)
    (and (or (= (:type purchase) :patriota)
             (= (:type purchase) :premium)
             (= (:type purchase) :mecenas))
         (time/before? (:subscription-start purchase)
                       (:released-at object)
                       (:subscription-end purchase)))

    (= (:type object) :course)
    (and (or
           (= (:type purchase) :premium)
           (= (:type purchase) :mecenas))
         (time/before? (:subscription-start purchase)
                       (:released-at object)
                       (:subscription-end purchase)))

    (= (:type object) :patron)
    (and (= (:type purchase) :mecenas)
         (time/before? (:subscription-start purchase)
                       (:released-at object)
                       (:subscription-end purchase)))))
