(ns bpteste.core-test
  (:require [clojure.test :refer :all]
            [java-time :as time]
            [bpteste.core :as sub]))

(deftest test-patriota
  (testing "Testando acesso de patriota em filmes, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :movie :name "1964: O Brasil entre Armas e Livros", :released-at (time/local-date-time "2019-07-24T20:02:34.691")}
           purchase))
      true {:type               :patriota
            :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
      false {:type               :patriota
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de patriota em series, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :series :name "Brasil - A Última Cruzada", :released-at (time/local-date-time "2019-07-24T20:02:34.691")}
           purchase))
      true {:type :patriota
            :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
      false {:type               :patriota
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de patriota em podcasts, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :podcast :name "Dois Papas - Podcast Cultura Paralela #6", :released-at (time/local-date-time "2020-03-29T20:02:34.363")}
           purchase))
      true {:type :patriota
            :subscription-start (time/local-date-time "2020-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2021-01-24T11:46:22.811")}
      false {:type               :patriota
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de patriota em debates, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :debate :name "O que realmente é a felicidade?", :released-at (time/local-date-time "2020-03-29T20:02:34.353")}
           purchase))
      true {:type :patriota
            :subscription-start (time/local-date-time "2020-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2021-01-24T11:46:22.811")}
      false {:type               :patriota
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de patriota em entrevistas, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :interview :name "Congresso Brasil Paralelo - Rafael Nogueira", :released-at (time/local-date-time "2019-11-16T21:40:51.579")}
           purchase))
      true {:type :patriota
            :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
      false {:type               :patriota
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")})))

(deftest test-premium
  (testing "Testando acesso de premium em filmes, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :movie :name "1964: O Brasil entre Armas e Livros", :released-at (time/local-date-time "2019-07-24T20:02:34.691")}
           purchase))
      true {:type               :premium
            :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
      false {:type               :premium
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de premium em series, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :series :name "Brasil - A Última Cruzada", :released-at (time/local-date-time "2019-07-24T20:02:34.691")}
           purchase))
      true {:type :premium
            :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
      false {:type               :premium
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de premium em podcasts, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :podcast :name "Dois Papas - Podcast Cultura Paralela #6", :released-at (time/local-date-time "2020-03-29T20:02:34.363")}
           purchase))
      true {:type :premium
            :subscription-start (time/local-date-time "2020-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2021-01-24T11:46:22.811")}
      false {:type               :premium
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de premium em debates, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :debate :name "O que realmente é a felicidade?", :released-at (time/local-date-time "2020-03-29T20:02:34.353")}
           purchase))
      true {:type :premium
            :subscription-start (time/local-date-time "2020-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2021-01-24T11:46:22.811")}
      false {:type               :premium
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de premium em entrevistas, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :interview :name "Congresso Brasil Paralelo - Rafael Nogueira", :released-at (time/local-date-time "2019-11-16T21:40:51.579")}
           purchase))
      true {:type :premium
            :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
      false {:type               :premium
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de premium em cursos, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :course :name "Ideologias Políticas: As Diferentes Correntes", :released-at (time/local-date-time "2018-11-20T06:46:47.797")}
           purchase))
      true {:type :premium
            :subscription-start (time/local-date-time "2018-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}
      false {:type               :premium
             :subscription-start (time/local-date-time "2016-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2018-01-24T11:46:22.811")})))

(deftest test-mecenas
  (testing "Testando acesso de mecenas em filmes, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :movie :name "1964: O Brasil entre Armas e Livros", :released-at (time/local-date-time "2019-07-24T20:02:34.691")}
           purchase))
      true {:type               :mecenas
            :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
      false {:type               :mecenas
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de mecenas em series, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :series :name "Brasil - A Última Cruzada", :released-at (time/local-date-time "2019-07-24T20:02:34.691")}
           purchase))
      true {:type :mecenas
            :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
      false {:type               :mecenas
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de mecenas em podcasts, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :podcast :name "Dois Papas - Podcast Cultura Paralela #6", :released-at (time/local-date-time "2020-03-29T20:02:34.363")}
           purchase))
      true {:type :mecenas
            :subscription-start (time/local-date-time "2020-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2021-01-24T11:46:22.811")}
      false {:type               :mecenas
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de mecenas em debates, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :debate :name "O que realmente é a felicidade?", :released-at (time/local-date-time "2020-03-29T20:02:34.353")}
           purchase))
      true {:type :mecenas
            :subscription-start (time/local-date-time "2020-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2021-01-24T11:46:22.811")}
      false {:type               :mecenas
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de mecenas em entrevistas, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :interview :name "Congresso Brasil Paralelo - Rafael Nogueira", :released-at (time/local-date-time "2019-11-16T21:40:51.579")}
           purchase))
      true {:type :mecenas
            :subscription-start (time/local-date-time "2019-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2020-01-24T11:46:22.811")}
      false {:type               :mecenas
             :subscription-start (time/local-date-time "2017-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}))

  (testing "Testando acesso de mecenas em cursos, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :course :name "Ideologias Políticas: As Diferentes Correntes", :released-at (time/local-date-time "2018-11-20T06:46:47.797")}
           purchase))
      true {:type :mecenas
            :subscription-start (time/local-date-time "2018-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}
      false {:type               :mecenas
             :subscription-start (time/local-date-time "2016-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2018-01-24T11:46:22.811")}))

  (testing "Testando acesso de mecenas em cursos, em caso de sucesso e caso de validade de assinatura vencida."
    (are [result purchase]
      (= result
         (sub/can-access?
           {:type :patron :name "Ideologias Políticas: As Diferentes Correntes", :released-at (time/local-date-time "2018-11-20T06:46:47.797")}
           purchase))
      true {:type :mecenas
            :subscription-start (time/local-date-time "2018-01-24T11:46:22.811")
            :subscription-end   (time/local-date-time "2019-01-24T11:46:22.811")}
      false {:type               :mecenas
             :subscription-start (time/local-date-time "2016-01-24T11:46:22.811")
             :subscription-end   (time/local-date-time "2018-01-24T11:46:22.811")})))
