/**
 * Lab 7
 * CISC 181-021L Spring 2023
 * University of Delaware
 * The class BartSimpsonUnit extends Unit and represents the Unit that is placed on the board.
 * @author Nathan Rowell, Ujjwala Pothula
 * 5/3/2023
 */
public class BartSimpsonUnit extends Recruiter{
    private boolean distract;
    private int numTimesSpawned;
    private boolean recruit;

    final static int MAX_NUM_SPAWNED = 1;


    public BartSimpsonUnit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, int numTimesSpawned, boolean distract, boolean recruit, String teamColor, int numRecruits) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor, numRecruits);
        this.numTimesSpawned = numTimesSpawned;
        this.distract = distract;
        this.recruit = recruit;
    }
    public BartSimpsonUnit () {this ('B', "Bart Simpson", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, 0, true, true,"Red",0); }
    public int getNumTimesSpawned() {return this.numTimesSpawned;}
    public boolean canDistract() {return this.distract;}
    public boolean canRecruit() {return this.recruit;}
    public boolean canSpawn() {
        // determines if it can spawn based on the max number it is able to spawn.
        if (this.numTimesSpawned < MAX_NUM_SPAWNED && this.symbol == 'B') {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean validMovePath(int rowIndexMoving, int columnIndexMoving, int rowIndexMoved, int columnIndexMoved) {
        if (rowIndexMoving == rowIndexMoved) {
            return true;
        }
        if (rowIndexMoving == (rowIndexMoved+2) && columnIndexMoved == columnIndexMoving) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean validSpawnPath(int rowIndexSpawning, int columnIndexSpawning, int rowIndexSpawned, int columnIndexSpawned) {
        if (rowIndexSpawned == rowIndexSpawning) {
            return true;
        }
        if (rowIndexSpawning == (rowIndexSpawned+2) && columnIndexSpawned == columnIndexSpawning) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setNumTimesSpawned(int newNumTimesSpawned) {
        this.numTimesSpawned = newNumTimesSpawned;
    }
    public void setDistract(boolean newDistract) {
        this.distract = newDistract;
    }
    public void setRecruit(boolean newRecruit) {
        this.recruit = newRecruit;
    }
    public void distracted() {
        // if this.distract is equal to true, it will print that the unit is distracted.
        if (this.distract) {
            System.out.println("Unit Distracted!");
        }
    }
    public BartSimpsonUnit spawn() {
        // spawns a bartSimpsonUnit, but also changes the value of numTimesSpawned.
        BartSimpsonUnit newBart = new BartSimpsonUnit('b', "Bart Simpson", 100.0, 5.0, 25.0, 10.0, 0, 1, 1, 1, 1, 0, true, false,"Red",0);
        this.numTimesSpawned = 1;
        return newBart;
    }

    @Override
    public boolean validRecruitPath(int rowIndexRecruiting, int columnIndexRecruiting, int rowIndexRecruited, int columnIndexRecruited) {
        if (rowIndexRecruiting == rowIndexRecruited) {
            return true;
        }
        if (rowIndexRecruiting == (rowIndexRecruited+2) && columnIndexRecruiting == columnIndexRecruited) {
            return true;
        }
        else {
            return false;
        }
    }
}
