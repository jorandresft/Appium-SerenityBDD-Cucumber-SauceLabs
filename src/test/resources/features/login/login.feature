#author: Jorge Franco
#date 14/08/2024

Feature: Validate login the app Sauce Labs

  Scenario Outline: Validate login with valid credentials
    Given The "user" send his credentials user "<userName>" and password "<password>"
    When He clicks on the login button
    Then He should see the title "PRODUCTS" with login is successful

    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Validate login with incorrect credentials
    Given The "user" send his credentials user "<userName>" and password "<password>"
    When He clicks on the login button
    Then He should see the title "Username and password do not match any user in this service."

    Examples:
      | userName | password |
      | standard | secret   |

  Scenario Outline: Validate login with password it is missing
    Given The "user" send his credentials user "<userName>" and password "<password>"
    When He clicks on the login button
    Then He should see the title "Password is required" with password it is missing

    Examples:
      | userName | password |
      | standard |          |