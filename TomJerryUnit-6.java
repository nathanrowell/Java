/**
 * Lab 7
 * CISC 181-021L Spring 2023
 * University of Delaware
 * The class TomJerryUnit extends Unit and represents the Unit that is placed on the board.
 * @author Nathan Rowell, Ujjwala Pothula
 * 5/3/2023
 */
public class TomJerryUnit extends Attacker {
    private boolean homingRocket;
    private boolean offerCheese;
    private boolean hiding;


    public TomJerryUnit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, boolean homingRocket, boolean offerCheese, boolean hiding, String teamColor) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor);
        this.homingRocket = homingRocket;
        this.offerCheese = offerCheese;
        this.hiding = hiding;
    }

    public TomJerryUnit() {
        this('T', "Tom & Jerry", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, true, true, false, "Red");
    }

    public boolean canHomingRocket() {
        return this.homingRocket;
    }

    public boolean canOfferCheese() {
        return this.offerCheese;
    }

    public boolean isHiding() {
        return this.hiding;
    }

    public void setHomingRocket(boolean newHomingRocket) {
        this.homingRocket = newHomingRocket;
    }

    public void setOfferCheese(boolean newOfferCheese) {
        this.offerCheese = newOfferCheese;
    }

    public void setHiding(boolean newHiding) {
        this.hiding = newHiding;
    }

    public double dealDamage() {
        // this method describes the damage it deals.
        double totalDamage;
        totalDamage = this.damage + this.damageModifier;
        if (this.homingRocket) {
            totalDamage = totalDamage + 10;
        }
        return totalDamage;
    }

    public TomJerryUnit spawn() {
        // spawns a TomJerryUnit
        TomJerryUnit newTom = new TomJerryUnit();
        return newTom;
    }

    public void takeDamage(double damage) {
        // determines how the unit takes damage.
        if (hiding) {
            this.health = this.health;
        } else {
            this.health = this.health - damage;
        }


    }

    public boolean canSpawn() {
        // depicts the ability of the class if it can spawn - is from the abstract method in Unit
        return true;


    }

    @Override
    public boolean validMovePath(int rowIndexMoving, int columnIndexMoving, int rowIndexMoved, int columnIndexMoved) {
        return true;
    }

    @Override
    public boolean validSpawnPath(int rowIndexSpawning, int columnIndexSpawning, int rowIndexSpawned, int columnIndexSpawned) {
        return true;
    }


    @Override
    public boolean validAttackPath(int rowIndexRecruiting, int columnIndexRecruiting, int rowIndexRecruited, int columnIndexRecruited) {
        if (columnIndexRecruited == columnIndexRecruiting) {
            return true;
        }
        if (rowIndexRecruiting == (rowIndexRecruited + 2) && columnIndexRecruited == columnIndexRecruiting) {
            return true;
        }
        return false;
    }
}


