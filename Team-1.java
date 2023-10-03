/**
 * Lab 5
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This class represents a team on the board, which contains a color and  an ArrayList of Units.
 * @author Nathan Rowell ( I worked on this alone )
 * 4/11/2023
 */
import java.util.ArrayList;

public class Team {
    public String teamColor;
    public ArrayList<Unit> teamUnits;
    public Team(String color, ArrayList<Unit> teamUnits) {
        this.teamColor = color;
        this.teamUnits = teamUnits;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public ArrayList<Unit> getTeamUnits() {
        return teamUnits;
    }
    public void removeUnitsFromTeam(Unit unit) {
        teamUnits.remove(unit);
    }
    // removes Units from the arraylist
    public void addUnitsToTeam(Unit unit) {
        // adds Units to the arraylist
        unit.teamColor = this.teamColor;
        teamUnits.add(unit);
    }
    public String toString() {


        return ("Team " + this.teamColor + " " + " Units : " + "\n" + getTeamUnits().toString());
    }
}
