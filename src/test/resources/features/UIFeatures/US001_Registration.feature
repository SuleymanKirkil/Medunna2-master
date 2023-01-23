@UI
Feature:US001 Kullanici gecerli veriler girerek kayit islemini tamamlayabilmeli

  Background:
    Given Kullanici medunna ana sayfasina gider
    Given Kullanici register butonuna tiklar


  Scenario:TC_00101 Gecerli bir SSN, 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan olusmalidir.

    Given Kullanici "SSN" yazi kutucuguna tiklar
    And Kullanici gecerli bir "SSN" girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici "SSN" girisi gerekli uyarisi almaz
    And Kullanici hatali "SSN" girisi uyarisi almaz
    Then Kullanici sayfayi kapatir

  Scenario: TC_00102 SSN bos birakilamaz.
    Given Kullanici "SSN" yazi kutucuguna tiklar
    And Kullanici klavyede tab tusuna basar
    And Kullanici "SSN" girisi gerekli uyarisi alir
    Then Kullanici sayfayi kapatir

  Scenario: TC_00103 Herhangi bir karakter iceren ve bos birakilamayan gecerli bir "First Name" olmalidir.
    Given Kullanici "First Name" yazi kutucuguna tiklar
    And Kullanici gecerli bir "First Name" girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici "First Name" girisi gerekli uyarisi almaz
    Then Kullanici sayfayi kapatir

  Scenario: TC_00104 Herhangi bir karakter iceren ve bos birakilamayan gecerli bir "Last Name" olmalidir.
    Given Kullanici "Last Name" yazi kutucuguna tiklar
    And Kullanici gecerli bir "Last Name" girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici "Last Name" girisi gerekli uyarisi almaz
    Then Kullanici sayfayi kapatir


