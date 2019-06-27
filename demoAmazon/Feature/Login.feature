@Smoke_test
Feature: Amazon Smoke Test

@scenario1
Scenario Outline: User should be Login/SignIn to the Amazon Home page
Given I enter Home page Url
When I Navigate to Sign in button
And I enter <User name> and <Password>
And I able to click Login button
Then I successfully signed into my account
Then I should Signed out

Examples:
|User name | |  Password |
|9944351331| |Blackpan@21|
#|9597693708| |mani143cat|

@scenario2
Scenario: User should add product in cart
Given I sign in to the webpage
When I Enter the particular product
And I click search
And I should select one product
Then I click Add to cart option
And I click a cart tab
And I able to see product added
Then I should Signed out

@scenario3
Scenario: User should delete product from Cart
Given I sign in to the webpage
When I click a cart tab
And I should delete one product
And I should see the product was removed
Then I should Signed out

@scenario4
Scenario: User should view balance statement in amazon pay
Given I sign in to the webpage
When I click amazon pay tab
And I click view statement option
And I able to see all statement details
Then I should Signed out

@scenario5
Scenario: User should add new address in webpage
Given I sign in to the webpage
When I navigate to add new address page
Then I pass values in all mandatory fields
When I click add address button
Then I see added address and click delete
Then I able to see address deleted
Then I should Signed out


 
