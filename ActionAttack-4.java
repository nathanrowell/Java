/**
 * Lab 7
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This is the abstract class that extends Action and does the actual attack, it deals damage to
 * TomJerryUnits, and removes if the health of the TomJerryUnit is 0. It will remove any BartSimpsonUnit if attacked.
 * @author Nathan Rowell, Ujjwala Pothula
 * 5/3/2023
 */
public class ActionAttack extends Action{

    public ActionAttack(Game game, int rowIndexFrom, int columnIndexFrom, int rowIndexTo, int columnIndexTo) {
        super(game, rowIndexFrom, columnIndexFrom, rowIndexTo, columnIndexTo);
    }

    @Override
    public void performAction() {
        /**
         * Performs the action of attacking
         * @param no parameters
         * @return no return, just moves on the board.
         */
        BoardSquare[][] boardSquares = game.getBoardSquares();
        Unit newUnit = boardSquares[rowIndexFrom][columnIndexFrom].getUnit();
        Unit newUnit2 = boardSquares[rowIndexTo][columnIndexTo].getUnit();


        if (game.player1.turn == true) {

            if (newUnit.getName() == "Tom & Jerry") {
                TomJerryUnit newTJUnit = (TomJerryUnit) boardSquares[rowIndexFrom][columnIndexFrom].getUnit();
                if (newUnit2.getName() == "Tom & Jerry") {
                    TomJerryUnit newTJUnit2 = (TomJerryUnit) boardSquares[rowIndexTo][columnIndexTo].getUnit();
                    double dealDamage = newTJUnit.dealDamage();
                    newTJUnit2.takeDamage(dealDamage);
                    if (newTJUnit2.health <= 0) {
                        boardSquares[rowIndexTo][columnIndexTo].removeUnit();
                        boardSquares[rowIndexFrom][columnIndexFrom].removeUnit();
                        game.player2.team.removeUnitsFromTeam(newTJUnit2);
                        boardSquares[rowIndexTo][columnIndexTo].setUnit(newUnit);
                        game.changeTurn();
                    }

                }
                if (newUnit2.getName() == "Bart Simpson") {
                    BartSimpsonUnit newBart = (BartSimpsonUnit) boardSquares[rowIndexTo][columnIndexTo].getUnit();
                    boardSquares[rowIndexTo][columnIndexTo].removeUnit();
                    boardSquares[rowIndexFrom][columnIndexFrom].removeUnit();
                    game.player2.team.removeUnitsFromTeam(newBart);
                    boardSquares[rowIndexTo][columnIndexTo].setUnit(newUnit);
                    game.changeTurn();
                }
            }
        }
        else {
            if (newUnit.getName() == "Tom & Jerry") {
                TomJerryUnit newTJUnit = (TomJerryUnit) boardSquares[rowIndexFrom][columnIndexFrom].getUnit();

                if (newUnit2.getName() == "Tom & Jerry") {
                    TomJerryUnit newTJUnit2 = (TomJerryUnit) boardSquares[rowIndexTo][columnIndexTo].getUnit();
                    double dealDamage = newTJUnit.dealDamage();
                    newTJUnit2.takeDamage(dealDamage);
                    if (newTJUnit2.health <= 0) {
                        boardSquares[rowIndexTo][columnIndexTo].removeUnit();
                        boardSquares[rowIndexFrom][columnIndexFrom].removeUnit();
                        game.player1.team.removeUnitsFromTeam(newTJUnit2);
                        boardSquares[rowIndexTo][columnIndexTo].setUnit(newUnit);
                        game.changeTurn();
                    }

                }
                if (newUnit2.getName() == "Bart Simpson") {
                    BartSimpsonUnit newBart = (BartSimpsonUnit) boardSquares[rowIndexTo][columnIndexTo].getUnit();
                    boardSquares[rowIndexTo][columnIndexTo].removeUnit();
                    boardSquares[rowIndexFrom][columnIndexFrom].removeUnit();
                    game.player1.team.removeUnitsFromTeam(newBart);
                    boardSquares[rowIndexTo][columnIndexTo].setUnit(newUnit);
                    game.changeTurn();
                }
            }

        }

    }
    @Override
    public String toString() {


        return game.getWinner().getPlayersTeam().getTeamColor() + " team's " + game.getBoardSquares()[rowIndexTo][columnIndexTo]
                .getUnit().getName() + " unit attacks from " + rowIndexFrom + "," + columnIndexFrom + " to " + rowIndexTo + "," + columnIndexTo;


    }

}
