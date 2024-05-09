@web
Feature: User SignIn

  Background: Sign in page
    # The configured browsers are CHROME and FIREFOX
    Given the User browses the internet using the "FIREFOX" browser
    And The user is in the login page

  Scenario: Successful sign in
    When he accedes with his correct credentials
    Then he should be redirected to the home page

  Scenario: Sign in attempt with a not registered email
    Given he tries to access with a new email
    Then he should see an error message appear