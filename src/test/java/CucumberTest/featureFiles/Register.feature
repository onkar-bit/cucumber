Feature: test register functionality

@System
Scenario Outline: go to shopping website and check register functionality
  Given go to online shopping website
  And Click on my account link
  And click on register
  And Enter Fname "<firstname>"
  And Enter Lname "<lastname>"
  And Enter email "<emailid>"
  And Enter phone no "<telephone>"
  And Enter password "<password>"
  And Enter cnf password "<passwordcnf>"
  And click on agree check box
  When click on continue button
  Then verify sucessfull register and account created msg has dispaly
  Examples: 
  | firstname | lastname | emailid        | telephone  | password  | passwordcnf |
  | hijk      | hari     | hijk@gmail.com | 8888888888 | hijk@abc  | hijk@abc    |
  | hikej     | kakde    | hikej@gmail.com| 9999999999 | hikej@xyz | hikej@xyz   |