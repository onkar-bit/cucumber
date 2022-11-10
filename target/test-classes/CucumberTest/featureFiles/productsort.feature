Feature: check product sort functionality


@WBT
Scenario Outline: verify sorted product
   Given go to swaglab website
   And enter username "<username>" and password "<password>"
   And click on in button
   And verify product page is available
   And select dropdown option name descending
   Then verify product name will sort in descending manner
 Examples: 
 | username      | password     |
 | standard_user | secret_sauce |