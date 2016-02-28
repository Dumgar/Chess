package game.figures;

/**
 * Created by romandmitriev on 28.02.16.
 */
public class Bishop extends Figure {

    private final boolean[][] moveTable;
    private final boolean[][] killTable;

    public Bishop(boolean color) {
        this.color = color;
        this.type = "rook";


    }
}
