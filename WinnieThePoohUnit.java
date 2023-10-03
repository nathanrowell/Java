public class WinnieThePoohUnit extends TomJerryUnit{
    // New Unit WinnieThePooh extends TomJerryUnit but moves like a knight on a chess board (+2+1)
    public WinnieThePoohUnit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, boolean homingRocket, boolean offerCheese, boolean hiding, String teamColor) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier,homingRocket,offerCheese,hiding, teamColor);
    }
    public WinnieThePoohUnit() {
        this('W', "Winnie The Pooh", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, true, true, false, "Red");
    }
    @Override
    public boolean validMovePath(int rowIndexMoving, int columnIndexMoving, int rowIndexMoved, int columnIndexMoved) {
        if ((rowIndexMoving == (rowIndexMoved+2)) && (columnIndexMoved == (columnIndexMoving+1)) || (rowIndexMoving == (rowIndexMoved-2)) && (columnIndexMoved == (columnIndexMoving+1)) || (rowIndexMoving == (rowIndexMoved+2)) && (columnIndexMoved == (columnIndexMoving-1)) || (rowIndexMoving == (rowIndexMoved-2)) && (columnIndexMoved == (columnIndexMoving-1)) || (rowIndexMoving == (rowIndexMoved+1)) && (columnIndexMoved == (columnIndexMoving+2)) || (rowIndexMoving == (rowIndexMoved+1)) && (columnIndexMoved == (columnIndexMoving-2)) || (rowIndexMoving == (rowIndexMoved-1)) && (columnIndexMoved == (columnIndexMoving+2)) || (rowIndexMoving == (rowIndexMoved-1)) && (columnIndexMoved == (columnIndexMoving-2))) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean validSpawnPath(int rowIndexSpawning, int columnIndexSpawning, int rowIndexSpawned, int columnIndexSpawned) {
        if ((rowIndexSpawning == (rowIndexSpawned+2)) && (columnIndexSpawned == (columnIndexSpawning+1)) || (rowIndexSpawning == (rowIndexSpawned-2)) && (columnIndexSpawned == (columnIndexSpawning+1)) || (rowIndexSpawning == (rowIndexSpawned+2)) && (columnIndexSpawned == (columnIndexSpawning-1)) || (rowIndexSpawning == (rowIndexSpawned-2)) && (columnIndexSpawned == (columnIndexSpawning-1)) || (rowIndexSpawning == (rowIndexSpawned+1)) && (columnIndexSpawned == (columnIndexSpawning+2)) || (rowIndexSpawning == (rowIndexSpawned+1)) && (columnIndexSpawned == (columnIndexSpawning-2)) || (rowIndexSpawning == (rowIndexSpawned-1)) && (columnIndexSpawned == (columnIndexSpawning+2)) || (rowIndexSpawning == (rowIndexSpawned-1)) && (columnIndexSpawned == (columnIndexSpawning-2))) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public boolean validAttackPath(int rowIndexRecruiting, int columnIndexRecruiting, int rowIndexRecruited, int columnIndexRecruited) {
        if ((rowIndexRecruiting == (rowIndexRecruited+2)) && (columnIndexRecruited == (columnIndexRecruiting+1)) || (rowIndexRecruiting == (rowIndexRecruited-2)) && (columnIndexRecruited == (columnIndexRecruiting+1)) || (rowIndexRecruiting == (rowIndexRecruited+2)) && (columnIndexRecruited == (columnIndexRecruiting-1)) || (rowIndexRecruiting == (rowIndexRecruited-2)) && (columnIndexRecruited == (columnIndexRecruiting-1)) || (rowIndexRecruiting == (rowIndexRecruited+1)) && (columnIndexRecruited == (columnIndexRecruiting+2)) || (rowIndexRecruiting == (rowIndexRecruited+1)) && (columnIndexRecruited == (columnIndexRecruiting-2)) || (rowIndexRecruiting == (rowIndexRecruited-1)) && (columnIndexRecruited == (columnIndexRecruiting+2)) || (rowIndexRecruited == (rowIndexRecruited-1)) && (columnIndexRecruited == (columnIndexRecruiting-2))) {
            return true;
        }
        else {
            return false;
        }
    }


}
