/**
 * Lab 7
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This is the main class of the game that represents where the controller is happening, this includes the main class
 * that has people either recruit, attack, move, or spawn a unit, this is where the entire game plays out.
 * @author Nathan Rowell, Ujjwala Pothula, Ananya Sriram
 * 5/3/2023
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Controller {
    private Game game;
    private TextView textview;
    private GameEventsLinkedList gameEvents;
    private ArrayList<GameEventsLinkedList> eventLists;

    public Game setUpGameModel(){
        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();

        // adds a new PeterPan Unit
        PeterPanUnit bs = new PeterPanUnit();
        bs.setTeamColor("Blu");


        TomJerryUnit tj = new TomJerryUnit();
        tj.setTeamColor("Blu");


        piecesTeamA.add(bs);
        piecesTeamA.add(tj);


        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);
        Player playerOne = new Player(1, true, teamA);


        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamB = new ArrayList<Unit>();


        BartSimpsonUnit bs2 = new BartSimpsonUnit();
        bs2.setTeamColor("Red");

        // Adds a new WinnieThePoohUnit
        WinnieThePoohUnit wp2 = new WinnieThePoohUnit();
        wp2.setTeamColor("Red");


        piecesTeamB.add(bs2);
        piecesTeamB.add(wp2);


        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);
        Player playerTwo = new Player(2, false, teamB);


        // Create an instance of the game
        return new Game(8, 8, playerOne, playerTwo);
    }
    public Controller() {
        this.game = setUpGameModel();
        // adds the 3 special squares
        this.game.board.squares[3][3].specialSquare = true;
        this.game.board.squares[3][4].specialSquare = true;
        this.game.board.squares[3][5].specialSquare = true;
        // creates the linked lists and array lists for later
        gameEvents = new GameEventsLinkedList();
        eventLists = new ArrayList<>();
        TextView textview = new TextView();
        this.textview = textview;
        textview.updateView(this.game);
    }


    public void testForSpecial(Game game) {
        int playerNum = 0;
        // NEW BOARD SQUARE: This tests for if the board square is special, and in exchange gives 2 points if they land on it.
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (game.board.squares[row][column].specialSquare == true) {
                    if (game.board.squares[row][column].isEmpty() == false) {
                        game.board.squares[row][column].specialSquare = false;
                        game.getOpponentPlayer().points = game.getOpponentPlayer().points + 2;
                        if (game.getOpponentPlayer().playerNumber == 1) {
                            playerNum = 1;
                        }
                        else {
                            playerNum = 2;
                        }
                        System.out.println("Player " + new String(String.valueOf(playerNum)) + " Has landed on Special Space and Got 2 Bonus Points");
                    }
                }
            }
        }

    }
    public int total_moves = 0;
    public int total_points = 0;
    public int total_recruits = 0;
    public int total_spawns = 0;
    public int total_attacks = 0;
    public void carryOutAction(int rowIndexFrom, int colIndexFrom, int rowIndexTo, int colIndexTo, char action) {
        // does whatever action is inputted
        // updates the linked lists
        if (action == 'M') {
            ActionMove actions = new ActionMove(this.game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            actions.performAction();
            String eventDetails = actions.toString();
            GameEventsLinkedList.GameEvent gameEvent = new GameEventsLinkedList.GameEvent(game.getCurrentPlayer().playerNumber, "Move", eventDetails);
            GameEventsLinkedList.GameEventNode node = new GameEventsLinkedList.GameEventNode(gameEvent);
            gameEvents.push(node);
            total_moves = total_moves + 1;
        }
        if (action == 'R') {
            ActionRecruit actions = new ActionRecruit(this.game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            actions.performAction();
            String eventDetails = actions.toString();
            GameEventsLinkedList.GameEvent gameEvent = new GameEventsLinkedList.GameEvent(game.getCurrentPlayer().playerNumber, "Recruit", eventDetails);
            GameEventsLinkedList.GameEventNode node = new GameEventsLinkedList.GameEventNode(gameEvent);
            gameEvents.push(node);
            total_recruits = total_recruits + 1;
        }
        if (action == 'S') {
            ActionSpawn actions = new ActionSpawn(this.game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            actions.performAction();
            String eventDetails = actions.toString();
            GameEventsLinkedList.GameEvent gameEvent = new GameEventsLinkedList.GameEvent(game.getCurrentPlayer().playerNumber, "Spawn", eventDetails);
            GameEventsLinkedList.GameEventNode node = new GameEventsLinkedList.GameEventNode(gameEvent);
            gameEvents.push(node);
            total_spawns = total_spawns + 1;
        }
        if (action == 'A') {
            ActionAttack actions = new ActionAttack(this.game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            actions.performAction();
            String eventDetails = actions.toString();
            GameEventsLinkedList.GameEvent gameEvent = new GameEventsLinkedList.GameEvent(game.getCurrentPlayer().playerNumber, "Attack", eventDetails);
            GameEventsLinkedList.GameEventNode node = new GameEventsLinkedList.GameEventNode(gameEvent);
            gameEvents.push(node);
            total_attacks = total_attacks + 1;
        }
        if (action == 'P') {
            ActionPoints actions = new ActionPoints(this.game, rowIndexFrom, colIndexFrom, rowIndexTo, colIndexTo);
            actions.performAction();
            String eventDetails = actions.toString();
            GameEventsLinkedList.GameEvent gameEvent = new GameEventsLinkedList.GameEvent(game.getCurrentPlayer().playerNumber, "Points", eventDetails);
            GameEventsLinkedList.GameEventNode node = new GameEventsLinkedList.GameEventNode(gameEvent);
            gameEvents.push(node);
            total_points = total_points + 1;
        }


    }

    public void playGame() {
        game.player1.setPoints(0);
        game.player2.setPoints(0);

    // plays the game
        while (game.isGameEnded() == false) {
            // NEW RULE: If the player has 9 points, it skips their turn and subtracts 2 points from their total.
            if (game.getCurrentPlayer().points == 9) {
                game.getCurrentPlayer().points = game.getCurrentPlayer().points - 2;
                game.changeTurn();
                System.out.println("CURRENT PLAYER HAS 9 POINTS, TURN SKIPPED, AND LOST TWO POINTS");
                System.out.println("NEW TOTAL:");
                System.out.println("Player 1 has " + game.player1.getPoints() +  " Points");
                System.out.println("Player 2 has " + game.player2.getPoints() +  " Points");
            }
            textview.updateView(game);
            textview.getNextPlayersAction(this.game);
            boolean testing = Rules.checkValidAction(this.game, textview.getRowIndexMaking(), textview.getColIndexMaking(), textview.getRowIndexReceiving(), textview.getColIndexReceiving(), textview.getActionType());
            while (testing == false) {
                textview.getNextPlayersAction(this.game);
                testing = Rules.checkValidAction(this.game, textview.getRowIndexMaking(), textview.getColIndexMaking(), textview.getRowIndexReceiving(), textview.getColIndexReceiving(), textview.getActionType());
            }
            carryOutAction(textview.getRowIndexMaking(), textview.getColIndexMaking(), textview.getRowIndexReceiving(), textview.getColIndexReceiving(), textview.getActionType());
            testForSpecial(this.game);
            // Give points is for the objective
            game.givePoints();
            // New Objective: If a player hits 10 points they win.
            System.out.println("Player 1 has " + game.player1.getPoints() +  " Points");
            System.out.println("Player 2 has " + game.player2.getPoints() +  " Points");
            }
        textview.updateView(game);
        // Depicts the winning move / the last turn of the game
        if (!gameEvents.isEmpty()) {
            GameEventsLinkedList.GameEventNode lastNode = gameEvents.pop();
            System.out.println("Winning Move: " + lastNode.getGameState().getEventDetails());
        }


        // These are for adding the gameEvents to a new array of linked lists to count how many were in each
        if (total_moves >= 1) {
            eventLists.add(gameEvents.pop("Move"));
        }
        if (total_spawns >= 1) {
            eventLists.add(gameEvents.pop("Spawn"));
        }
        if (total_recruits >= 1) {
            eventLists.add(gameEvents.pop("Recruit"));
        }
        if (total_attacks >= 1) {
            eventLists.add(gameEvents.pop("Attack"));
        }
        if (total_points >= 1) {
            eventLists.add(gameEvents.pop("Points"));
        }

        // Sorts the list by size using a Lambda collection feature.
        Collections.sort(eventLists, (list1, list2) -> Integer.compare(list2.getSize(), list1.getSize()));
        // Prints out the sizes of each action
        for (GameEventsLinkedList eventList : eventLists) {
            System.out.println("eventType: " + eventList.getHead().getGameState().getEventType() + ", size: " + eventList.getSize());
        }
        // If the action was not done, it will print that it had a size of 0.
        if (total_moves == 0) {
            System.out.println("eventType: Move, size: 0");
        }
        if (total_spawns == 0) {
            System.out.println("eventType: Spawn, size: 0");
        }
        if (total_recruits == 0) {
            System.out.println("eventType: Recruit, size: 0");
        }
        if (total_attacks == 0) {
            System.out.println("eventType: Attack, size: 0");
        }
        if (total_points == 0) {
            System.out.println("eventType: Points, size: 0");
        }

        textview.printEndOfGameMessage(game);
        }

    public static void main(String args[]) {
        Controller controller = new Controller();
        controller.playGame();

    }
}

