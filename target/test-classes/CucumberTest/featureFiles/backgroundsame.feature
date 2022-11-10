Feature: check search product and add to cart product functionality with background

Background: User is logged in
        Given I nevigate to login page
        When I submit username and password
        Then I should be logged in

@Functional        
Scenario: verify same product is displayed on search page
   Given user is on my account page
   And I cursor moved on desktops
   And I clicked on mac link
   And I get the first product name
   And I search that product name in search bar
   When clicked on search button
   Then verify searched product is same displyed on homepage

@Functional   
Scenario: successfully product added in cart
   Given user is on my account page
   And I cursor moved on laptop
   And I clicked on show all laptop
   And I click on HP laptop
   When I clicked on add to cart button
   Then verify product has successfully added to cart