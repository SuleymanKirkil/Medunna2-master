@DB
Feature:US002 Kayit olmak icin email and username bilgileri girilebilmelidir.

  Background:
    Given Kullanici Database ile baglanti saglar

  Scenario: TC_00206 Email database kullanilarak dogrulanmalidir.
    Given Kullanici "jhi_user" tablosundan tum kullanicilarin "email" bilgilerini alir
    And Kullanici "jhi_user" tablosunun "email" sutununda "edwardo.bartoletti@yahoo.com" verisi oldugunu dogrular
    Then Kullanici database ile baglantisini keser


