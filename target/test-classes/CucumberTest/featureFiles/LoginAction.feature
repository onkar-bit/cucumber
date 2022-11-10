Feature: Login action using data table

@Regression
Scenario: successful login with valid credential
  Given User nevigate to login page
  And User enter valid credentials to login
  | Admin | admin123|
  When Click on login button 
  Then Verify dashboard will open
  
@Regression
Scenario: Login with valid credential using maps
  Given User nevigate to login page to login
  And User enter valid credentials to login page
  | Username | Password |
  | Admin    | admin123 |
  When User Click on login button 
  Then Verify dashboard will open after click on login