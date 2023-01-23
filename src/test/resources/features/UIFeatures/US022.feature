Feature:US022 Hasta Test sonuçları (Staff)

  Scenario:TC01 Kullanıcı (Staff) hastanın SSN id ile arama yapabilir.
    Given Kullanici medunnaURL adresine gider
    Then Kullanici ikonuna tiklar
    Then Kullanici sign in butonuna tiklar
    And Kullanici gecerli bir username girer
    And Kullanici gecerli bir password girer
    And Kullanici sign in buttonuna tiklar
    Then Kullanici mypages butonuna tiklar
    And Kullanici Personel sayfasinda oldugunu dogrular
    Then Kullanici Search Patient butonuna tiklar
    And Kullanici SSN textbox'in Enable oldugunu dogrular
    Then Kullanici "212-34-1907" SSN Numaralı hasta icin arama yapar
    Then Kullanici 2 sn bekler
    And Kullanici aranan SSN ile gelen hasta SNN'inini dogrular



  Scenario: TC02 Kullanıcı (Staff) test sonuçlarını görebilmelidir.
    Given Kullanici medunnaURL adresine gider
    Then Kullanici ikonuna tiklar
    Then Kullanici sign in butonuna tiklar
    And Kullanici gecerli bir username girer
    And Kullanici gecerli bir password girer
    And Kullanici sign in buttonuna tiklar
    Then Kullanici mypages butonuna tiklar
    And Kullanici Personel sayfasinda oldugunu dogrular
    Then Kullanici Search Patient butonuna tiklar
    And Kullanici "212-34-1907" SSN Numaralı hasta icin arama yapar
    And Kullanici 2 sn bekler
    Then Kullanici Show Appointment Butonuna tiklar
    And  Kullanici "ID " bilgisine gore  "212305" olan randevu icin Show Test butonuna tiklar
    Then Kullanici View Result butonuna tiklar
    Then Kullanici testlerin goruldugunu dogrular


  Scenario: TC03 Kullanıcı (Staff) "ID, Date, Result, description, Created date, ..." gibi sonuç bilgilerini görebilmeli ve guncelleyebilmelidir
    Given Kullanici medunnaURL adresine gider
    Then Kullanici ikonuna tiklar
    And Kullanici 2 sn bekler
    Then Kullanici sign in butonuna tiklar
    And Kullanici gecerli bir username girer
    And Kullanici gecerli bir password girer
    And Kullanici sign in buttonuna tiklar
    Then Kullanici mypages butonuna tiklar
    And Kullanici Personel sayfasinda oldugunu dogrular
    Then Kullanici Search Patient butonuna tiklar
    And Kullanici "212-34-1907" SSN Numaralı hasta icin arama yapar
    And Kullanici 2 sn bekler
    Then Kullanici Show Appointment Butonuna tiklar
    And  Kullanici "ID " bilgisine gore  "212305" olan randevu icin Show Test butonuna tiklar
    Then Kullanici View Result butonuna tiklar
    And  Kullanici "Name" bilgisine gore  "Urea" olan randevu icin Edit Butonuna tiklar
    And Kullanici ID,Date, Result, Description gorebilmelidir
    And Kullanici ID,Date, Result, Description guncelleyebilmelidr
    And Kullanici test result sayfasinda save butonuna tiklar