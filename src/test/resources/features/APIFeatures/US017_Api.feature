@API_US017_TC01
Feature:Api ile Dogrulama


  Scenario:Api Get Request ile dogrulama
    Given admin given api "https://medunna.com"
    Then admin sends a Get request to "/api/c-test-items/221948"
    And Validate the response


  @API_US017_TC02
    Scenario: Api Post Request ile testItem olusturma
    Given Admin send the post request
    And Admin post request validation yapar
