@web
Feature: User Signup
  Scenario: successful signup
    Given The user is in the signup page
    When he creates his account with valid information
    Then he should be redirected to the home page