Feature: "SberCorus test 2"

  Scenario Outline: "Check errors with wrong parameters"

    Given Get request specification
    When Send request "<endpoint>" with parameter "<query>"
    Then Check error body <code>,"<info>"
    Examples:
      | endpoint | query       | code     | info                                                                  |
      | currrent | Krasnodar   | HTTP_103 | This API Function does not exist.                                     |
      | current  |             | HTTP_601 | Please specify a valid location identifier using the query parameter. |
      | current  | Krasnodarrr | HTTP_615 | Your API request failed. Please try again or contact support.         |


  Scenario Outline: "Check error invalid access key"

    Given Get request specification
    When Send request "<endpoint>" with parameters "<accessKey>", "<query>"
    Then Check error body <code>,"<info>"
    Examples:
      | endpoint | accessKey | query     | code     | info                                                                                    |
      | current  | accessKey | Krasnodar | HTTP_101 | You have not supplied a valid API Access Key. [Technical Support: support@apilayer.com] |
