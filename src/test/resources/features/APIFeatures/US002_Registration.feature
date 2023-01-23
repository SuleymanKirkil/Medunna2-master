@API
Feature:US002 Kayit olmak icin email ve username bilgileri girilebilmelidir.

  Scenario:TC_00105 Kullanici swagger kullanarak tum kayit bilgilerini alir ve dogrular.


  Scenario Outline:Username API kullanilarak dogrulanmalidir.
    Given Kullanici API ile get request olusturarak tum kayitli kullanicilarin bilgilerini alir
    And Kullanici sistemde kayitli oldugunu bildigi bir "<username>" in response icerisinde oldugunu dogrular

    Examples:
      |username|
      |deon_heaney|



  Scenario Outline:Email API kullanilarak dogrulanmalidir.
    Given Kullanici API ile get request olusturarak tum kayitli kullanicilarin bilgilerini alir
    And Kullanici sistemde kayitli oldugunu bildigi bir "<email>" adresinin response icerisinde oldugunu dogrular

    Examples:
      |email|
      |deon.heaney@gmail.com|

