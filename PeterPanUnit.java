public class PeterPanUnit extends Recruiter{
    // New Unit WinnieThePooh extends Recruiter but moves diagonally (+1+1)

    public PeterPanUnit(char symbol, String name, double health, double healthModifier, double damage, double damageModifier, int luck, int xCor, int yCor, int movement, int movementModifier, String teamColor, int numRecruits) {
        super(symbol, name, health, healthModifier, damage, damageModifier, luck, xCor, yCor, movement, movementModifier, teamColor, numRecruits);
    }
    public PeterPanUnit () {this ('P', "Peter Pan", 100.0, 0.0, 25.0, 0.0, 0, 5, 5, 1, 0, "Red",0); }

    @Override
    public boolean validRecruitPath(int rowIndexRecruiting, int columnIndexRecruiting, int rowIndexRecruited, int columnIndexRecruited) {
        if ((rowIndexRecruited == (rowIndexRecruiting+1) && (columnIndexRecruited == (columnIndexRecruiting+1))) || (rowIndexRecruited == (rowIndexRecruiting-1) && (columnIndexRecruited == (columnIndexRecruiting+1))) || (rowIndexRecruited == (rowIndexRecruiting+1) && (columnIndexRecruited == (columnIndexRecruiting-1))) || (rowIndexRecruited == (rowIndexRecruiting-1) && (columnIndexRecruited == (columnIndexRecruiting-1)))) {
            return true;
        }
        return false;
    }

    @Override
    public Unit spawn() {
        return null;
    }

    @Override
    public boolean canSpawn() {
        return false;
    }

    @Override
    public boolean validMovePath(int rowIndexMoving, int columnIndexMoving, int rowIndexMoved, int columnIndexMoved) {
        if ((rowIndexMoved == (rowIndexMoving+1) && (columnIndexMoved == (columnIndexMoving+1))) || (rowIndexMoved == (rowIndexMoving-1) && (columnIndexMoved == (columnIndexMoving+1))) || (rowIndexMoved == (rowIndexMoving+1) && (columnIndexMoved == (columnIndexMoving-1))) || (rowIndexMoved == (rowIndexMoving-1) && (columnIndexMoved == (columnIndexMoving-1)))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean validSpawnPath(int rowIndexSpawning, int columnIndexSpawning, int rowIndexSpawned, int columnIndexSpawned) {
        if ((rowIndexSpawned == (rowIndexSpawning+1) && (columnIndexSpawned == (columnIndexSpawning+1))) || (rowIndexSpawned == (rowIndexSpawning-1) && (columnIndexSpawned == (columnIndexSpawning+1))) || (rowIndexSpawned == (rowIndexSpawning+1) && (columnIndexSpawned == (columnIndexSpawning-1))) || (rowIndexSpawned == (rowIndexSpawning-1) && (columnIndexSpawned == (columnIndexSpawning-1)))) {
            return true;
        }
        return false;
    }
}
