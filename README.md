# Splendor_game
layer:
Name
Number of Tokens of each type
Points
Cards
Nobles


Card:
Points
Cost by type

Noble:
Requirement



Server (Table):
  Action:
    Send Info
    Validate and Perform Action
  Information:
    All the client's information
    Open Cards
    Available Tokens
    Nobles
    Closed Cards
    Whose Turn it is


Client (Players):
  Action:
    Request Info Table
    Request Info for Player
    Allowed Game Actions
  Information/State:
    Player's/Client's information
    Open Cards
    Available Tokens
    Nobles
    Whose Turn it is

Push based/Pull based
Github:
1. Create Repository (One Time)
2. Create Issues
3. Pick up Issues
4. Create PRs
5. Get reviews
6. Merge
