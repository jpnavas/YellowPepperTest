#--------------------------------------------------------------------------------
##                     YELLOW PEPPER API
##                      Order To The Store
##--------------------------------------------------------------------------------
#       			Authors:
#		jpablo-na993@hotmail.com
# language: en


  Feature: As user i want to send order to the store

    @SendOrder
    Scenario: Validate that the user send order with status code and response ID
      Given the user send order to the store
      Then validate status code and id response

    @DeleteOrder
    Scenario: Validate the correct delete the order
      When  create order and Delete the order
      Then the user status an response ok of delete
