package game.figures;

public class Pawn extends Figure {

//    private final boolean[][] moveTable;

    private final boolean[][] killTable;

//    private String type;
//    private boolean color;

    public Pawn(boolean color) {
        this.type = "pawn";
        this.color = color;

        moveTable = new boolean[64][64];
        for (int i = 1; i < 63; i++) {
            if (i % 8 != 0)
                moveTable[i][i+1] = true;
        }

        for (int i = 1; i < 63; i++) {
            if (i % 8 != 0 && (i-1) % 8 != 0)
                moveTable[i][i+9] = true;
        }

    }
}
