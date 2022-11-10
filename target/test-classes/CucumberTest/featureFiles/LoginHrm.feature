Feature: Login to account
  should login with existing user
  
@Smoke
Scenario: Login to account with correct details
  Given User navigate to orange hrm website
  And User enter valid username
  And User enter valid password
  When User clicked on Login button
  Then User will successfully logged in 
  
@Smoke
Scenario: Login to account with invalid details
  Given User is on orange hrm website
  And User enter invalid username and password
  When User click on Login button on page
  Then User will see error message and not logged in