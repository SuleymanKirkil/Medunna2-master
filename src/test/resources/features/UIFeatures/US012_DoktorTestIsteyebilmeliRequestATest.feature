Feature:Physician (Doktor) test isteyebilmeli (My Appointments/Edit/Request A Test)

  @US012 @TC1201
  Scenario:TC01201 Doctor test isteyebilmeli "Request A Test"
    Given Doktor medunnaURl adresine gider
    Then Doktor account menuye tiklar
    And Doktor sign in butonuna tiklar
    And Doktor kendi username ve sifresi ile giris yapar
    Then Doktor My Pages menusunde ki My Appointments butonuna tiklar
    And Doktor ekranin saginda gorunen edit butonuna tiklar
    Then Doktor Create or Edit an Appointment sayfasina gittigini dogrular
    And Doktor Request a test butonunun tiklanabilir oldugunu test eder
    Then Doktor sayfayi kapatir

  @US012 @US01201202
  Scenario:TC01202 Test iceriginde "Glucose, Urea, Creatinine, Sodium, Potassium,
  Total protein, Albumin, Hemoglobin" secenekleri olmali
    Given Doktor medunnaURl adresine gider
    Then Doktor account menuye tiklar
    And Doktor sign in butonuna tiklar
    And Doktor kendi username ve sifresi ile giris yapar
    Then Doktor My Pages menusunde ki My Appointments butonuna tiklar
    And Doktor ekranin saginda gorunen edit butonuna tiklar
    Then Doktor Request A Test butonuna tiklar
    And Doktor Glucose, Urea, Creatinine, Sodium, Potassium, Total protein, Albumin, Hemoglobin seceneklerinin oldugunu dogrular
    Then Doktor sayfayi kapatir
