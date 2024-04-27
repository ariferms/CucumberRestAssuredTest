Feature: Kullanici olarak otel rezervasyonu olusturabilirim

  Scenario: Kullanici bir otel razervasyonu olusturabilir ve rezervasyonu silebilir
    Given Kullanici yeni bir rezervasyon olusturuyor
    And Kullanici rezervasyon icin gereken bilgileri veriyor
    When Kullanici otel rezervasyonu yaratiyor
    Then Rezervasyon basarili bir sekilde olusturuldu
    And Kullanici olusturulan rezervasyonu iptal ediyor