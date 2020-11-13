# Rakenne

## Tietokantakaavio
![Tietokantataulut](https://github.com/juliapalorinne/ohtu/blob/main/viikko3/LoginCucumber/documentation/UML.jpg)

### Koodi:

[App|IO: io;AuthenticationService: auth]
[AuthenticationService|UserDao: userDao]
[<<Interface>>IO|int: readInt;String: readLine]
[ConsoleIO|Scanner: scanner]
[StubIO|List(String): lines]
[<<Interface>>UserDao|List(User): users;]
[InMemoryUserDao|]
[User|String: username;String: password]


[IO]->[ConsoleIO]
[IO]->[StubIO]
[UserDao]->[InMemoryUserDao]

[InMemoryUserDao]*-1[User]
[UserDao]*-1[User]
[App|]1-1[AuthenticationService|]
[App]1-1[IO]
[AuthenticationService]1-1[UserDao]
