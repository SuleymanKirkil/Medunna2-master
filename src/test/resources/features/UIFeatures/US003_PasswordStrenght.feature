@UI
Feature: US003 Password Strength

  @us003
  Scenario: TC001 Password uzunlugu 7ye esit veya buyukse Password Strength seviyesinin degistigi gorulmeli
    Given kullanici "medunnaUrl" anasayfasinda
    Then kullanici user sembolune basar
    And kullanici register butonuna basar
    And kucuk harf eklenince password strength kontrol eder
    And buyuk harf eklenince password strength kontrol eder
    And sayi eklenince password strength kontrol eder
    And ozel karakter password strength kontrol eder
    And password uzunlugu en az 7 oldugunu kontrol eder

  @us003
  Scenario Outline: TC001 Password uzunlugu 7den kucukse Password Strength seviyesinin degistigi gorulmeli
    Given kullanici "medunnaUrl" anasayfasinda
    Then kullanici user sembolune basar
    And kullanici register butonuna basar
    And kucuk harf "<kucukharf>" eklenince password strength kontrol eder
    And buyuk harf "<buyukharf>" eklenince password strength kontrol eder
    And "<sayi>" eklenince password strength kontrol eder
    And ozel karakter "<ozelkarakter>" password strength kontrol eder

    Examples:
      | kucukharf | buyukharf | sayi | ozelkarakter |
      | d         | D         | 9    | !            |
      | dd        | DD        | 99   | !            |
      | ddd       | DDD       | 9    | !            |
      | dddd      | DDDD      | 9    | !            |
