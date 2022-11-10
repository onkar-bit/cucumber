Feature: Login into account
  Existing user should be able to login
  
Scenario: Login to account with correct details
  Given User navigate to stack overflow website
  And User clicks on the login button on homepage
  And User enters a valid username
  And User enters a valid password
  When user clicks on the login button
  Then User should be taken to the successful login page