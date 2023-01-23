@US018
Feature:US018 Admin olarak Yeni Physicians Olustur / Guncelle / Goruntule ve Sil

  Background:
    Given Admin medunnaURl adresine gider
    Then Admin account menu altinda bulunan sign in kismindan giris yapar
    And Admin Items&Titles menusunden Physician butonuna tiklar

  @TC01801
  Scenario:TC01801 Admin, butun doktorlarin bilgilerini gorebilmelidir.
    Then Admin tum doktorlarin bilgilerinin goruntulendigini dogrular

  @TC01802
  Scenario Outline:TC01802 Admin, SSN kimligine gore kayitli bir kisiyi secebilir/arayabilir.
    And Admin Create a new Physician butonuna tiklar
    Then Admin use search checkbox isaretler
    And Admin "<SSN>" kismina ilgili physician ssn girer
    Then Admin search user butonuna tiklar
    And Admin user found with search SSN yazisini goruntuler
    Then sayfayi kapatir
    Examples:
      | SSN         |
      | 888-15-8888 |

  @TC01803
  Scenario:TC01803 Kisilerin "firstname,lastname,birth date,phone,adress" bilgileri doldurulabilmeli.
    And Admin id'ye gore sirala butonuna tiklar
    #Then Admin "3" nolu sayfaya gider
    #Then Admin "4" nolu sayfaya gider
    Then Admin 1 nolu sayfada bulunan idsi 239645 olan doktora ait edit butonuna tiklar
    And firstname bolumune yeni isim gonderir
    Then lastname bolumune yeni lastname gonderir
    And birth date bolumune yeni birth date gonderir
    And phone bolumune yeni birth phone gonderir
    And adress bolumune yeni adress gonderir
    Then Bilgileri kaydeder
    Then "239645" idli Bilgilerin degistini goruntuler
    Then sayfayi kapatir


  @TC01804
  Scenario:TC01804 Admin Doktor icin bir uzmanlik alani secebilmeli.
    And Admin id'ye gore sirala butonuna tiklar
    #Then Admin "3" nolu sayfaya gider
    #Then Admin "4" nolu sayfaya gider
    Then Admin 1 nolu sayfada bulunan idsi 239645 olan doktora ait edit butonuna tiklar
    And Uzmanlik alanini farkli bir bolum ile degistirir
    Then Bilgileri kaydeder
    Then "239645" idli Bilgilerin degistini goruntuler
    Then sayfayi kapatir


  @TC01805
  Scenario:TC01805 Admin, doktorun profil resmini saglayabilir.
    And Admin id'ye gore sirala butonuna tiklar
    #Then Admin "3" nolu sayfaya gider
    #Then Admin "4" nolu sayfaya gider
    Then Admin 1 nolu sayfada bulunan idsi 239645 olan doktora ait edit butonuna tiklar
    And Admin doktor icin yeni bir profil fotosu secer
    Then Bilgileri kaydeder
    Then "239645" idli Bilgilerin degistini goruntuler
    Then sayfayi kapatir


  @TC01806
  Scenario:TC01806 Admin mevcut kullanicilar arasindan doktoru secmelidir.
    And Admin id'ye gore sirala butonuna tiklar
    #Then Admin "3" nolu sayfaya gider
    #Then Admin "4" nolu sayfaya gider
    Then Admin 1 nolu sayfada bulunan idsi 239645 olan doktora ait edit butonuna tiklar
    And Admin user bolumunden yeni bir user secer
    Then Bilgileri kaydeder
    Then "239645" idli Bilgilerin degistini goruntuler
    Then sayfayi kapatir


  @TC01807
  Scenario:TC01807 Admin, doktorun Muayene ucretini girebilmelidir. (Exam fee)
    And Admin id'ye gore sirala butonuna tiklar
    #Then Admin "3" nolu sayfaya gider
    #Then Admin "4" nolu sayfaya gider
    Then Admin 1 nolu sayfada bulunan idsi 239645 olan doktora ait edit butonuna tiklar
    And Admin exam fee bolumune yeni bir deger girer
    Then Bilgileri kaydeder
    Then "239645" idli Bilgilerin degistini goruntuler
    Then sayfayi kapatir

  @TC01808
  Scenario:TC01808 Admin, Doktorlarin bilgilerini duzenleyebilir.
    And Admin id'ye gore sirala butonuna tiklar
    #Then Admin "3" nolu sayfaya gider
    #Then Admin "4" nolu sayfaya gider
    Then Admin 1 nolu sayfada bulunan idsi 239645 olan doktora ait edit butonuna tiklar
    And firstname bolumune yeni isim gonderir
    Then lastname bolumune yeni lastname gonderir
    And birth date bolumune yeni birth date gonderir
    And phone bolumune yeni birth phone gonderir
    And adress bolumune yeni adress gonderir
    And Uzmanlik alanini farkli bir bolum ile degistirir
    And Admin exam fee bolumune yeni bir deger girer
    Then Bilgileri kaydeder
    Then "239645" idli Bilgilerin degistini goruntuler
    Then sayfayi kapatir

  @TC01810
  Scenario Outline:TC01810 API kullanarak doktoru dogrulayin
    Given admin asim given api "https://medunna.com"
    When admin asim sends a Get request to "/api/physicians/<id>"
    Then Admin asim "<id>", "firstName", "lastName", "phone", "adress", "<speciality>" bilgilerini validate eder
    Examples:
      | id     | speciality  |
      | 239645 | DERMATOLOGY |

  @TC01811
  Scenario Outline:TC01810 DB kullanarak doktorlari dogrulayin
    Given Admin database ile baglanti kurar
    Then Admin query tanimlar
    And Admin DB ile doktor bilgilerini "<id>", "firstName""lastName", "phone", "<speciality>" dogrular
    Examples:
      | id     | speciality  |
      | 239645 | DERMATOLOGY |

  #@TC01809
  #Scenario:TC01809 Admin mevcut doktorları silebilir.
  #  And Admin id'ye gore sirala butonuna tiklar
  #  #Then Admin "3" nolu sayfaya gider
  #  #Then Admin "4" nolu sayfaya gider
  #  And Admin id "239645" doktora ait delete butonuna tiklar
  #  Then Admin gelen uyarida delete tusuna tiklar
  #  And "239645" idli Bilgilerin degistini goruntuler
  #  Then sayfayi kapatir