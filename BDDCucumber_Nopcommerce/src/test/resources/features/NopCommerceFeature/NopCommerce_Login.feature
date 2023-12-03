Feature: Verify SignOn functionality in NopCommerce application

In order to test SignOn functionality
As a Tester
I want the NopCommerce and and required valid credentials

Background: 

When User Launch the required NopCommerce URL

@Functional
Scenario Outline: Verify SignIn functionality with credentials
  Given The user is in NopCommerce application
  When He input the Email into Login Name field
  | Email | <User_Name> |
  And He input required password into Password field
  | password | <Password> |
  Then Click on Login button
  Then Application Navigates to Dashboard Information Page
    
  
  Examples:
  | User_Name | Password |
  | admin@yourstore.com | admin |
 