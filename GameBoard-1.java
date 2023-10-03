/**
 * Lab 5
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This class represents the entire GameBoard, made up of an amount of rows, columns, and
 * represented through a 2d array on board squares.
 * @author Nathan Rowell ( I worked on this alone )
 * 4/11/2023
 */
public class GameBoard {
    public int numRows;
    public int numColumns;
    public BoardSquare[][] squares;
    public GameBoard(int rows, int columns) {
        this.numRows = rows;
        this.numColumns = columns;
        this.squares = new BoardSquare[rows][columns];
        setUpEmptyBoard();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public BoardSquare[][] getSquares() {
        return squares;
    }
    public boolean inBounds(int row, int column) {
        // Determines if a row and column given is in the bounds of the game board squares.
        if (row < 0 || column <0) {
            return false;
        }
        if (row < this.numRows && column < this.numColumns) {
            return true;
        }
        else {
            return false;
        }
    }
    private void setUpEmptyBoard() {
        // creates a new empty board

        for (int row = 0; row < this.numRows; row++) {
            for (int column = 0; column < this.numColumns; column++) {
                squares[row][column] = new BoardSquare("White");
            }
        }

    }
    public BoardSquare findRandomEmptySpace() {
        // finds a random empty space on the board.
        int row = (int) Math.random();
        int column = (int) Math.random();
        if (squares[row][column].empty == true) {
            return squares[row][column];
        }
        else {
            while (squares[row][column].empty == false) {
                row = (int) (Math.random()*this.numRows);
                column = (int) (Math.random()*this.numColumns);
            }
            return squares[row][column];
        }
    }
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }



}

