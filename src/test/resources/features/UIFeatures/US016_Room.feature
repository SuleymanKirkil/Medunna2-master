Feature: (Admin) Oda Oluşturma / Görüntüleme / Güncelleme /Silme


  Background:kullanıci hastalar  için yeni odalar oluşturabilir.
    Given kullanici  medunnaURl adresine gider
    And Kullanıcı "Account "menusune  tiklar
    And Kullanıcı "SİNG İN" butonuna tiklar
    And  Kullanıcı  username ve passwordu girer
    And  Kullanıcı "SİNG İN2" kutusuna tiklar
    And kullanici Click on Items&Titles
    And kullanici acilan drop down menusunden room kismina tiklar.


  @US16_TC01
  Scenario:TC01 Tarih DAY MMYEAR olarak oluşturuldu ve daha önceki tarih  yazılamaz
    When kullanici Create a new Room buttonuna tiklar
    Then kullanici "Create or edit a Room" sayfasinda olgunu dogrular
    Given kullanici oda numarasini girer
    And kullanici statusu ayarlayabilmeli
    And kullanici fiyat girer
    And kullanici "19/08/2022" tarihini girer.
    When kullanici save buttonuna tiklar
    Then kullanici "A new Room is created" yazisini goruntuleyebilmeli
      #And kullanici tarihin otomatik olarak atandigini dogrular
      #And Admin verify that Created Date is updated automatically


  @US16_TC02
  Scenario:TC02 Oda oluştururken oda numarası (zorunlu alan),fiyat (zorunlu alan ),oda tipi İKİZ,
  DELUXE, PREMIUM_DELUXE, SUIT ve DAYCARE şeklinde olmalıdır,
  Odanın mevcut durumu ayarlanabilir,isteğe bağlı olarak açıklama eklenebilir.

    When kullanici Create a new Room buttonuna tiklar
    Given kullanici , oda numarası alanını boş bırakir  ve entera tiklar.
    When kullanici save buttonuna tiklar
    And kullanici "This field is required." ifadesini iki kez görmelidir.
    And kullanici, oda tipi dropdown menüsüne tıklar.
    And Kullanici "TWIN", "DELUXE", "PREMIUM_DELUXE", "SUITE" ve "DAYCARE" seceneklerini gormeli
    And kullanici odanın mevcut durumunu ayarlayabilmeli.


  @US16_TC03
  Scenario:TC03 Yönetici aynı öğelere sahip tüm odaları görüntüleyebilir, Yönetici mevcut odaları düzenleyebilir (güncelleyebilir),
  Odalar yönetici tarafından silinebilir.

    Given kullanici room sayfasinda
    And   kullanici  ayni tur odalari gorebilmeli
    And kullanici  odalari duzenleyebilmek icin "edit " e tıklayabimeli
    Then kullanici "Create or edit a Room" sayfasinda olgunu dogrular
    And kullanici aciklama kisminda  "" bilgisini tanimladi
    When kullanici save buttonuna tiklar
    And kullanici "Room is updated" mesajını görmeli.
    And kullanici son oluşturulan oda için "delete" düğmesine tıklar.
    And kullanici sime islemini onaylar.
    Then kullanici "Room is deleted" yazisini gorebilmeli.







