@smoke
Feature: Login Function Test
  I want to use this template for my feature file

  @tc001_to_tc005
  Scenario: As an Orbitz user, I can successfully login with valid credentials
    Given I open the browser
    And Go to the Application URL
    When I put valid username
    And I put valid password
    And Click signin button
    Then Login should be successful and signout button should be displayed
    And Close browser
