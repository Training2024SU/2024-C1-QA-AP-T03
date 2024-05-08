@web
Feature: User Signup

  Background: Browser
    # The configured browsers are CHROME and FIREFOX
    Given the User browses the internet using the "CHROME" browser

  Scenario: successful signup
    Given The user is in the signup page
    When he creates his account with valid information
    Then he should be redirected to the home page