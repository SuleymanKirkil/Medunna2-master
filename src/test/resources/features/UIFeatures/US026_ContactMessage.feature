@US026
Feature:Us026_Iletisim mesaji
  Background:
    Given Kullanici medunnaURl anasayfasina gider
    And Kullanici CONTACT butonuna tiklar

    Scenario Outline:TC01 Herhangi bir kullanıcı bilgi almak için "Contact portal" üzerinden istek gönderir
      And Kullanici "<Name>", "<Email>", "<Subject>", "<Message>" metin kutularini doldurur
      And Kullanici Send butonuna tiklar
      Then Kullanici bilgilerin basarili bir sekilde gonderildigini dogrular
      And Kullanici sayfayi kapatir
      Examples:
      |Name|Email|Subject|Message|
      |TeamElli|teamElli@gmail.com|hayat|hayat guzeldir|

      Scenario Outline:TC02 Herhangi bir kullanıcı gecerli bilgilerle Message kutusunu bos birakarak istek gönderir
        And Kullanıcı Message kutusunu bos birakir."<Name>", "<Email>", "<Subject>" kutularina gecerli bilgiler girer
        And Kullanici Send butonuna tiklar
        And Kullanici bilgilerin basarili bir sekilde gonderildigini dogrular
        Then Kullanici sayfayi kapatir
        Examples:
          |Name|Email|Subject|
          |TeamElli|teamElli@gmail.com|hayat|

      Scenario Outline:TC03 Herhangi bir kullanıcı Name kutusunu doldurmadan istek gönderemez
        And Kullanıcı Name kutusunu bos birakir. "<Email>", "<Subject>", "<Message>" bölümlerine gecerli bilgiler girer
        And Kullanici Send butonuna tiklar
        And Kullanici Name kutusunu doldurmadan istek gonderemeyecegini dogrular
        Then Kullanici sayfayi kapatir
        Examples:
          |Email|Subject|Message|
          |teamElli@gmail.com|hayat|hayat guzeldir|

      Scenario Outline:TC04 Herhangi bir kullanıcı Email kutusunu doldurmadan istek gönderemez
        And Kullanıcı Email kutusunu bos birakir. "<Name>", "<Subject>", "<Message>" bölümlerine gecerli bilgiler girer
        And Kullanici Send butonuna tiklar
        And Kullanici Email kutusunu doldurmadan istek gonderemeyecegini dogrular
        Then Kullanici sayfayi kapatir
        Examples:
          |Name|Subject|Message|
          |TeamElli|hayat|hayat guzeldir|

      Scenario Outline:TC05 Herhangi bir kullanıcı Subject kutusunu doldurmadan istek gönderemez
        And Kullanıcı Subject kutusunu bos birakir. "<Name>", "<Email>", "<Message>" bölümlerine gecerli bilgiler girer
        And Kullanici Send butonuna tiklar
        And Kullanici Subject kutusunu doldurmadan istek gonderemeyecegini dogrular
        Then Kullanici sayfayi kapatir
        Examples:
          |Name|Email|Message|
          |TeamElli|teamElli@gmail.com|hayat guzeldir|
