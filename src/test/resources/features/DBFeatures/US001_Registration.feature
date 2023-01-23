@DB
Feature:US001 Kayıt olmak için SSN, Firstname ve Lastname bilgileri girililebilmelidir.

  Background:
    Given Kullanici Database ile baglanti saglar

  Scenario Outline:TC_00107 Kullanıcı database üzerinden SSN kimliklerini doğrular
    When Kullanici "jhi_user" tablosundan tum kullanicilarin "SSN" bilgilerini alir
    And Kullanici "jhi_user" tablosunun "ssn" sutununda "<ssn>" verisi oldugunu dogrular
    Then Kullanici database ile baglantisini keser
    Examples:
      | ssn         |
      | 303-54-9483 |
      | 030-65-1942 |

