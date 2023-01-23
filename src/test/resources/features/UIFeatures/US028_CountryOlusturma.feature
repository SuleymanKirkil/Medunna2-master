Feature:Admin olarak; Country oluşturma / Okuma ve Silme


  Background:
    Given Admin medunnaURl adresine gider
    Then Sag üst kösedeki ikona tiklar
    Then Sign In butonuna tiklar
    Given Admin adi ve sifresiyle siteye girer
    And Items&Titles butonuna tiklar


  Scenario:TC01
    Given Country secenegine tiklar
    Then Create a new Country butonuna tiklar
    And Name kismina Ülke adini yazar
    And Save butonuna tiklar
    Then Admin yeni ülke olusturdugunu cikan yaziyla dogrular
    And sayfayi kapatir


  Scenario: TC02
    Given StateCity secenegine tiklar
    Then Create a new StateCity butonuna tiklar
    Then Acilan sayfada Name kismina eyalet veya şehrini yazar
    Given StateCity kismina olusturdugu ülkeyi yazar
    And Save tusuna tiklar
    And Admin yeni StateCity olusturdugunu cikan yaziyla dogrular
    And sayfayi kapatir

    Scenario: TC03
      Given Country secenegine tiklar
      Then Create a new Country butonuna tiklar
      And Name kismina Ülke adini yazar
      And Save butonuna tiklar
      When Delete butonuna basar
      When Cikan dogrulama ekranindan da Delete butonuna basar
      And Ülkenin silindiginden emin olur
      And sayfayi kapatir




