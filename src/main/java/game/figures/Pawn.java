package game.figures;

public class Pawn extends Figure {

    public Pawn(boolean color) {
        this.type = "pawn";
        this.color = color;

        createTable();
    }

    private void createTable() {
        moveTable = new boolean[64][64];
        for (int i = 1; i < 63; i++) {
            if (i % 8 != 0)
                moveTable[i][i+1] = true;
        }
        //TODO Написать случай, что пешка ходит через клетку.

        killTable = new boolean[64][64];
        for (int i = 1; i < 55; i++) {
            if (i % 8 != 0 && (i-1) % 8 != 0)
                killTable[i][i+9] = true;
        }
    }
}
