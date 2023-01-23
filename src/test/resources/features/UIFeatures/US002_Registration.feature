@UI
Feature:US002 Kayit olmak icin email ve username bilgileri girilebilmelidir.

  Background:
    Given Kullanici medunna ana sayfasina gider
    Given Kullanici register butonuna tiklar


  Scenario:TC_00201 Herhangi bir karakter içeren ve boş bırakılamayan geçerli bir "Username" olmalıdır.

    Given Kullanici "Username" yazi kutucuguna tiklar
    And Kullanici gecerli bir "Username" girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici "Username" girisi gerekli uyarisi almaz
    Then Kullanici sayfayi kapatir

  Scenario: TC_00203 Email adresi "@" ve "." karakterleri olmadan doldurulamamalıdır.
    Given Kullanici "Email" yazi kutucuguna tiklar
    And Kullanici gecerli bir "Email" girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici "Email" girisi gerekli uyarisi almaz
    And Kullanici hatali "Email" girisi uyarisi almaz
    And Kullanici bes karakterden az bir mail girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici hatali "Email" girisi uyarisi alir
    And Kullanici "@" den sonra "." bulunmayan bir mail girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici hatali "Email" girisi uyarisi alir
    And Kullanici "@" ile "." arasında karakter bulunmayan bir mail girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici hatali "Email" girisi uyarisi alir
    And Kullanici "@" ile "." arasında ozel karakter bulunan bir mail girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici hatali "Email" girisi uyarisi alir
    And Kullanici "." dan sonra ozel karakter iceren bir mail girer
    And Kullanici klavyede tab tusuna basar
    And Kullanici hatali "Email" girisi uyarisi alir
    Then Kullanici sayfayi kapatir

  Scenario: TC_00204 Email boş bırakılamaz.
    Given Kullanici "Email" yazi kutucuguna tiklar
    And Kullanici klavyede tab tusuna basar
    And Kullanici "Email" girisi gerekli uyarisi alir
    Then Kullanici sayfayi kapatir

