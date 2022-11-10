Feature: check buy product feature in shopping site

@Alpha
Scenario Outline: verify the buy product functnality
  Given go to toolsqa demo shopping website
  And click on pink drop tshirt
  And select color 
  And select size
  And click add to cart button
  And click on cart icon and click on proceed to checkout button
  And Enter billing details fname "<firstname>"
  And enter lname "<lastname>"
  And enter address "<add>"
  And enter city "<city>" and select state
  And enter pin "<pin>" and mob "<phone>" and email "<email>"
  When click on agree checkbox and place order button
  Then verify order has been successfully placed
  
  Examples: 
  | firstname | lastname | add         | city | pin    | phone     | email        |
  | om        | kadam    | north pune  | pune | 445236 | 8888888888| om@gmail.com |