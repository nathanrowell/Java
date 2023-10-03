/**
 * Lab 7
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This class is the parent class of TomJerryUnit and BartSimpsonUnit.
 * It takes it a lot of similar fields and then works as a connector between the two.
 * @author Nathan Rowell, Ujjwala Pothula
 * 5/3/2023
 */


public abstract class Unit{
    protected String teamColor;
    protected char symbol;
    protected String name;
    protected double health;
    protected double healthModifier;
    protected double damage;
    protected double damageModifier;
    protected int luck;
    protected int xCor;
    protected int yCor;
    protected int movement;
    protected int movementModifier;
    public Unit() {}
    // 0 Parameter Constructor
    public Unit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor) {
        // 12 Parameter Constructor
        this.teamColor = teamColor;
        this.symbol = symbol;
        this.name = name;
        this.health = health;
        this.healthModifier = healthModifier;
        this.damage = damage;
        this.damageModifier = damageModifier;
        this.luck = luck;
        this.xCor = xCor;
        this.yCor = yCor;
        this.movement = movement;
        this.movementModifier = movementModifier;
    }
    public char getSymbol() {return this.symbol;}
    public String getName() {return this.name;}
    public double getHealth() {return this.health;}
    public double getHealthModifier() {return this.healthModifier;}
    public double getDamage() {return this.damage;}
    public double getDamageModifier() {return this.damageModifier;}
    public int getLuck() {return this.luck;}
    public int getxCor() {return this.xCor;}
    public int getyCor() {return this.yCor;}
    public int getMovement() {return this.movement;}
    public int getMovementModifier() {return this.movementModifier;}
    public void setName(String newName) {
        this.name = newName;
    }
    public void setSymbol(char newSymbol) {
        this.symbol = newSymbol;
    }
    public void setHealth(double newHealth) {
        this.health = newHealth;
    }
    public void setHealthModifier(double newHealthModifier) {
        this.healthModifier= newHealthModifier;
    }
    public void setDamage(double newDamage) {
        this.damage = newDamage;
    }
    public void setDamageModifier(double newDamageModifier) {
        this.damageModifier = newDamageModifier;
    }
    public void setLuck(int newLuck) {
        this.luck = newLuck;
    }
    public void setxCor(int newXCor) {
        this.xCor = newXCor;
    }
    public void setyCor(int newYCor) {
        this.yCor = newYCor;
    }
    public void setMovement(int newMovement) {
        this.movement = newMovement;
    }
    public void setMovementModifier(int newMovementModifier) {
        this.movementModifier = newMovementModifier;
    }


    public abstract Unit spawn();
    // Abstract method spawns in the units on their own classes
    public abstract boolean canSpawn();


    public String getTeamColor() {
        // Getter for TeamColor
        return teamColor;
    }


    public void setTeamColor(String teamColor) {
        // Setter for TeamColor
        this.teamColor = teamColor;
    }
    public String toString() {
        // toString for this class, it returns the team color and the symbol.
        return (this.teamColor + " " + this.symbol);
    }
    public abstract boolean validMovePath(int rowIndexMoving, int columnIndexMoving, int rowIndexMoved, int columnIndexMoved);
    public abstract boolean validSpawnPath(int rowIndexSpawning, int columnIndexSpawning, int rowIndexSpawned, int columnIndexSpawned);




}
