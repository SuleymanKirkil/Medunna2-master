Feature:API kullanarak randevular goruntulenebilmeli

  Scenario Outline:
    Given Kullanici randevu bilgilerini get request eder
    When Kullanici gelen randevu bilgilerini deserialize eder
    Then Kullanici "<patient_id>" , "<firstname>" , "<lastname>" , "<phone>" , "<email>" bilgilerini Validate eder
    Examples:
    |patient_id|firstname|lastname|phone|email|
    |181316|yeniFirstName|yeniLastName|555-222-4563|yeni4@gmail.com|
