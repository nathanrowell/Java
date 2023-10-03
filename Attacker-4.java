/**
 * Lab 7
 * CISC 181-021L Spring 2023
 * University of Delaware
 * This is the class that extends TomJerryUnit and sets up an Attacker unit.
 * @author Nathan Rowell, Ujjwala Pothula
 * 5/3/2023
 */
public abstract class Attacker extends Unit{
    private int numAttacks;
    public Attacker(char symbol, String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor);
        this.numAttacks = numAttacks;




    }




    public int getNumAttacks() {
        return this.numAttacks;
    }




    public void setNumRecruits(int numAttacks) {
        this.numAttacks = numAttacks; ;
    }




    public abstract boolean validAttackPath(int rowIndexRecruiting, int columnIndexRecruiting, int rowIndexRecruited, int columnIndexRecruited);
}
