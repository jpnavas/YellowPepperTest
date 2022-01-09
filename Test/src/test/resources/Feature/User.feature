#--------------------------------------------------------------------------------
##                     YELLOW PEPPER API
##                      Operation about User
##--------------------------------------------------------------------------------
#       			Authors:
#		jpablo-na993@hotmail.com
# language: en


  Feature: As user i wanto to Send my personal data and Password

    @SendDataUser
    Scenario: Validate the send of data user
      Given Send request with data
      Then Validate status code ok

    @UpdateUserInformation
    Scenario: Validate the update of user information
      Given Send request with data and send update
      Then Validate satus and response of update