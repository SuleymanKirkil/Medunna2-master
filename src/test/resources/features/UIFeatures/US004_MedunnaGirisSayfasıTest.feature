@UI
Feature: Kullanici gecerli kimlik bilgileriyle giris sayfasina erisebilmeli


  Scenario: TC001 Giris sayfası testi
    Given kulanici medunnaURL adresine gider
    Then kullanici ikonuna tiklar
    And kullanici Sign in butonuna tiklar
    And kullanici giris sayfasi ekraninda Did you forget password? secenegi oldugunu dogrular
    And kullanici giris sayfasi ekraninda You don't have an account yet? Register a new account secenegi oldugunu test eder
    And kullanici giris sayfasi ekraninda Cancel butonu oldugunu test eder
    And sayfayi kapatir



    Scenario:TC002 Login olabilme testi
      Given kulanici medunnaURL adresine gider
      Then kullanici ikonuna tiklar
      And kullanici Sign in butonuna tiklar
      And kullanici gecerli bir username girer
      And kulanici gecerli bir password girer
      And kullanici Sign in kutusuna tiklar
      And sayfada kullanici adinin yazdigini dogrular
      And sayfayi kapatir

