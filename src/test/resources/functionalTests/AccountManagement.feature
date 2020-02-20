@featureTag
Feature: Automated account management tests 
	Description: The purpose of this feature is to test Account realted scenarios	
	
@scenarioTag		
Scenario: Verify user able to login to the application.

	Given I navigate to the Home Page
	And I click on 'My Account' link in the header
	And I enter my 'Email' and 'Password' in the text fields
	And I click the 'Login' button 
	Then I verify logged-in user state