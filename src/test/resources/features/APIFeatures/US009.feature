Feature:US09_API_Validating Info USing API

  @wip
  Scenario Outline:TC5_User should validate patient info using API
    Given User sets the path params to read patient info
    When User send get request for "<id>" numbered patient info and get response
    Then User validates patient info "<firstname>" "<lastname>" "<email>" "<ssn>" .

    Examples:
      | firstname | lastname | email                | ssn         | id     |
      | Süleyman  | Çakır    | suleymancakir@kv.com | 111-45-6353 | 179706 |
      | Memati    | Baş      | mematibas@kv.com     | 789-78-7890 | 179737 |
