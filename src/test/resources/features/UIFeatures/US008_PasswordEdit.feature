Feature:US008_password_update

  Background:Password sayfasina giris.
  @US008
  Scenario:US08_password_edit
    Given kullanici  medunnaURl adresine gider
    And Kullanıcı "Account "menusune  tiklar
    And Kullanıcı "SİNG İN" butonuna tiklar
    And  Kullanıcı  username ve passwordu girer
    And  Kullanıcı "SİNG İN2" kutusuna tiklar
    And Kullanıcı basari ile giris yapildigini dogrular
    And Kullanıcı Account Pagede ki Account menusune tiklar
    Then Kullanıcı "PASSWORD" a tıklar.


  @US008_TC_0001
  Scenario Outline:Yeni password onaylanabilmeli
    And Kullanıcı "<currentPassword>" kısmına yenı password girer
    And Kullanıcı new passworda  "<newPassword>"   girer.
    And Kullanıcı confimation passworda "<confirmationPassword>" girer
    And kullanıcı  "SAVE" e tiklar.
    And Kullanıcı "PASSWORD CHANGED" yazisini dogrular.


    Examples:
      | currentPassword | newPassword | confirmationPassword |
      | 2345670         | 3456780     | 3456780                    |

  @US08_TC_0002
  Scenario Outline:Daha guclu bir password icin kucuk harf ekleme

    And Kullanıcı New Password kismini temizler.
    And Kullanıcı new password kismina  "<newpassword>"  gonderir
    And Kullanıcı strenght barin tek tik oldugunu dogrular
    And Kullanıcı new password kismina kucuk harf "<addcharacter>" ekler
    And Kullanıcı strenght barin iki tik oldugunu dogrular

    Examples:
      | newpassword | addcharacter |
      | 123456      | e            |

  @US08_TC_0003
  Scenario Outline:Daha guclu bir password icin buyuk harf ekleme

    And Kullanıcı New Password kismini temizler.
    And Kullanıcı new password kismina  "<newpassword>"  gonderir
    And Kullanıcı strenght barin tek tik oldugunu dogrular
    And Kullanıcı new password kismina buyuk harf "<addcharacter>" ekler
    And Kullanıcı strenght barin iki tik oldugunu dogrular


    Examples:
      | newpassword | addcharacter |
      | 1234560     | D            |


  @US08_TC_0004
  Scenario Outline:Daha guclu bir password icin rakam ekleme
    And Kullanıcı New Password kismini temizler.
    And Kullanıcı new password kismina  "<newpassword>"  gonderir
    And kullanici strenght barin dort tik oldugunu dogrular.
    And kullanici new password kismina rakam "<addcharacter>" ekler.
    And kullanici strenght barin bes tik oldugunu dogrular.

    Examples:
      | newpassword | addcharacter |
      | qazwsX!     | 9            |


  @US08_TC_0005
  Scenario Outline:Daha guclu bir password icin ozel karakter ekleme
    And Kullanıcı New Password kismini temizler.
    And Kullanıcı new password kismina  "<newpassword>"  gonderir
    And Kullanıcı strenght barin iki tik oldugunu dogrular
    And kullanici new password kismina ozel karakter "<addcharacter>" ekler.
    And kullanici strenght barin dort tik oldugunu dogrular.


    Examples:
      | newpassword | addcharacter |
      | 12345xy     | !            |


  @US08_TC_0006-0007-0008_negative_test
  Scenario Outline:(Negative Senerio) kullanici  4 5 ve 6 karakterin guclu bir sifre icin yeterlin olmadigini test eder.(En az 7 karakter olamlidir.)
    And Kullanıcı New Password kismini temizler.
    And Kullanıcı new password kismina  "<newpassword>"  gonderir
    And Kullanıcı strenght barin tek tik oldugunu dogrular

    Examples:
      | newpassword |
      | qA1!        |
      | qA1!5       |
      | qA1!5*      |

  @US08_TC_0009_positive_test
  Scenario Outline:(Positive Senerio)once 6 Karakter gonerip sonra bir karakter ekleyip sifrenin guclendigini gorelim
    And Kullanıcı New Password kismini temizler.
    And Kullanıcı new password kismina  "<newpassword>"  gonderir
    And Kullanıcı strenght barin tek tik oldugunu dogrular
    And kullanici new password kismina yeni karaketer "<addcharacter>" ekler.
    And kullanici strenght barin dort tik oldugunu dogrular.


    Examples:
      | newpassword | addcharacter |
      | 12345x      | !            |


  @US08_TC_0010
  Scenario Outline:Eski şifre kullanılmamalıdır.
    When Kullanıcı New Password kismini temizler.
    And kullanici Confirmation Password kismini temizler
    And Kullanıcı "<currentPassword>" kısmına yenı password girer
    And Kullanıcı new password kismina  "<newpassword>"  gonderir
    And Kullanıcı confimation passworda "<confirmationPassword>" girer
    And kullanıcı  "SAVE" e tiklar.
    Then kullanıcı mesaj kutusundaki başarı mesajını bir BUG olarak görür.
    #Then kullanici driveri kapatır.


    Examples:
      | currentPassword | newpassword | confirmationPassword |
      | 3456780         | 2345670     | 2345670              |



