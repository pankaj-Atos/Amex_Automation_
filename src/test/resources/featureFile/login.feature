Feature: User Login

  @Reg
  Scenario: Successful login with valid credentials
    Given I open the login page
    And I clicked on SignIn link
    When I login with valid credentials
    Then I should be logged in successfully