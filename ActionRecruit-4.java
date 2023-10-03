/**
 * Lab 7
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This is the class that extends Action and takes a piece and turns it into the opposing team.
 * @author Nathan Rowell, Ujjwala Pothula
 * 5/3/2023
 */
public class ActionRecruit extends Action{

    public ActionRecruit(Game game, int rowIndexFrom, int columnIndexFrom, int rowIndexTo, int columnIndexTo) {
        super(game, rowIndexFrom, columnIndexFrom, rowIndexTo, columnIndexTo);
    }


    @Override
    public void performAction() {
        /**
         * Performs the action of recruiting
         * @param no parameters
         * @return no return, just recruits on the board.
         */
        BoardSquare[][] boardSquares = game.getBoardSquares();
        Unit newUnit = boardSquares[rowIndexTo][columnIndexTo].getUnit();
        if (game.player1.turn == true) {
            newUnit.setTeamColor(game.player1.getPlayersTeam().getTeamColor());
            game.player2.team.removeUnitsFromTeam(newUnit);
            game.player1.team.addUnitsToTeam(newUnit);

        }
        else {
            newUnit.setTeamColor(game.player2.getPlayersTeam().getTeamColor());
            game.player1.team.removeUnitsFromTeam(newUnit);
            game.player2.team.addUnitsToTeam(newUnit);
        }
        boardSquares[rowIndexTo][columnIndexTo].setUnit(newUnit);
        game.changeTurn();

    }
    @Override
    public String toString() {


        return game.getWinner().getPlayersTeam().getTeamColor() + " team's " + game.getBoardSquares()[rowIndexTo][columnIndexTo]
                .getUnit().getName() + " unit recruits from " + rowIndexFrom + "," + columnIndexFrom + " to " + rowIndexTo + "," + columnIndexTo;


    }
}
