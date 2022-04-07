Feature: Adding Editing removing a person in the site

  Scenario Outline: Scenario for add a person
    Given I am on people page
    When I click add person
    And  I enter input in enter a new person page
      | name          | <name>         |
      | job           | <job>          |
      | dateOfBirth   | <dateOfBirth>  |
      | language      | <lang>         |
    And I click Submit Button
    Then I can see person detail "<detail>" in peoples page

    Examples:
      | name | job      |dateOfBirth|lang   |detail|
      | anna | engineer | 14/03/1996|english| × anna  Job: engineer; Date of birth: 14/03/1996; Knows language(s): English, ; Gender: undefined; Employee status: employee |

  Scenario: Scenario for edit a person
    Given I am on people page
    When I click edit third  person
    And  I changed name: "Alice"
    And I click Edit Button
    Then I can see new person detail in peoples page: "× JaneAlice Doe  Job: Accountant; Date of birth: 04/01/2001; Knows language(s): English, French; Gender: female; Employee status: employee"

  Scenario: Scenario for edit a person
    Given I am on people page
    When I click remove third person
    Then person is removed

    Scenario Outline: Reset original list
      Given I am on people page
      When I click add person
      And  I enter input in enter a new person page
        | name          | <name>         |
        | job           | <job>          |
        | dateOfBirth   | <dateOfBirth>  |
        | language      | <lang>         |
      And I click Submit Button
      And I click edit third  person
      And  I changed name: "Alice"
      And I click Edit Button
      And I click remove third person
      And I click Reset button
      Then the page has reset

      Examples:
        | name | job      |dateOfBirth|lang   |
        | anna | engineer | 14/03/1996|english|

  Scenario Outline: Scenario for clear button
    Given I am on people page
    When I click add person
    And  I enter input in enter a new person page
      | name          | <name>         |
      | job           | <job>          |
      | dateOfBirth   | <dateOfBirth>  |
      | language      | <lang>         |
    And I click clear all fields
    Then Form is reset

    Examples:
      | name | job      |dateOfBirth|lang   |
      | anna | engineer | 14/03/1996|english|
