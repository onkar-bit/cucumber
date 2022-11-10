Feature: go to website and perform operation
  go to given website


Scenario: go to website and perform form filling operation
  Given go to webdriveruniversity website
  And click on contact us link
  And enter first name
  And enter last name
  And enter email address
  And enter comments
  When click on submit button
  Then verify thank you message is display
  