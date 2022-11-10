Feature: check hotel booking functionality

Background: successfully logged in
   Given go to hotel booking website
   When Enter valid username and password click on login
   Then user will successfully logged in

@Load   
Scenario: Hotel is booked successfully
   Given user is on hotel website
   And click on hyatt regency perth image
   And click on book now button
   And Enter personal information form
   And click on agree checkbox
   When click on confirm booking button
   Then Verify hotel is booked successfully and get reserve number

@Load
Scenario: Tour booking is done successfully
   Given user is on tour booking site
   And click on tour of dubai link
   And click on book now
   And enter personal info form
   And click on agree checkbox on page
   When click on confirm booking button on page
   Then verify tour is booked successfully
   
@Load
Scenario: Flight booking is done successfully
   	Given user is on flight booking website
   	And click on mumbai to dubai air india link
   	And click on book now button given in page
   	And enter traveller information
   	And click on agree checkbox box on page
    When click on confirm booking button given
    Then verify flight booked succesfully