Feature:US15 Admin tarafından hasta oluşturma ve düzenleme

  @bir
  Scenario:US15_TC01 Yeni hastalar yalnızca yönetici tarafından olusturulabilmeli
    Given kullanici "medunnaUrl" anasayfasinda
    And EA Kullanici Sag ust kosede bulunan icona tiklar
    And   Kullanici Sign-in butonuna tiklar
    And   Kullanici Admin Username girer
    And   Kullanici Admin Password girer
    And   Kullanici ikinci Sign-in butonuna tiklar
    And   Kullanici items&Titles bolumune tiklar
    And   Kullanici Patient bolumune tiklar
    And   Kullanici acilan Patient sayfasindan Create or edit a Patient kutusuna tiklar
    And   Kullanici hasta kaydi olusturabilmek icin gerekli olan First Name,Last Name, Birt Date, Email, Phone, Gender, Blood Group, Adress,Description, User, Country, StateCity bolumlere veri girisi yapar
    And   Kullanici Save butonun tiklar
    And   Kullanici Yeni Hasta olusturuldugunu alert mesaji ile dogrular

  Scenario:US15_TC02 Yönetici "SSN, First Name, Last Name,
  Birth Date, Phone, Gender, Blood Group, Address,
  Description, Created Date, User, Country and state / City"
  gibi hasta bilgilerini gorebilir.
    Given kullanici "medunnaUrl" anasayfasinda
    And EA Kullanici Sag ust kosede bulunan icona tiklar
    And   Kullanici Sign-in butonuna tiklar
    And   Kullanici Admin Username girer
    And   Kullanici Admin Password girer
    And   Kullanici ikinci Sign-in butonuna tiklar
    And   Kullanici items&Titles bolumune tiklar
    And   Kullanici Patient bolumune tiklar
    And  Kullanici ilk sirada gelen hastanin id numarasina tiklar
    And  Kullanici SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group,Address,Description, Created Date, User, Country and stateCity bilgilerinin gorunurlugunu test eder

  @uc
  Scenario:US15_TC03 Hasta oluşturulduğunda veya güncellendiginde
  yukarıdaki ogelere data girisi yapilabilmeli.
    Given kullanici "medunnaUrl" anasayfasinda
    And EA Kullanici Sag ust kosede bulunan icona tiklar
    And   Kullanici Sign-in butonuna tiklar
    And   Kullanici Admin Username girer
    And   Kullanici Admin Password girer
    And   Kullanici ikinci Sign-in butonuna tiklar
    And   Kullanici items&Titles bolumune tiklar
    And   Kullanici Patient bolumune tiklar
    And  Kullanici ilk sirada gelen hastanin id numarasina tiklar
    And Kullanici edit butonuna tiklar
    And  Kullanici Acilan sayfada  SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group, Address, Description, Created Date, User, Country and stateCity gibi bilgilerden bazilarinda degisiklik yapar
    And   Kullanici EditSave butonun tiklar
    And  Kullanici hasta bilgilerinin guncellendigi dogrulanir

  @tık
  Scenario: TC05 "State", "US state" olmali ve bos bırakılmamalı
    Given kullanici "medunnaUrl" anasayfasinda
    And EA Kullanici Sag ust kosede bulunan icona tiklar
    And   Kullanici Sign-in butonuna tiklar
    And   Kullanici Admin Username girer
    And   Kullanici Admin Password girer
    And   Kullanici ikinci Sign-in butonuna tiklar
    And   Kullanici items&Titles bolumune tiklar
    And   Kullanici Patient bolumune tiklar
    And   Kullanici acilan Patient sayfasindan Create or edit a Patient kutusuna tiklar
    And kullanici gerekli alanlari doldurur
    And kullanici country ve state alanlarini bos bırakir
    And   Kullanici Save butonun tiklar
    And Kullanici 3 saniye bekler
    And Kullanici patient sayfasının cıktıgını test eder

  @dene
  Scenario: TC06 Yönetici herhangi bir hastayı silebilir(Negative Scenerio)
    Given kullanici "medunnaUrl" anasayfasinda
    And EA Kullanici Sag ust kosede bulunan icona tiklar
    And   Kullanici Sign-in butonuna tiklar
    And   Kullanici Admin Username girer
    And   Kullanici Admin Password girer
    And   Kullanici ikinci Sign-in butonuna tiklar
    And   Kullanici items&Titles bolumune tiklar
    And   Kullanici Patient bolumune tiklar
    And  herhangi bir hastanin deleted butonuna basar
    And herhangi bir hastanın silinemedigini dogrular
 