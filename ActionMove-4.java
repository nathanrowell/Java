/**
 * Lab 7
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This is the class that extends Action and moves the unit to a different space.
 * @author Nathan Rowell, Ujjwala Pothula
 * 5/3/2023
 */
public class ActionMove extends Action {

    public ActionMove(Game game, int rowIndexFrom, int columnIndexFrom, int rowIndexTo, int columnIndexTo) {
        super(game, rowIndexFrom, columnIndexFrom, rowIndexTo, columnIndexTo);
    }

    @Override
    public void performAction() {
        /**
         * Performs the action of moving
         * @param no parameters
         * @return no return, just moves on the board.
         */
        BoardSquare[][] boardSquares = game.getBoardSquares();
        Unit newUnit = boardSquares[rowIndexFrom][columnIndexFrom].removeUnit();
        boardSquares[rowIndexTo][columnIndexTo].setUnit(newUnit);
        game.changeTurn();
    }
    @Override
    public String toString() {


        return game.getOpponentPlayer().getPlayersTeam().getTeamColor() + " team's " + game.getBoardSquares()[rowIndexTo][columnIndexTo]
                .getUnit().getName() + " unit moves from " + rowIndexFrom + "," + columnIndexFrom + " to " + rowIndexTo + "," + columnIndexTo;


    }
}
