@BookHotel
Feature: Verifying Adactin Book Hotel functionality

Background:
    Given User is on the Adactin login page

@BookWithFields
  Scenario Outline: Verifying Adactin Book hotel functionality by entering all the fields
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

    Examples: 
      | username   | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom | firstName | lastName | address        |
      | suthakarjs | 85~Suthakarjs | Paris    | Hotel Sunshine | Deluxe   | 1 - One   | 10/07/2022  | 11/07/2022   | 2 - Two       | 0 - None      | abcd      | efgh     | 123,xyz street |

@BookWithoutFields
  Scenario Outline: Verifying Adactin Book hotel functionality by without entering all the fields
    When User should perform login with "<username>" and "<password>"
    Then User should verify after login "Hello suthakarjs!"
    And User should perform Search by providing all the fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childsPerRoom>"
    Then User should verify after search "Select Hotel"
    And User should perform Select hotel by choosing any of the hotel
    Then User should verify after Select hotel "Book A Hotel"
    And User should perform Book hotel by without entering the fields
    Then User should verify these Error messages after Book hotel "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | username   | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom |
      | suthakarjs | 85~Suthakarjs | Paris    | Hotel Sunshine | Deluxe   | 1 - One   | 10/07/2022  | 11/07/2022   | 2 - Two       | 0 - None      |
