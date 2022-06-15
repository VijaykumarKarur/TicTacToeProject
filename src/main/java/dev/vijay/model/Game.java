package dev.vijay.model;

import dev.vijay.factory.PlayerFactory;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(int dimension, PlayerType playerType1, PlayerType playerType2){
        this.board = new Board(dimension);
        this.player1 = PlayerFactory.getPlayer(playerType1);
        this.player2 = PlayerFactory.getPlayer(playerType2);
        this.player1.setSymbol(Symbol.X);
        this.player2.setSymbol(Symbol.O);
        this.currentPlayer = this.player1;
    }

    /***
     * Game Launch method with the following steps -
     * 1. print the board
     * 2. Continue while the board is not full
     * 3. Prompt current user to input row and col on the board to mark his move
     * 4. Obtain position from player makeMove method
     * 5. Validate the position input by current user
     * 6. If valid, mark the current user symbol on board and print
     * 7. Increment the valid move count to keep track of the valid number of moves on board
     * 8. Check if current user won the game, print the message and return
     * 9. flip the current user to other player in the game
     * 10 repeat till all cells on the board are filled. If so, marks the end of the game in draw
     *
     */
    public void launch(){
        System.out.println();
        board.print();
        while(board.getMoveCount() < board.getDimension() * board.getDimension()){
            System.out.println(currentPlayer.getSymbol() + " - Please enter the row and column (seperated by space): ");
            try {
                int[] position = currentPlayer.makeMove(board.getDimension());

                //Check if the move was valid
                if(board.isValidMove(position[0], position[1])){

                    //mark the cell on board with player's symbol and print the board
                    board.markBaord(position[0],position[1],currentPlayer);
                    System.out.println();
                    board.print();

                    board.setMoveCount(board.getMoveCount() + 1);

                    //check if the current user won after his move
                    if(board.isWinningMove(position[0], position[1], currentPlayer)){
                        System.out.println("***************************************************************");
                        System.out.println("Player "+currentPlayer.getSymbol()+" WON the Game");
                        System.out.println("***************************************************************");
                        return;
                    }

                    //flip current user
                    if(currentPlayer == player1){
                        currentPlayer = player2;
                    }
                    else{
                        currentPlayer = player1;
                    }
                }
            }
            catch(Exception exception){
                System.out.println(exception.getMessage());
            }
        }
        //The board is filled and Game ended in draw
        System.out.println("***************************************************************");
        System.out.println("Game Ended in Draw");
        System.out.println("***************************************************************");
    }
}
