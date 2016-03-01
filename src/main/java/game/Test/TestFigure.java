package game.Test;

import game.figures.Figure;
import game.figures.Pawn;

/**
 * Created by raulett on 01.03.2016.
 */
public class TestFigure {
    public static void main(String[] args) {
        Figure blackFigure = new Pawn(false);
        Figure whiteFigure = new Pawn(true);
    }
}
