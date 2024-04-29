Feature: Reservasyonu parsel guncelleme

  Scenario: Olusuturlan rezervasyonu parselleyerek guncelleme
    Given bookingid olusturulur
    And Kullanici rezervasyon icin gereken bilgileri topluyor
    When Kullanici rezervasyonu parselleyerek guncelleme islemini gerceklestirir
    Then Guncellenen parsel kontrol edilir