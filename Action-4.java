/**
 * Lab 7
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This is the abstract action class that will be extended to the other action types that will be used
 * to do the 4 different actions possible.
 * @author Nathan Rowell, Ujjwala Pothula
 * 5/3/2023
 */
public abstract class Action {
    public Game game;
    public int rowIndexFrom;
    public int columnIndexFrom;
    public int rowIndexTo;
    public int columnIndexTo;
    public Action (Game game, int rowIndexFrom, int columnIndexFrom, int rowIndexTo, int columnIndexTo) {
        this.game = game;
        this.rowIndexFrom = rowIndexFrom;
        this.columnIndexFrom = columnIndexFrom;
        this.rowIndexTo = rowIndexTo;
        this.columnIndexTo = columnIndexTo;
    }
    public abstract void performAction();
    // this is the abstract method the other things extended off Action will use.

}
