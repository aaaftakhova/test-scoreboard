# Test Task Execution: Scoreboard Library
This repository reflects the test task execution of the implementation of a Live Football World Cup Scoreboard library.

### Functional Requirements
Develop Live Football World Cup Scoreboard library that shows all the ongoing matches and their
scores.
The scoreboard supports the following operations:
1. Start a new game, assuming initial score 0 – 0 and adding it the scoreboard.
   This should capture following parameters:
   a. Home team
   b. Away team
2. Update score. This should receive a pair of absolute scores: home team score and away
   team score.
3. Finish game currently in progress. This removes a match from the scoreboard.
4. Get a summary of games in progress ordered by their total score. The games with the same
   total score will be returned ordered by the most recently started match in the scoreboard.

### Approach

1. Start as simple as possible, creating just the essentials.
1. Define the test cases in the test classes.
1. Implement the test cases
1. During test cases implementation some refactoring was done. 
   
   For the cause of the simplicity some cases have been eliminated:
   
   * If the game has already been started the start game method has no effect instead of throwing an exception
   * Update score method has no effect if caller tries to update score to the same score. No exception is thrown.
   
   Added additional test cases & logic:
   * Disallow same team to be the home & away team at the same game.
   * Disallow the team to play multiple game simultaneously
   custom business exceptions
1. Then the business logic was implemented (see more details to the sorting concept below).

#### Sorting concept
1. Original idea was to have a start time attribute at the Game.class which is automatically set to the current instant 
   when game is created & started at the scoreboard. 

Then it would be easy to sort the games by their start time when necessary.
   However, the written tests have shown, that Instant class is unable to capture the time difference between the match 
starts, when they are created right after another.
   So this approach has the accuracy limitation and can become inefficient if the scoreboard needs to start matches in a
short period of time.
   
1. Another approach is to use the data structure that preserves the insertion order.
This is the approach that was implemented. Newer games are prepended to the existing game list. This way if all games 
   have the same score, the games will be sorted top-to-bottom beginning with most recently started by a natural order.
   The scoreboard's method that provides list of active games sorts the returned list additionally by the total score.

#### Testing concept
1. Both entity classes have been covered with unit tests.
2. Since the scoreboard class doesn't expose any methods, that can allow manipulating the contents of the game list, 
   except for start game & update score methods mocking test data wasn't a convenient option, so tests use real class 
   instances instead of mocks.
3. Validator classes were deliberately left uncovered by unit tests, because their functionality has already been 
   covered by game & scoreboard unit tests.
   
#### Extendability
Current solution followed the simplicity goal. It can be further improved to make it more scalable as follows:
1. Implementing a comparator class, would allow replacing sorting order logic more easily.
2. Some mapper/converter classes can be introduced to allow to format the output according to the client's requirements
3. Game & Scoreboard classes could be converted to abstract classes and extended by a family of classes implementing 
   different type of scoreboards & games. 

   

