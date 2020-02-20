Feature: Automated E2E tests 
	Description: The purpose of this feature is to test E2E application

Scenario: User able to navigate to checkout. 
	Given I navigate to the Home Page 
	And I navigate to pdp of "shop/certified-reconditioned-v1200" 
	And I click the 'add to bag' button
	
Scenario: User able to navigate to cart. 
	Given I navigate to the Home Page 
	And I navigate to pdp of "shop/smart-system-blenders" 
	
	