package game;

import java.util.Arrays;

public abstract class Figure {

	/**
	 * Таблица возможных ходов
	 * и убийств
	 */
	private final boolean[][] moveTable;

	private final boolean[][] killTable;

	private String type;
	private boolean color;

    /**
     *
     */

	/**
	 * Добавил в конструктор
	 */

	public Figure() {
		moveTable = new boolean[64][64];
		killTable = new boolean[64][64];
		type = null;
		color = true;
	}

	public boolean isWhite() {
		return color;
	}

	public boolean getKillTable(Coord in, Coord out) {
		return false;
	}

	public boolean getMoveTable(Coord in, Coord out) {
		return false;
	}

	public String getType() {
		return type;
	}



}
