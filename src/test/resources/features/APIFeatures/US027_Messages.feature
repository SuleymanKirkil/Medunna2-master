@US027API
Feature:Admin tarafindan mesajlarin dogrulanmasi

  Scenario:API kullanarak ileti oluşturma doğrulanmalıdır
    Given Admin mesajlar bilgileri icin post request yapar
    Then Admin post request Validation yapar


  Scenario Outline:API kullanarak ileti okuma doğrulanmalıdır
    Given Admin mesaj bilgileri icin get request yapar
    When Admin gelen mesaj bilgilerini deserialize eder
    Then Admin "<email>", "<id>", "<message>", "<name>", "<subject>" bilgilerini validate eder
    Examples:
    |email|id|message|name|subject|
    |medunna50@gmail.com|235517|hayat guzeldir|medunna50|hayat|


