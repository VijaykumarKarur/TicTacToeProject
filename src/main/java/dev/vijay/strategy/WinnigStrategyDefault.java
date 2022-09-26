package dev.vijay.strategy;

import dev.vijay.model.Board;
import dev.vijay.model.Player;
import dev.vijay.model.Symbol;

public class WinnigStrategyDefault implements IWinningStrategy{
    /***
     * Method determines if the Player won the Game. A Player wins if either
     * 1. Any of the row is entirely marked by a Player or
     * 2. Any of the column is entirely marked by a Player or
     * 3. Any of the diagonals - main and anti, are entirely marked by a player
     * @param rIndex 0 indexed row position on the board
     * @param cIndex 0 indexed column position on the board
     * @param player current Player making the move
     * @param board of the Game
     * @return true if Player won else false
     */
    @Override
    public boolean hasWon(Board board, Player player, int rIndex, int cIndex) {
        //Get Player's symbol
        Symbol symbol = player.getSymbol();

        int[][] rowCount = board.getRowCount();
        int[][] colCount = board.getColCount();
        int[][] diagonalCount = board.getDiagonalCount();
        int PLAYER1_INDEX = board.getPLAYER1_INDEX();
        int PLAYER2_INDEX = board.getPLAYER2_INDEX();
        int dimension = board.getDimension();
        int MAIN_DIAGONAL_INDEX = board.getMAIN_DIAGONAL_INDEX();
        int ANTI_DIAGONAL_INDEX = board.getANTI_DIAGONAL_INDEX();

        //If Player1
        if(symbol == Symbol.X){
            //If any of the row, or column, or diagonal is entirely marked by the Player
            if(rowCount[rIndex][PLAYER1_INDEX] == dimension ||
                    colCount[cIndex][PLAYER1_INDEX] == dimension ||
                    diagonalCount[MAIN_DIAGONAL_INDEX][PLAYER1_INDEX] == dimension ||
                    diagonalCount[ANTI_DIAGONAL_INDEX][PLAYER1_INDEX] == dimension){
                return true;
            }
        }
        //If Player2
        else{
            //If any of the row, or column, or diagonal is entirely marked by the Player
            if(rowCount[rIndex][PLAYER2_INDEX] == dimension ||
                    colCount[cIndex][PLAYER2_INDEX] == dimension ||
                    diagonalCount[MAIN_DIAGONAL_INDEX][PLAYER2_INDEX] == dimension ||
                    diagonalCount[ANTI_DIAGONAL_INDEX][PLAYER2_INDEX] == dimension){
                return true;
            }
        }
        return false;
    }
}
