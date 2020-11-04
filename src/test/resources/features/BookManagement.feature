@BooksModule
Feature: User should be able to maintain the books by using Books module

  Background: Login into the Library application
    Given user logged in successfully
    And user located at Books module

  @BooksModule @AC4
  Scenario: As a user I should be able to select a category of the book by using the dropdown menu
    When User click on Books Categories dropDown menu and select "Drama"
    Then User should be able to see "Drama" books on the books grid

  @BooksModule @AC5
  Scenario Outline: user I should be able to select a number of records per page by using the dropdown menu
    When click on Show records dropDown menu and select "<selectValue>"
    Then User should be able to see "<displayRecords>" book information on the books grid

    Examples: Select record value, the page should display the number of records
      | selectValue | displayRecords |
      | 5           | 5              |
      | 10          | 10             |
      | 15          | 15             |
      | 50          | 50             |
      | 100         | 100            |
      | 200         | 200            |
      | 500         | 500            |
