package game.figures;

import game.Coord;

public abstract class Figure {

	/**
	 * Для каждой фигуры мы создаем фиксированную таблицу возможных ходов фигуры. Это позволит в дальнейшем не проверять
     * может ли фигура ходить на заданную координату. Таблица убийств - по сути только для пешки.
	 */
	protected final boolean[][] moveTable;
	protected final boolean[][] killTable;

	protected String type;
	protected boolean color;

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

//	TODO Мы на вход в этих двух методах получаем енамы. Как потом найти по ним значение в таблице? Нужны ли нам эти енамы вообще?

	public boolean getMoveTable(Coord in, Coord out) {
		return false;
	}

	public String getType() {
		return type;
	}



}
