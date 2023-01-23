@US027DB
Feature:DB kullanarak mesaj dogrulanma
  Scenario:Admin DB ile mesajlari dogrulamalidir
    Given Admin 27 database ile baglanti kurar
    When Admin mesaj bilgilerini alir
    Then Admin mesaj bilgilerini validate eder
    And Admin database baglantisini kapatir
