Feature: User can log in with valid username/password-combination

    Scenario: user can login with correct password
        Given user "kari" with password "salasana1" is created
        And command login is selected
        When username "kari" and password "salasana1" are entered
        Then system will respond with "logged in"


    Scenario: user can not login with incorrect password
        Given user "ville" with password "salainen1" is created
        Given command login is selected
        When username "ville" and password "salasana2" are entered
        Then system will respond with "wrong username or password"

    Scenario: nonexistent user can not login to 
        Given command login is selected
        When username "akkep" and password "salasana1" are entered
        Then system will respond with "wrong username or password"