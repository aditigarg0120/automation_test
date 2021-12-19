Feature: Booking validation for travel website

  Background:
    Given I navigate to blazedemo Home page

      #validate successful booking from Boston to London
  @FunctionTests
  Scenario: Validate successful flight booking from Boston to London with Confirmation Id
    When  User enter departure city
    And User enter destination city
    And User click on Find Flights
    And User select the flight from the list
    And User purchase the flight
    Then User should see the successful booking page with details

     #validate booking failure if user enters incorrect details
  @FunctionTests
  Scenario: Validate failure flight booking from Boston to London with error
    When  User enter departure city
    And User enter destination city
    And User click on Find Flights
    And User select the flight from the list
    And User purchase flights with no details
    Then User should see failure on the webpage

  @ManualTests
  Scenario: Validate error message if user not select departure and destination city
    When  User not enter departure city
    And User not enter destination city
    Then User should see error message to select city from dropdown

  @ManualTests
  Scenario: Validate successful redirect to flight lists from Boston to London
    When  User enter departure city
    And User enter destination city
    Then User should be on flights list page

  @ManualTests
  Scenario: flight purchase button should be visible to user
    When  User enter person details
    Then User should see purchase flight button

  @ManualTests
  Scenario: Validate error message if user invalid details while filling the details form
    When  User search for flights
    And User enter incorrect details
    Then User should see error message

  @ManualTests
  Scenario: Validate error message if user enter expired card details
    When User select flight from the list
    And User enter expired card details
    Then User should see error message
