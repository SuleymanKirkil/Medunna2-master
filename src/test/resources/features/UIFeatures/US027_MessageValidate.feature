@US027
Feature:US027_Messages by Admin Validate

  Background:
    Given Admin medunnaUrl anasayfasina gider
    And Admin adminUsername ve adminPassword ile siteye giris yapar
    And Admin admin sayfasinin gorunurlugunu test eder
    And Admin Items&Titles butonuna tiklar
    And Admin Messages butonuna tiklar
    Then Admin Messages portalına basarili bir sekilde gecis yapildigini test eder

    Scenario:TC01 Admin, mesaj portalına gidebilir ve tüm mesajları, yazarlarını ve e-postalarını görüntüleyebilir
      And Admin View butonuna tiklar
      And Admin tüm mesajları, yazarlarını ve e-postalarını görüntüleyebildigini test eder
      Then Admin cikis yapar

   Scenario Outline: TC02 Admin, mesajları oluşturabilir
     And Admin Create a new Message butonuna tiklar
     And Admin "<Name>", "<Email>", "<Subject>", "<Message>" metin kutularini doldurur
     And Admin mesaj olusturabilmek veya guncelleyebilmek icin save tusuna tiklar
     Then Admin mesajin basarili bir sekilde olusturuldugunu test eder
     Then Admin cikis yapar
     Examples:
     |Name|Email|Subject|Message|
     |TeamElli|teamElli@gmail.com|yasam|yasamak guzel|

   Scenario Outline:TC03 Admin, mesajları guncelleyebilir
     And Admin ID butonuna tiklar
     And Admin Edit butonuna tiklar
     And Admin "<Name>", "<Email>", "<Subject>", "<Message>" metin kutularini gunceller
     And Admin mesaj olusturabilmek veya guncelleyebilmek icin save tusuna tiklar
     And Admin mesajin basarili bir sekilde guncellendigini test eder
     Then Admin cikis yapar
     Examples:
     |Name|Email|Subject|Message|
     |Team50|team50@gmail.com|hayat|hayat guzeldir|

     Scenario: TC04 Admin, mesajları silebilir
       And Admin ID butonuna tiklar
       And Admin Delete butonuna tiklar
       And Admin Delete popup'a tiklar
       And Admin cikan pop up ile delete isleminin gerceklestigini dogrular
       Then Admin cikis yapar