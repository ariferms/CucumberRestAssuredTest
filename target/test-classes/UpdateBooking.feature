Feature: Kullanici rezervasyon bilgilerini guncelleyebilir

  Background:
    Given Guncellenencek bir bookingid olusturulur

  Scenario: Kullanici rezervasyon bilgileri guncelleme
    Given Kullanici rezervasyon guncelleme icin gerekli bilgileri aliyor
    When Kullanici rezervasyon guncelleme islemini gerceklestiriyor
    Then Kullanici rezervasyonun guncel halini kontrol ediyor