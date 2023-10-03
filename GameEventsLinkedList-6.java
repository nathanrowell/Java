/**
 * Final Project
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This lab works through linked lists and how they can be adjusted.
 * @author Nathan Rowell, Ujjwala Pothula, Ananya Sriram
 * 5/3/2023
 */
import java.util.LinkedList;
public class GameEventsLinkedList {

    protected static class GameEvent {
        public int playerNumber;
        public String eventType;
        public String eventDetails;


        public GameEvent(int playerNumber, String eventType, String eventDetails) {
            this.playerNumber = playerNumber;
            this.eventType = eventType;
            this.eventDetails = eventDetails;
        }


        public int getPlayerNumber() {
            return playerNumber;
        }

        public void setPlayerNumber(int playerNumber) {
            this.playerNumber = playerNumber;
        }

        public String getEventType() {
            return eventType;
        }

        public void setEventType(String eventType) {
            this.eventType = eventType;
        }

        public String getEventDetails() {
            return eventDetails;
        }

        public void setEventDetails(String eventDetails) {
            this.eventDetails = eventDetails;
        }
    }

    public static class GameEventNode {
        private GameEvent gameState;
        private GameEventNode next;

        public GameEventNode(GameEvent gameState) {
            this.gameState = gameState;
            this.next = null;

        }

        public GameEvent getGameState() {
            return gameState;
        }

        public void setGameState(GameEvent gameState) {
            this.gameState = gameState;
            this.next = null;
        }

        public GameEventNode getNext() {
            return next;
        }

        public void setNext(GameEventNode next) {
            this.next = next;
        }
    }

    private GameEventNode head;
    private int size;


    public GameEventNode getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public GameEventsLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        /*
         * Tests if the linked list is empty or not.
         */
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public void push(GameEventNode node1) {
        GameEventNode tempNode = head;
        if (isEmpty()) { //if the head is null, then set the first head to node1.
            head = node1;
        }
        else {
           node1.setNext(head);
           head = node1;

        }
        size++;
    }
    public GameEventNode pop() {
        // pops something out
        GameEventNode node1 = head.getNext();
        GameEventNode temp = head;
        head = node1;
        return temp;
    }
    //
    public GameEventsLinkedList pop(String gameEvent) {
        // pop with one parameter, sorts by anything that matches the string
        GameEventNode node1 = head;
        GameEventNode previusNode = null;
        GameEventsLinkedList linkedList = new GameEventsLinkedList();
        while (node1 != null) {
            if (node1.getGameState().getEventType().equals(gameEvent)) {
                if (previusNode == null) {
                    head = node1.getNext();
                }
                else {
                    previusNode.setNext(node1.getNext());
                }
                linkedList.push(new GameEventNode(node1.getGameState()));



            }
            previusNode = node1;
            node1 = node1.getNext();

        }
        return linkedList;
    }
    public void add(GameEventNode eventNode) {
        /*
         * Takes in an eventNode and then adds it from the linked list. It also increases the size
         * of the linked list.
         */
        if (head==null) {
            head = eventNode;
        }
        else {
            GameEventNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(eventNode);
        }
        size = size + 1;

    }
    public GameEvent remove(GameEventNode eventNode) {
        /*
         * Takes in an eventNode and then removes it from the linked list. It also decreases the size
         * of the linked list.
         */
        GameEvent removed = eventNode.getGameState();
        if (head == null) {
            return null;
        }
        if (eventNode == head) {
            head = eventNode.getNext();
            size = size - 1;
            return removed;
        }
        GameEventNode current = head;
        while (current.getNext() != null && current.getNext() != eventNode) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            return null;
        }
        size = size - 1;
        current.setNext(eventNode.getNext());
        return removed;

    }

    public void display() {
        /*
         * Displays the eventTypes of everything in the list.
         */
        GameEventNode current = head;
        while (current != null) {
            System.out.println(current.getGameState().getEventDetails());
            current = current.getNext();
        }
    }
}
