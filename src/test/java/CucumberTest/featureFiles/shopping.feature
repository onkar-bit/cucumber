Feature: test shopping website functionality with Login

@Sanity
Scenario: go to shopping website and check login functionality
  Given go to shoppping website
  And click on sign in link
  And nevigate to login page enter valid email
  And Enter valid password
  When click on sign in
  Then Verify user successful logged in display my account page
  
@Sanity
Scenario: go to shopping website and check search product functionality
  Given go to shopping website
  And move your cursor over women link
  And click on T-shirt link
  And get name of first product displayed on page
  And enter same product name in searchbar
  When click on search 
  Then verify same product name displayed on searched page which dispalyed in Tshirt
 
  