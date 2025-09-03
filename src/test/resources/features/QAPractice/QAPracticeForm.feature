Feature: QA Practice Form feature test

  Background:
    Given I navigate to QA Practice home page URL

  Scenario Outline: Verify that the user can register successfully in the form using valid inputs
    When I input "<firstname>" in the firstname field
    And I input "<lastname>" in the lastname field
    And I input "<phoneNumber>" in the phone number field
    And I select "<country>" in the country dropdown
    And I input "<email>" in the email address field
    And I input "<password>" in the password field
    And I tick the terms and conditions checkbox
    Then I verify that terms and conditions checkbox is checked
    When I click the Register button
    Then I verify that the success message is "<successMessage>"
    And I verify that the firstname result value is "<firstname>"
    And I verify that the lastname result value is "<lastname>"
    And I verify that the phone number result value is "<phoneNumber>"
    And I verify that the country result value is "<country>"
    And I verify that the email address result value is "<email>"

    Examples:
    | firstname | lastname      | phoneNumber | country      | email          | password | successMessage                                     |
    | John      | Doe           | 1234567890  | Argentina    | test@email.com | test123! | Successfully registered the following information  |
    | Leandro   | Arellano      | 1234567890  | Argentina    | test@email.com | test123! | Successfully registered the following information  |
    | Leandro   | Arellano      | 1234567890  | Afghanistan  | test@email.com | test123! | Successfully registered the following information  |

  Scenario Outline: Verify that the user cannot register in the form using invalid firstname
    When I input "<firstname>" in the firstname field
    And I input "<lastname>" in the lastname field
    And I input "<phoneNumber>" in the phone number field
    And I select "<country>" in the country dropdown
    And I input "<email>" in the email address field
    And I input "<password>" in the password field
    And I tick the terms and conditions checkbox
    When I click the Register button
    Then I verify that the success message is not displayed
    And I verify that the first name result text is not displayed

    Examples:
      | firstname | lastname      | phoneNumber | country    | email          | password |
      |           | Doe           | 1234567890  | Argentina  | test@email.com | test123! |
      | #$%^&&*   | Doe           | 1234567890  | Argentina  | test@email.com | test123! |

  Scenario Outline: Verify that the user cannot register in the form using invalid lastname
    When I input "<firstname>" in the firstname field
    And I input "<lastname>" in the lastname field
    And I input "<phoneNumber>" in the phone number field
    And I select "<country>" in the country dropdown
    And I input "<email>" in the email address field
    And I input "<password>" in the password field
    And I tick the terms and conditions checkbox
    When I click the Register button
    #Then I verify that the success message is not displayed
    And I verify that the last name result text is not displayed

    Examples:
      | firstname | lastname      | phoneNumber | country    | email          | password |
      | John      |               | 1234567890  | Argentina  | test@email.com | test123! |
      | Leandro   | @#$%^&*(      | 1234567890  | Argentina  | test@email.com | test123! |

  Scenario Outline: Verify that the user cannot register in the form using invalid phone number
    When I input "<firstname>" in the firstname field
    And I input "<lastname>" in the lastname field
    And I input "<phoneNumber>" in the phone number field
    And I select "<country>" in the country dropdown
    And I input "<email>" in the email address field
    And I input "<password>" in the password field
    And I tick the terms and conditions checkbox
    When I click the Register button
    #Then I verify that the success message is not displayed
    And I verify that the error message is "<errorMessage>"
    And I verify that the phone number result text is not displayed

    Examples:
      | firstname | lastname      | phoneNumber | country    | email          | password | errorMessage |
      | John      | Doe           |             | Argentina  | test@email.com | test123! | The phone number should contain at least 10 digits! |
      | Leandro   | Arellano      | @#$%^&*()(  | Argentina  | test@email.com | test123! | The phone number should contain at least 10 digits! |
      | Mary      | Smith         | 123         | Argentina  | test@email.com | test123! | The phone number should contain at least 10 digits! |
      | Olivia    | Smith         | INVALIDPN   | Argentina  | test@email.com | test123! | The phone number should contain at least 10 digits! |

  Scenario Outline: Verify that the user can still register successfully in the form when the country dropdown is empty
    When I input "<firstname>" in the firstname field
    And I input "<lastname>" in the lastname field
    And I input "<phoneNumber>" in the phone number field
    And I input "<email>" in the email address field
    And I input "<password>" in the password field
    And I tick the terms and conditions checkbox
    When I click the Register button
    Then I verify that the success message is "<successMessage>"
    And I verify that the firstname result value is "<firstname>"
    #And I verify that the lastname result value is "<lastname>"
    #And I verify that the phone number result value is "<phoneNumber>"
    And I verify that the country result value is ""
    And I verify that the email address result value is "<email>"

    Examples:
      | firstname | lastname  | phoneNumber | email          | password | successMessage                                    |
      | John      | Doe       | 1234567890  | test@email.com | test123! | Successfully registered the following information |

  Scenario Outline: Verify that the user cannot register in the form using invalid email address
    When I input "<firstname>" in the firstname field
    And I input "<lastname>" in the lastname field
    And I input "<phoneNumber>" in the phone number field
    And I select "<country>" in the country dropdown
    And I input "<email>" in the email address field
    And I input "<password>" in the password field
    And I tick the terms and conditions checkbox
    When I click the Register button
    #Then I verify that the success message is not displayed
    And I verify that the email address result text is not displayed

    Examples:
      | firstname | lastname      | phoneNumber | country      | email           | password |
      | John      | Doe           | 1234567890  | Argentina    |                 | test123! |
      | John      | Doe           | 1234567890  | Argentina    | $%^&*()         | test123! |
      | John      | Doe           | 1234567890  | Argentina    | qwer1234        | test123! |

  Scenario Outline: Verify that the user cannot register in the form using invalid password
    When I input "<firstname>" in the firstname field
    And I input "<lastname>" in the lastname field
    And I input "<phoneNumber>" in the phone number field
    And I select "<country>" in the country dropdown
    And I input "<email>" in the email address field
    And I input "<password>" in the password field
    And I tick the terms and conditions checkbox
    When I click the Register button
    And I verify that the error message is "<errorMessage>"

    Examples:
      | firstname | lastname      | phoneNumber | country      | email           | password                     | errorMessage |
      | John      | Doe           | 1234567890  | Argentina    | test@email.com  | tes                          | The password should contain between [6,20] characters! |
      | John      | Doe           | 1234567890  | Argentina    | test@email.com  | tes1234567890!@#$%^&&&&      | The password should contain between [6,20] characters! |

  Scenario: Verify that the Registration form text contents are correct
    #The expected first name label text should be "First Name*"
    Then I verify that the first name label text is "First Name"
    And I verify that the first name placeholder text is "Enter first name"
    And I verify that the last name label text is "Last Name*"
    And I verify that the last name placeholder text is "Enter last name"
    #And I verify that the phone number label text is "Phone number*"
    And I verify that the phone number placeholder text is "Enter phone number"
    And I verify that the country label text is "Country"
    And I verify that the email address label text is "Email address*"
    And I verify that the email address placeholder text is "Enter email"
    And I verify that the password label text is "Password*"
    And I verify that the password placeholder text is "Enter password"
    And I verify that the terms and conditions label text is "I agree with the terms and conditions"
    And I verify that the note help text is "Note: All the fields marked with * are mandatory"
    And I verify that the phone help text is "Phone length validation: at least 10 digits"
    #The expected text should be changed to a more meaningful password help text
    And I verify that the password help text is "Psw length validation: [6,20] characters"

    Scenario: Verify that the password field masks its value
      Then I verify that the password field masks its value