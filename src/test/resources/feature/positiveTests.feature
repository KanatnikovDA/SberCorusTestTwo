Feature: "SberCorus test 2"

  Scenario Outline: "Get weather"

    Given Get request specification
    When Send request "<endpoint>" with parameter "<query>"
    Then Check response "<name>","<country>","<utcOffset>"
    Examples:
      | endpoint | query     | name      | country | utcOffset |
      | current  | Moscow    | Moscow    | Russia  | 3.0       |
      | current  | Krasnodar | Krasnodar | Russia  | 3.0       |
      | current  | Vladimir  | Vladimir  | Russia  | 3.0       |
      | current  | Vologda   | Vologda   | Russia  | 3.0       |