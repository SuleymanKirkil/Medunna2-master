Feature:  Tum kullaniciler ile bilgiler basarili sekilde guncellenir

  @medunna
  Scenario Outline: kullanici firstname lastname ve emailini gunceller
    Given kullanici "medunnaUrl" anasayfasinda
    Then kullanici signin butonuna tiklar
    Then kullanici gecerli "<Username>" ve "<Password>"ile giris yapar
    And kullanici  settings ' e tiklar
    And Kullanici  Firstname secenegini güncelleyebilmeli
    And  Kullanici 3 saniye bekler
    And Kullanici  Lastname secenegini güncelleyebilmeli
    And  Kullanici 3 saniye bekler
    And Kullanici  "<email>" secenegini güncelleyebilmeli
    And  Kullanici 3 saniye bekler
    And  Kullanici  save butonuna basar
    And Kullanici 3 saniye bekler
    And Kullanici Settings saved yazisinin ciktigini gorur
    And Sayfati kapatir
    Examples:
      | Username        | Password        | email      |
      | doktorUsername  | doktorPassword  | passemail  |
      | stafffUsername   | stafffPassword   | passemail2 |
      | patientUsername | patientPassword | passemail3 |

