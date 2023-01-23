Feature: US09_DB Validations


  Scenario Outline: TC0906_User can validate patients information with DB
    Given User connects to DB
    When User gets information from DB
    Then User verifies that patients exists in DB "<lastname>" "<firstname>" "<email>" "<ssn>"
    And User closes the DB connection

    Examples:
      | firstname | lastname | email                | ssn         |
      | Süleyman  | Çakır    | suleymancakir@kv.com | 111-45-6353 |
      | Memati    | Baş      | mematibas@kv.com     | 789-78-7890 |