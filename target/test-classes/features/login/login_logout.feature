Feature: As a book store user I should be able to login and logout with valid credentials

  #Scenario: Login into the application & create new user
  #Given I am on the Login page URL "https://demoqa.com/books"
  #Then I click on "Login" button
  #Then I click on "New User" button
  #When I enter registration fields
  #| Firstname | Lastname | Username | Password   |
  #| shri      | was      | swas     | 1234testll |
  #Then I click on "Register" button
  
   @smoketest
  Scenario: Login into the application with valid credentials
    Given I am on the Login page URL "https://demoqa.com/books"
    And I click on "Login" button
    When I enter Valid Credentials
      | Username | Password |
      | swasnika | 007@Shri |
    And I click on "Login" button
    Then I validate the "Swasnika" username

 @smoketest
  Scenario: Login into the application with invalid username credentials
    Given I am on the Login page URL "https://demoqa.com/books"
    And I click on "Login" button
    When I enter Valid Credentials
      | Username | Password |
      | swaqq    | 007@Shri |
    And I click on "Login" button
    Then I validate the invalid warning message

 @smoketest
  Scenario: Login into the application with invalid password credentials
    Given I am on the Login page URL "https://demoqa.com/books"
    And I click on "Login" button
    When I enter Valid Credentials
      | Username | Password |
      | swasnika | test123  |
    And I click on "Login" button
    Then I validate the invalid warning message

 @smoketest
  Scenario: Login into the application with invalid username & password credentials
    Given I am on the Login page URL "https://demoqa.com/books"
    And I click on "Login" button
    When I enter Valid Credentials
      | Username | Password |
      | swqqqq   | test123  |
    And I click on "Login" button
    Then I validate the invalid warning message
 
    @smoketest
    Scenario: Login into the application with valid credentials & search a book
    Given I am on the Login page URL "https://demoqa.com/books"
    And I click on "Login" button
    When I enter Valid Credentials
      | Username | Password |
      | swasnika | 007@Shri |
    And I click on "Login" button
    Then I search the "Git Pocket Guide" book
    And I click on "Git Pocket Guide" book name
    And I click on add to your collection button
    Then I navigate to "https://demoqa.com/profile"
    Then I validate the "Git Pocket Guide" book is added
    And I click on "Delete All Books" button
    And I click on "OK" button
    And I delete the added book
    And I click on "Log out" button
  
