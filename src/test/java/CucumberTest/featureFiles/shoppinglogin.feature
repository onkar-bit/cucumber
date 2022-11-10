Feature: Login with two credential using datatable Examples keyword

@Integration
Scenario Outline: Login with datatable in shopping website
  Given User nevigate to the shopping website
  And User click on sign in link
  And User enters valid "<Username>" and "<Password>"
  When User click on logged in button
  Then Verify successful logged in display my account dashboard
    Examples:
  | Username      | Password |
  |mnopq@gmail.com| abc123   |
  |hmt@gmail.com  | abc123   |