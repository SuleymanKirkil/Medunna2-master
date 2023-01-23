@US16_API
Feature:Validate Room creation by Admin. Create View, Update, Delete with API

  Background:
    Given user given api "https://medunna.com"


  Scenario Outline:API create ile odalari dogrulama
    When admin sends a post request to
    Then Kullanici "<description>""<price>", "<roomNumber>", "<roomType>" bilgilerini validate eder
    Examples:
      |  | description | price | roomNumber | roomType |
      |  | Team50      | 333   | 10044      | DELUXE   |


  @US16_API_TC02
    @ApiRegistrant
  Scenario Outline:TC01810 API kullanarak declarator doğrulayın
    When admin sends a Get request to "/api/rooms/<id>"
    Then Kullanici "<id>", "<description>""<price>", "<roomNumber>", "<roomType>" bilgilerini validate eder
    Examples:
      | id | description | price | roomNumber | roomType |
      | 204476  | Team50      | 333   | 3333       | DELUXE   |


  @US16_API_TC03
  @ApiRegistrant
  Scenario:Rooms api with PUT request
    Given kullanici roomlar icin put request yapar
    Then Kullanici response cod 200 oldugunu dogrular


  @US16_API_TC04
  @ApiRegistrant
  Scenario: admin olusturulan oda siler
    Given Admin URL'e oda icin delete istegi gonderir
    And Kullanici response cod 204 oldugunu dogrular
