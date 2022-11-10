Feature: check add product in wishlist and buy product functionality

Background: User is logged in
    Given user nevigate to login page
    When user submit valid username and password
    Then user should be logged in

@End2End    
Scenario: product is successfully added in wishlist
  Given user is on my account dashboard page
  And curser move over desktop link
  And click on show all desktop
  And click on canon camera
  When click on add to wishlist button
  Then verify product successfully added to wishlist

@End2End
Scenario: product is successfully buy
  Given user is on my account dashboard page
  And click on hp laptop and add to cart
  And click on cart item and click on checkout
  And fill billing details click on continue
  And in delivery details tab click on continue
  And in delivery method click on continue
  And in payment method click agree checkbox and click continue
  When user click on confirm order button 
  Then verify order is placed
  