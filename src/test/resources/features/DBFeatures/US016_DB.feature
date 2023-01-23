@US16_DB
Feature: oda bilgilerini dogrula

  Scenario: oda bilgileri dogrulama
    Given Kullanici database ile baglanti kurar
    And Odalar tablosunda oda bilgisini "roomID","roomNumber","roomType","statusRooms","descriptionRooms"kontrol eder
