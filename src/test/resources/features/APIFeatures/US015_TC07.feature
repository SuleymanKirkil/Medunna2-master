@TC07
Feature:US 15 Admin tarafınfan hasta olusturma ve duzenleme

  Background:
    Given adminn given api "https://medunna.com"

  Scenario Outline:TC07 API kullanarak declarator doğrulayın
    When admin send a Get request to "/api/patients/<id>"
    Then Kullanici "<id>", "<firstName>""<lastName>", "<phone>", "<adress>", "<description>" bilgilerini validate eder
    Examples:
      | id     | firstName | lastName | phone        | adress                                              | description |
      | 240607  | John     | Wick    | 847-009-7653 | Apt. 729 984 Cory Flat, Lake Lorenborough, MN 33972 | flu         |
  #Scenario: TC07 APİ ile hasta bilgilerini dogrulayin
#
  #  Given  kullanici url'ye get request gonderir ve respense alir
  #  Then  Status code 200 oldugunu ogrenir
  #  And respende deserialize edilir ve hasta bilgileri dogrulanir
