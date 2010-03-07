# language: en
Feature: Oyster parser
  In order to parse the oyster expenses

  Scenario: Parse table
    Given I have the wholeprinterfriendlypage.html from tfl
    When I parse it
    Then I should get a result matching onlytable.html

  Scenario: Parse trs
    Given I have the onlytable.html from tfl
    When I parse the trs
    Then I should get 47 trs

  Scenario: Calculate costs
    Given I have the onlytable.html from tfl
    When I ask it to calculate all costs
    Then I should get a list of 7 costs