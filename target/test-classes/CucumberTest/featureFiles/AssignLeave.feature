Feature: test assign leave feature

@UAT
Scenario: assign leave in orange hrm website
  Given go to website and log in using correct username and password
  |username  |password |
  |Admin     |admin123 |
  And click on logged in
  And verify successfully logged in
  And move cursor over leave tab
  And click on assign leave
  And enter all details
  When click on assign button
  Then Verify successfull message shown on page
  
@UAT
Scenario: check add vacancy feature
  Given go to website and log in using correct username and password
  |username  |password |
  |Admin     |admin123 |
  And click on logged in
  And verify successfully logged in
  And move cursor over recruitment tab
  And click on vacancy
  And fill all detail
  Then Verify vacancy added successfully