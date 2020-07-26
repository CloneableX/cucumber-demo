Feature: Search by Baidu
  Person can search any key words by baidu

  Scenario: Finding some cheese
    Given I am on the Baidu search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"