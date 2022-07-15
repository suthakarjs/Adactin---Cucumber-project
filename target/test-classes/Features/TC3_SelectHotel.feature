@SelectHotel
Feature: Verifying Adactin Select Hotel functionality

Background:
    Given User is on the Adactin login page

@SelectWithHotel
  Scenario Outline: Verifying Adactin Select hotel functionality by choosing any of the hotel
    When User should perform login with "<username>" and "<password>"
    Then User should verify after login "Hello suthakarjs!"
    And User should perform Search by providing all the fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childsPerRoom>"
    Then User should verify after search "Select Hotel"
    And User should perform Select hotel by choosing any of the hotel
    Then User should verify after Select hotel "Book A Hotel"

    Examples: 
      | username   | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom |
      | suthakarjs | 85~Suthakarjs | Paris    | Hotel Sunshine | Deluxe   | 1 - One   | 10/07/2022  | 11/07/2022   | 2 - Two       | 0 - None      |

@SelectWithoutHotel
  Scenario Outline: Verifying Adactin Select hotel functionality by without choosing any of the hotel
    When User should perform login with "<username>" and "<password>"
    Then User should verify after login "Hello suthakarjs!"
    And User should perform Search by providing all the fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childsPerRoom>"
    Then User should verify after search "Select Hotel"
    And User should perform Select hotel by without choosing any of the hotel
    Then User should verify an Error message after Select hotel "Please Select a Hotel"

    Examples: 
      | username   | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom |
      | suthakarjs | 85~Suthakarjs | Paris    | Hotel Sunshine | Deluxe   | 1 - One   | 10/07/2022  | 11/07/2022   | 2 - Two       | 0 - None      |
