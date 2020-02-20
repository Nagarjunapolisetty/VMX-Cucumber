@featureTag
Feature: Automated checout tests 
	Description: The purpose of this feature is to test E2E application	
	
@scenarioTag		
Scenario Outline: User able to navigate to checkout. 
	Given I navigate to the Home Page 
	And I navigate to pdp of "shop/e310" 
	And I add  "<product>" to cart
	And I click the 'checkout' button 
	And I fill my shipping "<shipping>"  form
	
	Examples: Rainbow colours 
		| shipping  || product  |
		| Nagarjuna || blender  |