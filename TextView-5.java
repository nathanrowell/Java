/**
 * Lab 7
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This class represents the textview, which provides the text interface.
 * @author Nathan Rowell, Ujjwala Pothula, Ananya Sriram
 * 5/3/2023
 */
import java.util.Scanner;

public class TextView {
    private int rowIndexMaking;
    private int colIndexMaking;
    private int rowIndexReceiving;
    private int colIndexReceiving;
    private char actionType;

    public int getRowIndexMaking() {
        return rowIndexMaking;
    }

    public void setRowIndexMaking(int rowIndexMaking) {
        this.rowIndexMaking = rowIndexMaking;
    }

    public int getColIndexMaking() {
        return colIndexMaking;
    }

    public void setColIndexMaking(int colIndexMaking) {
        this.colIndexMaking = colIndexMaking;
    }

    public int getRowIndexReceiving() {
        return rowIndexReceiving;
    }

    public void setRowIndexReceiving(int rowIndexReceiving) {
        this.rowIndexReceiving = rowIndexReceiving;
    }

    public int getColIndexReceiving() {
        return colIndexReceiving;
    }

    public void setColIndexReceiving(int colIndexReceiving) {
        this.colIndexReceiving = colIndexReceiving;
    }

    public char getActionType() {
        return actionType;
    }

    public void setActionType(char actionType) {
        this.actionType = actionType;
    }
    public static char getUsersNextActionType(Scanner object) {
        /**
         * Gets a users move type (A or R or M or S)
         * @param object gets the user's input
         * @return the char entered representing the move choice.
         */
        char charEntered;
        charEntered = object.next().charAt(0);
        while (((charEntered == 'p') || (charEntered == 'P') ||(charEntered == 'a') || (charEntered == 'A') || (charEntered == 'r') || (charEntered == 'R') || (charEntered == 'S') || (charEntered == 's') || (charEntered == 'M') || (charEntered == 'm')) == false)  {
            System.out.println("Type A or M or R or S");
            charEntered = object.next().charAt(0);
        }
        if (charEntered == 'a') {
            charEntered = 'A';
        }
        if (charEntered == 'r') {
            charEntered = 'R';
        }
        if (charEntered == 's') {
            charEntered = 'S';
        }
        if (charEntered == 'm') {
            charEntered = 'M';
        }
        // Updated to add P
        if (charEntered == 'p') {
            charEntered = 'P';
        }
        return charEntered;

    }
    public static int getValidInt(int minNum, int maxNum, Scanner scan) {
/**
 * @param: int minNum, int maxNum, Scanner object
 * @return: An integer value between the boundaries
 * This function basically returns the if number entered by the user.
 * The user can enter anything, so there is a first check to see if the
user
 * entered a num or not and then whether its between the bounds.
 */
        int num = 0;
        boolean validValue = false;
        while (!validValue) {
            System.out.println("Keep Trying until in range: ");
            if (scan.hasNextInt()) {
                num = scan.nextInt();
                if (num >= minNum && num <= maxNum) {
                    validValue = true;
                }
            } else {
                validValue = false;
                scan.next();
            }
        }
        return num;
    }
    public void getNextPlayersAction(Game game) {
        /**
         * Gets a users action type as well as the columns and rows From square and To square.
         * @param game that represents the game being played.
         * @return void, it is there to work as a getter
         */
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter Action");
        this.actionType = getUsersNextActionType(scnr);
        System.out.println("Enter Row Index for From Square");
        this.rowIndexMaking = getValidInt(0,game.board.getNumRows(),scnr);
        System.out.println("Enter Column Index for From Square");
        this.colIndexMaking = getValidInt(0,game.board.getNumColumns(),scnr);
        System.out.println("Enter Row Index for To Square");
        this.rowIndexReceiving = getValidInt(0,game.board.getNumRows(),scnr);
        System.out.println("Enter Column Index for To Square");
        this.colIndexReceiving = getValidInt(0,game.board.getNumColumns(),scnr);

    }
    public void updateView(Game game) {
        /**
         * prints the game board
         * @param game that represents the game being played.
         * @return void, it just prints
         */
        System.out.println(game.toString());
    }
    public void printEndOfGameMessage(Game game) {
        /**
         * prints the game board when the game is finished, and returns the winning team
         * @param game that represents the game being played.
         * @return void, it just prints
         */
        Player winner = game.getWinner();
        System.out.println("The Game has ended and Team " + winner.getPlayerNumber() + " has won.");
    }



}
