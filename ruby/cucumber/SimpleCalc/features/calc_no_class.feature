Feature: Simple calculator
  In order to bootstrap Cucumber without testing an external class
  As a Developer
  I want to implement anadding calculator

  Scenario: Add two numbers together
    Given the addend is 10
    And the augend is 11
    When plus is applied
    Then the result is 21
