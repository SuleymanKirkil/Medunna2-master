Feature: Hasta randevu olusturabilmelidir.


  Scenario: TC01 Make an Appoinment sayfasi neggative test
    Given kulanici medunnaURL adresine gider
    And kullanici Make an Appointment kutusuna tiklar
    And kullanici Make an Appointment sayfasinda Firstname,Lastname,SSN,Email, ve Phone bolumlerini bos birakir
    And ilgili bolumler icin xxxx is required hata mesaji aldigini dogrular






 Scenario: TC02 Make an Appointment sayfasi negative test
   Given kulanici medunnaURL adresine gider
   And kullanici Make an Appointment kutusuna tiklar
   And kullanici Make an Appointment sayfasinda Firstname,Lastname,SSN,Email bolumlerine gecerli degerler girer
   And Phone bolumune ucuncu ve altinci rakamdan sonra - olmayan ve ya on rakamli olmayan bir deger gir
   And Phone number is invalid hata mesaji gozuktugunu dogrular
   And sayfayi kapatir






  Scenario: TC03 Make an Appointment sayfasi possitive test
    Given kulanici medunnaURL adresine gider
    And kullanici Make an Appointment kutusuna tiklar
    And kullanici Make an Appointment sayfasinda Firstname,Lastname,SSN,Email ve Phone bolumlerine gecerli degerler girer
    And Send an Appointment Request butonuna tiklar
    And Appointment registration saved! mesajı goruntulendigini dogrula



  Scenario:TC04 Appointment goruntuleme testi
    Given kulanici medunnaURL adresine gider
    And kullanici ikonuna tiklar
    And kullanici Sign in butonuna tiklar
    And kullanici hasta hesabi ile giris yapar
    And MY PAGES(PATIENTS) butonuna tiklar
    And My Appointments secenegine tiklar
    And Appoinments sayfasindan randevulari görüntüler
    And sayfayi kapatir


