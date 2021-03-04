Feature: Launching Amazon webpage

  Scenario: Launch the Amazon webpage
    Given browser is open
    And user is navigated to the Amazon webpage
    Then validate the title
    And browser is closed
