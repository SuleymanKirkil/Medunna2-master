@UI
Feature:US024 Kullanici hasta hesabiyla giris yaptiginda test sonuclarini ve faturasini gorebilmeli

  Background:
    Given Kullanici medunna ana sayfasina gider
    Given Kullanici sign-in butonuna tiklar


  Scenario:TC_02401 Hasta hesabina girdiginde test sonuclarini gorebilmelidir.

    Given Kullanici gecerli bir "hastaHesabi" ile giris yapar
    And Kullanici MyPages(Patient) butonuna tiklar
    And Kullanici MyAppointments butonuna tiklar
    And Kullanici goruntulemek istedigi test sonuclarindan birisini secer
    And Kullanici sonuclari goruntule butonuna basar
    And Kullanici test sonuclari sayfasinda "ID" bolumunun goruntulendigini dogrular
    And Kullanici test sonuclari sayfasinda "Name" bolumunun goruntulendigini dogrular
    And Kullanici test sonuclari sayfasinda "Default Min Value" bolumunun goruntulendigini dogrular
    And Kullanici test sonuclari sayfasinda "Default Max Value" bolumunun goruntulendigini dogrular
    And Kullanici test sonuclari sayfasinda "Description" bolumunun goruntulendigini dogrular
    And Kullanici test sonuclari sayfasinda "Date" bolumunun goruntulendigini dogrular
    Then Kullanici sayfayi kapatir

  Scenario: TC_02402 Hasta faturasini gorebilmelidir.
    Given Kullanici gecerli bir "hastaHesabi" ile giris yapar
    And Kullanici MyPages(Patient) butonuna tiklar
    And Kullanici MyAppointments butonuna tiklar
    And Kullanici showInvoice butonuna tiklar
    And Kullanici faturasinin gorutulenebildigini dogrular
    Then Kullanici sayfayi kapatir

