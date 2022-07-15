@CancelBooking
Feature: Verifying Adactin Cancel Booking functionality

Background:
    Given User is on the Adactin login page

@CancelAfterBooked
  Scenario Outline: Verifying Adactin Cancel booking functionality
    When User should perform login with "<username>" and "<password>"
    Then User should verify after login "Hello suthakarjs!"
    And User should perform Search by providing all the fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childsPerRoom>"
    Then User should verify after search "Select Hotel"
    And User should perform Select hotel by choosing any of the hotel
    Then User should verify after Select hotel "Book A Hotel"
    And User should perform Book hotel by entering "<firstName>","<lastName>" and "<address>"
      | cardNumber       | cardType         | expMonth  | expYear | cvvNumber |
      | 1234567890123456 | American Express | August    |    2022 |      1234 |
      | 6543210987654321 | VISA             | December  |    2022 |      4321 |
      | 0987654321123456 | Master Card      | November  |    2022 |      0123 |
      | 1234560123456789 | Other            | September |    2022 |      3210 |
    Then User should verify the message after Book hotel "Booking Confirmation"
    And User should perform cancel booking
    Then User should verify the message after cancel booking which contains "The booking has been cancelled."

    Examples: 
      | username   | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom | firstName | lastName | address        |
      | suthakarjs | 85~Suthakarjs | Paris    | Hotel Sunshine | Deluxe   | 1 - One   | 10/07/2022  | 11/07/2022   | 2 - Two       | 0 - None      | abcd      | efgh     | 123,xyz street |

@CancelAfterLogin
  Scenario Outline: Verifying Adactin Cancel booking functionality for existing Order-ID
    When User should perform login with "<username>" and "<password>"
    Then User should verify after login "Hello suthakarjs!"
    Then User should perform cancel booking by using existing "<orderID>"
    And User should verify the message after cancel booking which contains "The booking has been cancelled."

    Examples: 
      | username   | password      | orderID    |
      | suthakarjs | 85~Suthakarjs | 88FJB0452X |
