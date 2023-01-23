Feature:Staff hastalar için randevuları görür

  Scenario: TC01 Personel hastanin randevu tarihini güncelleyebilir.
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
    And Kullanici Show Appointment Butonuna tiklar
    And  Kullanici "ID " bilgisine gore  "212305" olan randevu icin Edit butonuna tiklar
    Then Kullanici randevu saatini gunceller
    And Kullanici Save butonuna tiklar
    And Kullanici "212-34-1907" SSN Numaralı hasta icin arama yapar
    And Kullanici 2 sn bekler
    And Kullanici Show Appointment Butonuna tiklar
    And Kullanici 2 sn bekler
    Then Kullanici guncellenen randevulari dogrular

  Scenario: TC02 Personel "STATUS"u "UNAPPROVED" yapabilir
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
    And Kullanici 1 sn bekler
    And  Kullanici "ID " bilgisine gore  "212305" olan randevu icin Edit butonuna tiklar
    And Kullanici 1 sn bekler
    Then Kullanici Status menusunu UNAPPROVED yapar
    Then Kullanici Save butonuna tiklar
    And Kullanici "212-34-1907" SSN Numaralı hasta icin arama yapar
    And Kullanici 2 sn bekler
    Then Kullanici Show Appointment Butonuna tiklar
    And Kullanici Status durumunun UNAPPROVED oldugunu dogrular

  Scenario: TC03 Personel "STATUS"u "PENDING" yapabilir
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
    And Kullanici 1 sn bekler
    And  Kullanici "ID " bilgisine gore  "212305" olan randevu icin Edit butonuna tiklar
    And Kullanici 1 sn bekler
    Then Kullanici Status menusunu PENDING yapar
    Then Kullanici Save butonuna tiklar
    And Kullanici "212-34-1907" SSN Numaralı hasta icin arama yapar
    And Kullanici 2 sn bekler
    Then Kullanici Show Appointment Butonuna tiklar
    And Kullanici Status durumunun PENDING oldugunu dogrular


  Scenario: TC04 Personel "STATUS"u "CANCELLED" yapabilir
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
    And Kullanici 1 sn bekler
    And  Kullanici "ID " bilgisine gore  "212305" olan randevu icin Edit butonuna tiklar
    And Kullanici 1 sn bekler
    Then Kullanici Status menusunu CANCELLED yapar
    Then Kullanici Save butonuna tiklar
    And Kullanici "212-34-1907" SSN Numaralı hasta icin arama yapar
    And Kullanici 2 sn bekler
    Then Kullanici Show Appointment Butonuna tiklar
    And Kullanici Status durumunun CANCELLED oldugunu dogrular


  Scenario: TC05 Personel "STATUS"u "COMPLETED" yapamamalidir
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
    And Kullanici 1 sn bekler
    And  Kullanici "ID " bilgisine gore  "212305" olan randevu icin Edit butonuna tiklar
    And Kullanici 1 sn bekler
    Then Kullanici Status menusunde COMPLETED unclickable olmalidir

  Scenario: TC06 Staff "Anamnesis (Hastalık Geçmişi), Treatment ( Tedavi) veya Diagnosis(Teşhis)" kısımlarına erisememelidir
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
    And Kullanici Edit butonuna tiklar
    And Kullanici sayfayi asagi indirir
    And Kullanici Anamnesis, Treatment, Diagnosis textbox'in isEnable olmadıgını dogrular


  Scenario: TC07 Staff Hasta için gerekli doktoru seçebilmeli ve randevuyu oluşturmalı.
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
    And  Kullanici "ID" bilgisine gore  "212305" olan randevu icin Edit Butonuna tiklar
    Then Kullanici Physician secer
    And Kullanici Save butonuna tiklar
    And Kullanici "212-34-1907" SSN Numaralı hasta icin arama yapar
    And Kullanici Show Appointment Butonuna tiklar
    And Kullanici sectigi doktoru dogrular








