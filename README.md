# connect-4-simulation
This project will help determine the best moves for an abbreviated game of Connect4. The program will analyze the best starting position to make a move. Due to processing times our Connect4 board will be 4 x 4, versus a 7x7 board of the game (the actual board is 7 x 6).

![image](https://user-images.githubusercontent.com/65920033/147157175-5d0583b4-d557-43ab-bef8-946fb4125fff.png)
  
The program will explore making its first move in each of the four columns. The first action will be to make a move in one of the four columns. The program will then pass the Board, and the next player to a Play method. The Play method will analyze the board and call itself up to 4 times, representing the possible number of next moves. At times the Play method may call itself less than four times due to the condition that a column is full. The Play method will return a 1 if the game is won by the first player, -1 if won by the second player, and zero, if that moves leads to a tie.  Hence Play (board, clr)  gives you the Net wins for first player, given the board position represented by board, and the next move is to be taken by clr.
A game is won if 4 discs of the same color appear in a column , row or diagonal.
