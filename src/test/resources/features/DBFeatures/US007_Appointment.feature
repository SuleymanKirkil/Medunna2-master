Feature:US007 DB kullanarak randevulari dogrulama
  Scenario: DB kullanarak randevular dogrulanabilmeli
    Given Kullanici DB ile baglanti kurar
    When Kullanici randevu bilgilerini alir
    Then Kullanici randevu bilgilerini validate eder
    And Kullanici DB baglantisini kapatir




