@login
Feature: As user I should to be able to login into Library Application
  Scenario: User should be able to log in
    Given user located on login page
    When user type credentials
    Then user should be able to land on dashboard page
