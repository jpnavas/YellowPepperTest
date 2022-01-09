# Petstore

Building automated tests with the Screenplay Serenity, Cucumber, Java, Junit, and Gradle to test a REST

The following Service are used for this automation:
https://petstore.swagger.io/#/user

Built tests

1. Pet Everything about your Pets
2. Store Access to Petstore orders
3. User Operations about user

What do you need Cloning the repository?
---------------------------------------------------
1. GIT

What do you need before downloading the repository?
---------------------------------------------------

1. Java JDK 1.8.
2. Gradle 7.2.

Framework Used
-------------
 1. Serenity Screenplay
    http://serenity-bdd.info/docs/articles/screenplay-tutorial.html
   
 2. Cucumber
    https://cucumber.io/docs/cucumber/
    
    
Project Structure
------------------

src 

	main.....................................# Source files
	
			co.com.YellowPepper.Api
				Questions..........................# Package where classes are stored to obtain data from the service,	response from the service, etc.
				Tasks..............................# Package where the tasks run the services (Post,Delete,Get,Put)
				
	Test.....................................# Files for the execution of the tests
		co.com.YellowPepper.Api
				Runners............................# Test execution classes
				
				StepDefinitions....................# Classes with the Java method with 	an expression that links it to one or more Gherkin steps.
				
		resources
				Features             # Package where the scenarios are stored in Gherkin language
				
 

Execution
--------------
To run all the project tests:

gradle clean test aggregate


Serenity Report
---------------
The report generated from the tests is generated in the route /target/site/serenity/index.html



