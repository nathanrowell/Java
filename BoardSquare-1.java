/**
 * Lab 5
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This class represents a square on the gameboard.
 * @author Nathan Rowell ( I worked on this alone )
 * 4/11/2023
 */
public class BoardSquare {
    protected boolean empty;
    protected Unit unit;
    protected String squareColor;
    protected boolean specialSquare;
    // If the boardSquare is a special square, it rewards the player + 2 points.

    public BoardSquare(String color) {
        this.squareColor = color;
        this.empty = true;
        this.specialSquare = false;
    }

    public boolean isEmpty() {
        return empty;
    }

    public Unit getUnit() {
        return unit;
    }

    public String getSquareColor() {
        return squareColor;
    }
    public void setSpecialSquare() {this.specialSquare = true;}

    public void setUnit(Unit unit) {
        // sets a unit to a square on the board.
        this.unit = unit;
        this.empty = false;
    }


    public Unit removeUnit() {
        // removes the unit from the square on the board.
        Unit temporary;
        temporary = this.unit;
        this.unit = null;
        this.empty = true;
        this.specialSquare = false;
        return temporary;
    }
    // public boolean SpecialSquare, set some to true
    public String toString() {
        if (isEmpty()) {
            return ("-------");

        }
        else {
            return ("-" + unit.toString() + "-");
        }
    }
}
