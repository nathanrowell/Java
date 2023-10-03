/**
 * Final
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This class represents the entire game, with fields of the GameBoard and the two players.
 * @author Nathan Rowell, Ujjwala Pothula, Ananya Sriram
 * 5/3/2023
 */
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    public GameBoard board;
    public Player player1;
    public Player player2;
    private void initializeGameBoard(int rows, int columns) {
        // Creates the game board, and sets the players Units on random empty spaces.
        board = new GameBoard(rows, columns);

        int size = player1.team.teamUnits.size();
        int index = 0;
        while (index < size) {
            BoardSquare open = board.findRandomEmptySpace();
            open.setUnit(player1.team.teamUnits.get(index));
            index = index + 1;
        }
        int size2 = player2.team.teamUnits.size();
        int index2 = 0;
        while (index2 < size2) {
            BoardSquare open = board.findRandomEmptySpace();
            open.setUnit(player2.team.teamUnits.get(index2));
            index2 = index2 + 1;


        }



    }
    public Game(int rows, int columns, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        initializeGameBoard(rows,columns);
    }

    public GameBoard getBoard() {
        return board;
    }
    public Player getCurrentPlayer() {
        // finds which player is their turn
        if (player1.turn == true) {
            return player1;
        }
        else {
            return player2;
        }
    }
    public Player getOpponentPlayer() {
        // find which player is not their turn
        if (player1.turn == true) {
            return player2;
        }
        else {
            return player1;
        }
    }
    public boolean isTurn(Player player) {
        // says if it is their turn or not
        if (player.turn == true) {
            return true;
        }
        return false;
    }
    public BoardSquare[][] getBoardSquares() {
        return getBoard().getSquares();
    }
    public void changeTurn() {
        // changes the players turns
        if (this.player1.turn == true) {
            this.player1.turn = false;
            this.player2.turn = true;
        }
        else {
            this.player1.turn = true;
            this.player2.turn = false;

        }
    }
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getBoard().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s (" + getCurrentPlayer().getPlayersTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }
    public boolean isAWinner() {
        // returns if a player is a winner
        if(player1.getPlayersTeam().getTeamUnits().size() == 0) {
            return true;
        }
        else if(player2.getPlayersTeam().getTeamUnits().size() == 0){
            return true;
        }
        else {
            return false;
        }


    }



    public Player getWinner() {
        // gets whichever player wins when the other player hits 0, if it ties, it returns null
        if(player1.points > player2.points) {
            return player1;
        }
        else if(player2.points > player1.points) {
            return player2;
        }
        // in the event both reach 10, it is settled by who has more time units. If both tie, Player2 Wins
        // because player2 goes second.
        else {
            if (player1.team.teamUnits.size() > player2.team.teamUnits.size()) {
                return player1;
            }
            else {
                return player2;
            }
        }
    }
    public void givePoints() {
        // For Objective
        // New function to give points to players
        int remaining = player1.getPlayersTeam().getTeamUnits().size();
        player1.points = player1.points + remaining;
        int remaining2 = player2.getPlayersTeam().getTeamUnits().size();
        player2.points = player2.points + remaining2;
    }


    public boolean isGameEnded() {
        // gets when the game ends (when a player hits 10 points or has no pieces left)
        if(player1.getPoints() >= 10 || player2.getPoints() >= 10 || player1.team.teamUnits.size() == 0 || player2.team.teamUnits.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }



}
