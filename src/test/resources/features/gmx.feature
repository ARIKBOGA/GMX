#  - Go to page 'https://mail.com'
#  - Login with the given account
#  - Click on the link 'My account'
#  - Click on the link 'Personal Data'
#  - Open the profile edit page
#  - Change the name of the User (currently 'Tom Tester') to some other name
#  - Check that the new name was successfully stored


Feature: User account settings feature

  Background: Login
    Given User goes to home page
    When User clicks to login button to be able to open login window
    When User enters credentials
    And User clicks to login-submit button
    Then User should be able to logged in successfully

  @wip
  Scenario: Verify that user should be able to change his name via profile edit page
    Given User clicks to My Account link and goes to page
    And User clicks to Personal Data link and goes to page
    And User clicks to Profile link and goes to page
    And User changes his own name and lastname to "Burak" & "Arikboga"
    When User goes back to My Account page
    Then User should see the new name and last name as "Burak Arikboga"