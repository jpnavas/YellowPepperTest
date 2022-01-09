#--------------------------------------------------------------------------------
##                     YELLOW PEPPER API
##                      Post New Pet to the Store
##--------------------------------------------------------------------------------
#       			Authors:
#		jpablo-na993@hotmail.com
# language: en

  Feature: As user i want to create new pet to the store

    @NewPet
    Scenario: Validate that the new pet is on the store
      Given the user send a information
      Then Validate status and name

