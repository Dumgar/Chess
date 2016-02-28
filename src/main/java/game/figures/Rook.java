package game.figures;

/**
 * Created by romandmitriev on 28.02.16.
 */
public class Rook extends Figure {

    private final boolean[][] moveTable;
    private final boolean[][] killTable;

    public Rook(boolean color) {
        this.color = color;
        this.type = "rook";


    }
}
