Feature:Physician (Doktor) "Test Results" islemleri yapabilmeli (My Appointments / Edit / Test Results)

  @US013 @TC01301
  Scenario:TC01301 Test sonuclari talep edildikten ve Staff test sonuçlarını güncelledikten sonra doktor "id,
  name(Urea, Sodium, Glucose etc..), default max value, default min value, test,
  description and the date" bilgilerini görebilmeli
    Given Doktor medunnaURl adresine gider
    Then Doktor account menuye tiklar
    And Doktor sign in butonuna tiklar
    Then Doktor kendi username ve sifresi ile giris yapar
    And Doktor My Pages menusunde ki My Appointments butonuna tiklar
    Then Doktor ekranin saginda gorunen edit butonuna tiklar
    And Doktor Create or Edit an Appointment sayfasina gittigini dogrular
    Then Doktor Show Test Result butonuna tiklar
    And Doktor hastanin View Result butonuna tiklar
    And Doktor id, name, default max value, defaut min value, test, description ve date bilgilerinin gorundugunu test eder
    Then Doktor sayfayi kapatir

  @US013  @TC01302
  Scenario:TC01302 Doktor "Request Impatient" (hastanın yatılı tedavi gormesi) isteginde bulunabilmeli
    Given Doktor medunnaURl adresine gider
    And Doktor account menuye tiklar
    Then Doktor sign in butonuna tiklar
    And Doktor kendi username ve sifresi ile giris yapar
    Then Doktor My Pages menusunde ki My Appointments butonuna tiklar
    And Doktor ekranin saginda gorunen edit butonuna tiklar
    Then Doktor Create or Edit an Appointment sayfasina gittigini dogrular
    And Doktor Request Inpatient butonuna tiklar
    Then Doktor A new in Patient is created with identifier yazisini goruntuler
    Then Doktor sayfayi kapatir

