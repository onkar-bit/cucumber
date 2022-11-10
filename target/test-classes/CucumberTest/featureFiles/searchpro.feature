Feature: searched product match with existing product

@whitebox
Scenario Outline: check search product is match with existing product
   Given user is on tutorial ninja demo website
   And click on my account in homepage
   And click on login in homepage
   And enter the correct "<username>" and "<password>" click on sign in
   And move curser over desktop click on show all
   And get camera name from homepage
   And search that camera name in search field
   When click on search button in demo web
   Then Verify both product matches.
   
Examples: 
|username          |password|
|ajaydemo@gmail.com|ajaydemo|