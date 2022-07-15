@SearchHotel
Feature: Verifying Adactin Search Hotel functionality

Background:
 		Given User is on the Adactin login page

@SearchByAllFields
  Scenario Outline: Verifying Adactin Search hotel with all the fields
    When User should perform login with "<username>" and "<password>"
    Then User should verify after login "Hello suthakarjs!"
    And User should perform Search by providing all the fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childsPerRoom>"
    Then User should verify after search "Select Hotel"

    Examples: 
      | username   | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom |
      | suthakarjs | 85~Suthakarjs | Paris    | Hotel Sunshine | Deluxe   | 1 - One   | 10/07/2022  | 11/07/2022   | 2 - Two       | 0 - None      |

@SearchByMandatory
  Scenario Outline: Verifying Adactin search hotel with mandatory fields
  	When User should perform login with "<username>" and "<password>"
    Then User should verify after login "Hello suthakarjs!"
    And User should perform Search by entering all the mandatory fields only "<location>","<noOfRooms>","<checkInDate>","<checkOutDate>" and "<adultsPerRoom>"
    Then User should verify after search "Select Hotel"

    Examples: 
      | username   | password      | location | noOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | suthakarjs | 85~Suthakarjs | Paris    | 1 - One   | 10/07/2022  | 11/07/2022   | 2 - Two       |

@SearchByBeforeDate
  Scenario Outline: Verifying Adactin Search hotel by providing check-out-date before than check-in-date
    When User should perform login with "<username>" and "<password>"
    Then User should verify after login "Hello suthakarjs!"
    And User should perform Search by providing the check-out-date before than check-in-date "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childsPerRoom>"
    Then User should verify after Search these Error messages "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | username   | password      | location | hotels         | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childsPerRoom |
      | suthakarjs | 85~Suthakarjs | Paris    | Hotel Sunshine | Deluxe   | 1 - One   | 11/07/2022  | 10/07/2022   | 2 - Two       | 0 - None      |

@SearchByEmptyFields
  Scenario Outline: Verifying Adactin Search without entering any fields
    When User should perform login with "<username>" and "<password>"
    Then User should verify after login "Hello suthakarjs!"
    And User should verify an Error message after Search hotel "Please Select a Location"

    Examples: 
      | username   | password      |
      | suthakarjs | 85~Suthakarjs |
