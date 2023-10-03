public class ActionPoints extends Action {
    // Action Points removes the unit from the board and team and in exchange gives an extra point
    public ActionPoints(Game game, int rowIndexFrom, int columnIndexFrom, int rowIndexTo, int columnIndexTo) {
        super(game, rowIndexFrom, columnIndexFrom, rowIndexTo, columnIndexTo);
    }

    @Override
    public void performAction() {
        game.getCurrentPlayer().points = game.getCurrentPlayer().points + 2;
        BoardSquare[][] boardSquares = game.getBoardSquares();
        Unit newUnit = boardSquares[rowIndexFrom][columnIndexFrom].removeUnit();
        game.getCurrentPlayer().team.removeUnitsFromTeam(newUnit);
        game.changeTurn();
    }
    @Override
    public String toString() {
        return game.getWinner().getPlayersTeam().getTeamColor() + " team's" + " unit got points from " + rowIndexFrom + "," + columnIndexFrom;


    }
}
