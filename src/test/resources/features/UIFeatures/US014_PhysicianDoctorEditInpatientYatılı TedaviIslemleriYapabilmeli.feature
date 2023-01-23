@US14
Feature: US14 kullanıcı medunnada

  Scenario:
    Given Doktor medunnaURl adresine gider
    Then Anasayfada giriş ikonuna tıklar
    And Sign in seçeneğine tıklar
    And Geçerli bir username girer
    Given Geçerli bir şifre girer
    Given Signin butonuna tıklar
    Then MY PAGES menüsüne tıklar
    Then My Inpatients sekmesini secer
    Then Çıkan sayfada "ID, start and end dates, description, created date appointment id, status, room and patient" bilgilerinin görünürlüğünü test eder"
    And sayfayi kapatir


  Scenario:"Status" doktor tarafından "UNAPPROVED, DISCHARGED, STILL STAYING veya CANCELLED" olarak güncellenebilmeli
    Given Doktor medunnaURl adresine gider
    Then Anasayfada giriş ikonuna tıklar
    Then Sign in seçeneğine tıklar
    Given Geçerli bir username girer
    Then Geçerli bir şifre girer
    Then Signin butonuna tıklar
    Then MY PAGES menüsüne tıklar
    Then My Inpatients sekmesini secer
    Then Çıkan sayfada "Edit"butonuna tıklar
    Then Status menüsünden <DISCHARGED> sekmesi seçilerek "save" tuşuna basılır, <DISCHARGED> yazısı görüntülenir
    Then Status menüsünden <UNAPPROVED> sekmesi seçilerek "save" tuşuna basılır, <UNAPPROVED> yazısı görüntülenir
    Then Status menüsünden <STAYING> sekmesi seçilerek "save" tuşuna basılır, <STAYING> yazısı görüntülenir
    Given Status menüsünden <CANCELLED> sekmesi seçilerek "save" tuşuna basılır, <CANCELLED> yazısı görüntülenir
    And Sayfa kapatılır



  Scenario: Doktor rezerve edilmiş odayı güncelleyebilmeli
    Given Doktor medunnaURl adresine gider
    Then Anasayfada giriş ikonuna tıklar
    Then Sign in seçeneğine tıklar
    Given Geçerli bir username girer
    Then Geçerli bir şifre girer
    Then Signin butonuna tıklar
    Then MY PAGES menüsüne tıklar
    Then My Inpatients sekmesini secer
    Then Çıkan sayfada "Edit"butonuna tıklar
    Then Room menüsünden herhangi bir oda seçip Save tuşuna basar
    Given Değişikliğin yapıldığından emin olur





