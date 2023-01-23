Feature:  Kullanıcı bilgileri  girerken doldurulan kullanıcı bilgileri ile aynı oldugunu dogrular

  Scenario: Kullanıcı(Dr) bilgileri "firstname, lastname, email and " girerken doldurulan kullanıcı bilgileri aynı oldugunu dogrular.
    Given kullanici "medunnaUrl" anasayfasinda
    Then kullanici signin butonuna tiklar
    Then kullanici gecerli "drNevalUsername" ve "drNevalPassword"ile giris yapar
    And kullanici  settings ' e tiklar
    And Kullanıcı bilgilerinin register olurken ki ile aynı oldugunu test eder
    And Sayfati kapatir


