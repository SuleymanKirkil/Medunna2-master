Feature: Admin olarak Test items Olustur / Guncelle / Goruntule ve Sil


  Scenario: TC01 Test Item sayfasi olusturulup güncellenebilmeli
    Given kullanici  medunnaURl adresine gider
    And Admin olarak giris yapar
    And Admin headers bolumunden ItemsTitles'a tiklar
    And Admin TestItem secenegine tiklar
    And Admin Create a new Test Item  butonuna tıkla
    And Admin formdaki ilgili bölümleri valid degerlerle doldurur
    And Admin Save butonuna tiklar
    And Olusturulan item'in Test Items sayfasinda yer aldigini dogrular
    And Admin olusturulan item icin Edit butonuna tiklar
    And Admin Item sayfasida price bir degerini degistirir
    And Admin Save butonuna tiklar
    And Admin A Test Item is updated mesaji goruntulendigini dogrular


    Scenario: TC02 Test Item Sayfasi goruntulenebilmeli
      And kullanici  medunnaURl adresine gider
      And Admin olarak giris yapar
      And Admin headers bolumunden ItemsTitles'a tiklar
      And Admin TestItem secenegine tiklar
      And Admin Create a new Test Item  butonuna tıkla
      And Admin formdaki ilgili bölümleri valid degerlerle doldurur
      And Admin Save butonuna tiklar
      And Admin olusturulan Item icin View butonuna tiklar
      And Olusturulan Item icin Test Item degerlerinin göruntulendigini dogrular


    Scenario: TC03 Test Item sayfasi silinebilmeli
      And kullanici  medunnaURl adresine gider
      And Admin olarak giris yapar
      And Admin headers bolumunden ItemsTitles'a tiklar
      And Admin TestItem secenegine tiklar
      And Admin Create a new Test Item  butonuna tıkla
      And Admin formdaki ilgili bölümleri valid degerlerle doldurur
      And Admin Save butonuna tiklar
      And Admin olusturulan Item icin Delete butonuna tiklar
      And Test Item is deleted mesajinin goruntulendigini dogrular

  Scenario:Api testi
    Given admin given api "https://medunna.com"
    Then admin sends a Get request to "/api/c-test-items/221948"
    And Validate the response
