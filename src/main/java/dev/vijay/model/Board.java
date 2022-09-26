package dev.vijay.model;

import dev.vijay.constant.ExceptionMessage;
import dev.vijay.exception.InvalidInputException;

public class Board {
    private Cell [][]cells;
    private int dimension;
    private int moveCount;

    /***
     * To count the number of symbols marked on board for each player per row
     * column 0 is used for Player1
     * column 1 is used for Player2
     * rows are specific to each row on the board
     */
    private int[][] rowCount;

    /***
     * To count the number of symbols marked on board for each player per column
     * column 0 is used for Player1
     * column 1 is used for Player2
     * rows are specific to each column on the board
     */
    private int[][] colCount;

    /***
     * To count the number of symbols marked on board for each player per diagonal
     * column 0 is used for Player1
     * column 1 is used for Player2
     * row 0 is for the main diagonal and row 1 for the anti-diagonal
     */
    private int[][] diagonalCount;

    private final int PLAYER1_INDEX = 0;
    private final int PLAYER2_INDEX = 1;
    private final int MAIN_DIAGONAL_INDEX = 0;
    private final int ANTI_DIAGONAL_INDEX = 1;

    public int[][] getRowCount(){
        return this.rowCount;
    }

    public int[][] getColCount(){
        return this.colCount;
    }

    public int[][] getDiagonalCount(){
        return this.diagonalCount;
    }

    public int getPLAYER1_INDEX(){
        return this.PLAYER1_INDEX;
    }

    public int getPLAYER2_INDEX(){
        return this.PLAYER2_INDEX;
    }

    public int getMAIN_DIAGONAL_INDEX(){
        return this.MAIN_DIAGONAL_INDEX;
    }
    public int getANTI_DIAGONAL_INDEX(){
        return this.ANTI_DIAGONAL_INDEX;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
    Board(int dimension){
        this.dimension = dimension;
        cells = new Cell[dimension][dimension];
        for(int rIndex = 0; rIndex < dimension; rIndex++){
            for(int cIndex = 0; cIndex < dimension; cIndex++){
                cells[rIndex][cIndex] = new Cell();
            }
        }
        rowCount = new int[dimension][2];
        colCount = new int[dimension][2];
        diagonalCount = new int[2][2];
    }

    /***
     * Prints the board in the format
     *      0   1   2   3 ...
     * 0    _   _   _   _
     * 1    _   X   _   _
     * 2    _   _   O   _
     * 3    _   _   _   _
     * .
     */
    public void print(){
        System.out.print("\t");
        for(int index = 0; index < dimension; index++){
            System.out.print(index+"\t");
        }
        System.out.println();
        for(int rIndex = 0; rIndex < dimension; rIndex++){
            System.out.print(rIndex + "\t");
            for(int cIndex = 0; cIndex < dimension; cIndex++){
                if(cells[rIndex][cIndex].getSymbol() == Symbol.NONE){
                    System.out.print("_\t");
                }
                else {
                    System.out.print(cells[rIndex][cIndex].getSymbol().toString()+"\t");
                }
            }
            System.out.println();
        }
    }

    /***
     * Method checks if the move made by the Player is valid
     * 1. Move is invalid if the position so chosen is already marked(i.e. Cell is not vacant)
     * 2. In all the other cases, Move is considered to be valid
     * @param rIndex 0 indexed row position on the board
     * @param cIndex o indexed column position on the board
     * @return True if the move made by the Player is valid else False
     * @throws Exception is thrown in case of Invalid Input
     */
    public boolean isValidMove(int rIndex, int cIndex) throws Exception{
        //If the position is not within the dimension of the board
        if(rIndex < 0 || rIndex >= dimension || cIndex < 0 || cIndex >= dimension){
            throw new InvalidInputException(ExceptionMessage.INVALID_INPUT);
        }

        //If the Cell on the Board is not vacant
        if(cells[rIndex][cIndex].getSymbol() != Symbol.NONE){
            throw  new InvalidInputException(ExceptionMessage.INVALID_INPUT);
        }

        return true;
    }

    /***
     * Method marks the Cell on the Board with the Player's Symbol
     * @param rIndex 0 indexed row position on the board
     * @param cIndex 0 indexed column position on the board
     * @param player current Player making the move, used to obtain his symbol
     */
    public void markBaord(int rIndex, int cIndex, Player player){

        //Get Player symbol and mark the Cell with that symbol
        Symbol symbol = player.getSymbol();
        cells[rIndex][cIndex].setSymbol(symbol);

        //Increment the number symbol counts for the corresponding row, column and diagonals for the specific Player
        //If Player1
        if(symbol == Symbol.X){
            //Player1 symbols in the specific row
            rowCount[rIndex][PLAYER1_INDEX] += 1;

            //Player1 symbols in the specific column
            colCount[cIndex][PLAYER1_INDEX] += 1;

            //Player1 symbols in the main diagonal
            if(rIndex == cIndex){
                diagonalCount[MAIN_DIAGONAL_INDEX][PLAYER1_INDEX] += 1;
            }

            //Player1 symbols in the anti-diagonal
            if(rIndex + cIndex == dimension - 1){
                diagonalCount[ANTI_DIAGONAL_INDEX][PLAYER1_INDEX] += 1;
            }
        }
        //Player2
        else{
            //Player2 symbols in the specific row
            rowCount[rIndex][PLAYER2_INDEX] += 1;

            //Player2 symbols in the specific column
            colCount[cIndex][PLAYER2_INDEX] += 1;

            //Player2 symbols in the main diagonal
            if(rIndex == cIndex){
                diagonalCount[MAIN_DIAGONAL_INDEX][PLAYER2_INDEX] += 1;
            }

            //Player2 symbols in the anti-diagonal
            if(rIndex + cIndex == dimension - 1){
                diagonalCount[ANTI_DIAGONAL_INDEX][PLAYER2_INDEX] += 1;
            }
        }
    }
}
