@Login
Feature: Verifying Adactin hotel login

Background:
	Given User is on the Adactin login page
	
@ValidLogin
  Scenario Outline: Verifying Adactin hotel login with valid credentials
    When User should perform login with "<username>" and "<password>"
    Then User should verify after login "Hello suthakarjs!"

    Examples: 
      | username   | password      |
      | suthakarjs | 85~Suthakarjs |

@LoginWithEnter
  Scenario Outline: Verifying Adactin hotel login with valid credentials by clicking the Enter Key
    When User should perform login with "<username>" , "<password>" and click Enter key
    Then User should verify after login "Hello suthakarjs!"

    Examples: 
      | username   | password      |
      | suthakarjs | 85~Suthakarjs |
	
@InvalidLogin
  Scenario Outline: Verifying Adactin hotel login with a Invalid credentials
    When User should perform login with "<username>" and "<password>"
    Then User should verify after login an Error message which contains "Invalid Login details or Your Password might have expired."

    Examples: 
      | username | password    |
      | abcdef   | adactin@123 |
