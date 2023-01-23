@UI
Feature:US025 Kullanici hasta hesabiyla portala giris yaparak yeni bir randevu olusturabilmeli

  Background:
    Given Kullanici medunna ana sayfasina gider
    Given Kullanici sign-in butonuna tiklar


  Scenario:TC_02501 Hasta hesabina girdiginde test sonuclarini gorebilmelidir.

    Given Kullanici gecerli bir "hastaHesabi" ile giris yapar
    And Kullanici MyPages(Patient) butonuna tiklar
    And Kullanici MakeAnAppointment(Patient) butonuna tiklar
    Then Kullanici "First Name" yazi kutucuguna tiklar
    And Kullanici gecerli bir "First Name" girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici "First Name" girisi gerekli uyarisi almaz
    Then Kullanici "Last Name" yazi kutucuguna tiklar
    And Kullanici gecerli bir "Last Name" girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici "Last Name" girisi gerekli uyarisi almaz
    And Kullanici gecerli bir "SSN" girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici "SSN" girisi gerekli uyarisi almaz
    And Kullanici hatali "SSN" girisi uyarisi almaz
    Then Kullanici "Email" yazi kutucuguna tiklar
    And Kullanici gecerli bir "Email" girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici "Email" girisi gerekli uyarisi almaz
    Then Kullanici "Phone Number" yazi kutucuguna tiklar
    And Kullanici gecerli bir "Phone Number" girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici "Phone Number" girisi gerekli uyarisi almaz
    Then Kullanici "Appointment DateTime" yazi kutucuguna tiklar
    And Kullanici gecerli bir "Appointment DateTime" girer
    And Kullanici klavyede tab tusuna basar
    Then Kullanici Send an Appointment Request butonuna tiklar
    Then Kullanici randevunun tamamlandigi mesajini goruntuler



