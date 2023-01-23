
  Feature:US007 Hasta Randevu Alma Islemi
    Background:
      Given Kullanici medunnaURl anasayfasina gider
      And Kullanici gecerli hastaUsername ve hastaPassword ile siteye giris yapar
      And Kullanici MakeAnAppointment butonuna tiklar
      Then Kullanici MakeAnAppointment bolumunun gorunurlugunu test eder

    Scenario Outline:TC01 Kullanici guncel tarih girmelidir
      And Kullanici "<Phone>" bilgilerini doldurur
      And Kullanici guncel bir tarih secer
      And Kullanici Send an Appointment Request butonuna tiklar
      And Kullanici gecerli bir tarih sectigini cikan popup ile dogrular
      And Kullanici sayfayi kapatir
      Examples:
        |Phone|
        |555-222-4563|

    Scenario Outline:TC02 Kullanici gelecek tarih girmelidir
      And Kullanici "<Phone>" bilgilerini doldurur
      And Kullanici gelecek bir tarih secer
      And Kullanici Send an Appointment Request butonuna tiklar
      And Kullanici gecerli bir tarih sectigini cikan popup ile dogrular
      And Kullanici sayfayi kapatir
      Examples:
        |Phone|
        |555-222-4563|
    @US007
    Scenario Outline:TC03 Kullanıcı gecmis tarih girdiginde hata almalidir
      And Kullanici "<Phone>" bilgilerini doldurur
      And Kullanici gecmis bir tarih secer
      And Kullanici gecerli bir tarih secmedigini Appointment date can not be past date! yazisi ile dogrular
      And Kullanici Send an Appointment Request butonuna tiklar
      And Kullanici gecerli bir tarih sectigini cikan popup ile dogrular
      And Kullanici sayfayi kapatir
      Examples:
        |Phone|
        |555-222-4563|

    Scenario Outline:TC04 Tarih sırası gün/ay/yıl şeklinde olmalıdır
      And Kullanici "<Phone>" bilgilerini doldurur
      Then Kullanici "<date>" secer ve tarih sirasinin formata uygun seklinde oldugunu test eder
      And Kullanici sayfayi kapatir
      Examples:
        |Phone|date|
        |555-222-4563|22.08.2022|