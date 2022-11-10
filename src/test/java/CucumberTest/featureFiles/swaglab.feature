Feature: check login functionality and buy functionality

Background: login in to swag website
  Given go to swag labs website
  And enter username and password
  |username     |password    |
  |standard_user|secret_sauce|
  When click on login
  Then verify product page will displayed

@Unit  
Scenario: add to cart product
  Given click on sauce lab backpack product
  When click on add to cart button
  Then verify product added in cart

@Unit  
Scenario: check sort product functionality
  Given verify product page displayed after login 
  And select dropdown option price low to high
  Then verify lowest price product will come first
  
@Unit
Scenario: check high to low sort functionality
  Given user is on product page
  And select dropdown option price high to low
  Then verify highest price product will come first

  
   