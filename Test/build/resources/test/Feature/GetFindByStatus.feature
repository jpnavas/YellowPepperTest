#--------------------------------------------------------------------------------
##                     YELLOW PEPPER API
##                      Get Find By Status
##--------------------------------------------------------------------------------
#       			Authors:
#		jpablo-na993@hotmail.com
# language: en

  Feature: As a user i want to find status

    @FindByStatusAvailable
    Scenario: validate that the user can search by the available status
      Given the user search with status available
      Then the user validate status 200 and response

    @FindByStatusPending
    Scenario: validate that the user can search by the Pending status
      Given the user search with status Pending
      Then The user Validate Response

    @FindByStatusSold
    Scenario: validate that the user can search by the Sold status
      Given the user search with status Sold
      Then The user Validate Response and status

    #@FindByStatusUnknown
   # Scenario: validate that the user can search by the unknown status
     # Given the user search with status unknown
     # Then The user Validate Response and status
