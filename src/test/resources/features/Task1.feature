Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

  Scenario Outline: Scenario for error case1
    Given I am on enter a number page
    When I enter a number: "<number>"
    And I click submit number
    Then I can see message "<message>"

    Examples:
      | number | message                 |
      | 32     | Number is too small     |
      | 101    | Number is too big       |
      | a      | Please enter a number   |

  Scenario: with correct number
    Given I am on enter a number page
    When I enter a number: "64"
    And I click submit number
    Then I see success message: "Square root of 64 is 8.00"