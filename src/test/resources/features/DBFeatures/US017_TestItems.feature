@DB_US017
Feature: Admin DB ile test itemleri dogrulamali

  Scenario: Admin DB ile test item bilgilerini almali ve dogrulamali
    Given Admin database ile baglanti kurar
    When Admin query tanimlar ve testItems olusturdugunu DB ile kontrol eder
    And  Admin DB'i kapatir
