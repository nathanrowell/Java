import java.util.ArrayList;

public class Player {
    /**
     * Creates a Player class with fields:
     * playerNumber (int)
     * turn (boolean)
     * team (Team object)
     * Along with 3 different types of constructors.
     */
    public int playerNumber;
    public boolean turn;
    public Team team;
    public int points;
    // added Points
    public int getPlayerNumber() {return this.playerNumber;}
    public Team getPlayersTeam() {return this.team;}
    public void setPlayersTeam(Team team) {this.team = team;}
    public int getPoints() {return this.points;}
    public void setPoints(int points) {this.points = points;}

    public boolean isTurn() {
        return this.turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
    public Player(int playerNumber, boolean turn, Team unit) {
        this.playerNumber = playerNumber;
        this.turn = turn;
        this.team = unit;
    }
    public Player(int playerNumber, Team unit) {
        this.playerNumber = playerNumber;
        this.turn = false;
        this.team = unit;
    }
    public Player() {
        this.playerNumber = 2;
        this.turn = false;
        this.team = new Team("White", new ArrayList<Unit>());
    }


}
