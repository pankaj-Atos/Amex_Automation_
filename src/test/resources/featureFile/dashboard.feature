Feature: Dashboard Validation

  Background:
    Given I am logged in

  @Reg
  Scenario Outline: Validate dashboard page title
    When I click on the menu
    And I click on "<menuOption>"
    Then I should see the correct page title

    Examples:
      | menuOption      |
      | Pull requests   |