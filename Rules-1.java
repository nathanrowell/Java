/**
 * Lab 7
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This is the rules class that returns a boolean value if the inputted action and index on the game board returns an allowed value.
 * @author Nathan Rowell, Ujjwala Pothula
 * 5/3/2023
 */
public class Rules {
    public static boolean checkValidAction(Game game, int rowIndexFrom, int columnIndexFrom, int rowIndexTo, int columnIndexTo, char actionType) {
        // checks if the action entered is valid and returns a boolean based on that
        Unit unit;
        BoardSquare arr[][] = new BoardSquare[rowIndexFrom][columnIndexFrom];
        if (game.board.inBounds(rowIndexFrom, columnIndexFrom) && game.board.inBounds(rowIndexTo, columnIndexTo)) {
            if (!game.getBoardSquares()[rowIndexFrom][columnIndexFrom].isEmpty()) {
                if (game.getCurrentPlayer().getPlayersTeam().getTeamUnits().contains(game.getBoardSquares()[rowIndexFrom][columnIndexFrom].getUnit())) {
                    if (actionType == 'P') {
                        return true;
                    }
                    if (game.getBoardSquares()[rowIndexTo][columnIndexTo].isEmpty()) {
                        if (actionType == 'M') {
                            if (game.getBoardSquares()[rowIndexFrom][columnIndexFrom].getUnit().validMovePath(rowIndexFrom, columnIndexFrom, rowIndexTo, columnIndexTo)) {
                                return true;
                            }
                        }

                        else if (actionType == 'S') {
                            if (game.getBoardSquares()[rowIndexFrom][columnIndexFrom].getUnit().canSpawn()) {
                                if (game.getBoardSquares()[rowIndexFrom][columnIndexFrom].getUnit().validSpawnPath(rowIndexFrom, columnIndexFrom, rowIndexTo, columnIndexTo)) {
                                    return true;
                                }
                            }


                        }


                    } else if (game.getOpponentPlayer().getPlayersTeam().getTeamUnits().contains(game.getBoardSquares()[rowIndexTo][columnIndexTo].getUnit())) {
                        if (actionType == 'R') {
                            if (game.getBoardSquares()[rowIndexFrom][columnIndexFrom].getUnit() instanceof BartSimpsonUnit) {
                                return true;
                            }
                        } else if (actionType == 'A') {
                            if (game.getBoardSquares()[rowIndexFrom][columnIndexFrom].getUnit() instanceof TomJerryUnit) {
                                return true;
                            }
                        }
                    }
                }
            }
        }


        return false;
    }
}


