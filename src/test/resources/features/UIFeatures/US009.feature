Feature:Staff (Personel), hasta bilgilerini gorebilmeli, duzenleyebilmeli ve silebilmemelidir.

  Scenario:TC01 Personel hasta bilgileri sayfasını görüntüleyebilmelidir
    Given Kullanici medunnaURL adresine gider
    Then Kullanici ikonuna tiklar
    Then Kullanici sign in butonuna tiklar
    And Kullanici gecerli bir username girer
    And Kullanici gecerli bir password girer
    And Kullanici sign in buttonuna tiklar
    Then Kullanici mypages butonuna tiklar
    And Kullanici Personel sayfasinda oldugunu dogrular
    Then Kullanici Search Patient butonuna tiklar
    And Kullanici hasta bilgi sayfasinda oldugunu dogrular
    And Kullanici hasta bilgilerini gorebildigini dogrular
    Then Kullanici sayfayi kapatir


  Scenario:TC02 Kullanıcı herhangi bir hasta bilgisini silebilir
    Given Kullanici medunnaURL adresine gider
    Then Kullanici ikonuna tiklar
    Then Kullanici sign in butonuna tiklar
    And Kullanici gecerli bir username girer
    And Kullanici gecerli bir password girer
    And Kullanici sign in buttonuna tiklar
    Then Kullanici mypages butonuna tiklar
    And Kullanici Personel sayfasinda oldugunu dogrular
    Then Kullanici Search Patient butonuna tiklar
    And Kullanici "656-34-1907" SSN Numaralı hasta icin arama yapar
    And Kullanici 2 sn bekler
    Then Kullanici Edit butonuna tiklar
    And Kullanici Create Or Edit a Patient sayfasinda oldugunu dogrular
    And Kullanici 1 sn bekler
    Then Kullanici Description kismini siler
    And Kullanici 2 sn bekler
    And  Kullanici Save butonuna tiklar
    Then Kullanici A Patient is updated with identifier yazısını gorur
    Then Kullanici 2 sn bekler
    Then Kullanici mypages butonuna tiklar
    Then Kullanici Search Patient butonuna tiklar
    And Kullanici "656-34-1907" SSN Numaralı hasta icin arama yapar
    And Kullanici Edit butonuna tiklar
    And Kullanici Description kisminin bos oldugunu dogrular
    And Kullanici 2 sn bekler
    And Kullanici sayfayi kapatir



  Scenario:TC03 Personel, Düzenle düğmesini kullanarak tüm hasta bilgilerini düzenleyebilir
    Given Kullanici medunnaURL adresine gider
    Then Kullanici ikonuna tiklar
    Then Kullanici sign in butonuna tiklar
    And Kullanici gecerli bir username girer
    And Kullanici gecerli bir password girer
    And Kullanici sign in buttonuna tiklar
    Then Kullanici mypages butonuna tiklar
    And Kullanici Personel sayfasinda oldugunu dogrular
    Then Kullanici Search Patient butonuna tiklar
    And Kullanici "656-34-1907" SSN Numaralı hasta icin arama yapar
    And Kullanici 2 sn bekler
    Then Kullanici Edit butonuna tiklar
    And Kullanici Create Or Edit a Patient sayfasinda oldugunu dogrular
    And Kullanici 2 sn bekler
    And Kullanici firstname lastname birthday email phone gender bloodgroup bilgilerini duzenler ve kaydeder
    And Kullanici 2 sn bekler
    Then Kullanici mypages butonuna tiklar
    And Kullanici 1 sn bekler
    Then Kullanici Search Patient butonuna tiklar
    And Kullanici "656-34-1907" SSN Numaralı hasta icin arama yapar
    And Kullanici 2 sn bekler
    Then Kullanici yaptıgı degisiklikleri dogrular
    And Kullanici 2 sn bekler
    And Kullanici sayfayi kapatir


  Scenario:TC04 Personel, SSN'lere göre yeni bir başvuru sahibi arayabilir ve tüm kayıt bilgilerinin doldurulduğunu görebilir
    Given Kullanici medunnaURL adresine gider
    Then Kullanici ikonuna tiklar
    Then Kullanici sign in butonuna tiklar
    And Kullanici gecerli bir username girer
    And Kullanici gecerli bir password girer
    And Kullanici sign in buttonuna tiklar
    Then Kullanici mypages butonuna tiklar
    Then Kullanici Search Patient butonuna tiklar
    And Kullanici "656-34-1907" SSN Numaralı hasta icin arama yapar
    Then Kullanici hasta bilgilerinin oldugunu kontrol eder
    Then Kullanici sayfayi kapatir
























