@API @US001
Feature:US001 Kayit olmak icin SSN, Firstname ve Lastname bilgileri girilebilmelidir.


  Scenario:TC_00105 Kullanici swagger kullanarak tum kayit bilgilerini alir ve dogrular.

    Given Kullanici API ile get request olusturarak tum kayitli kullanicilarin bilgilerini alir
    Then Kullanici get request ile gelen cevabi kaydeder ve toplam kullanici sayisini kaydeder
    And Kullanici medunna ana sayfasina admin hesabi ile giris yapar
    Given Kullanici user management sayfasina gider
    Then Kullanici toplam kullanici sayisini elde eder
    And Kullanici beklenen kullanici sayisi ile gercekte olan kullanici sayisini karsilastir


  Scenario:TC_00106 Kullanici API kullanarak kayitli kisi olusturur ve dogrular.

    Given Kullanici kayit etmek istedigi kullanicinin bilgilerini olusturur
    Given Kullanici API ile post request olusturarak yeni bir kullanici kayit eder
    Then Kullanici API ile gelen cevabi kaydeder ve alinan cevap ile beklenen cevabi karsilastirir



