package game.figures;

import game.Coord;

public abstract class Figure {

	/**
	 * Для каждой фигуры мы создаем фиксированную таблицу возможных ходов фигуры. Это позволит в дальнейшем не проверять
     * может ли фигура ходить на заданную координату. Таблица убийств - по сути только для пешки.
	 */
	protected boolean[][] moveTable;
	protected boolean[][] killTable;

	protected String type;
	protected boolean color;

	public Figure() {}

	public boolean isWhite() {
		return color;
	}

	//TODO Помоему методы написаны неправильно
	public boolean getKillTable(Coord in, Coord out) {
        int inTemp = in.getLetterOrd() * 10 + in.getNumOrd();
        int outTemp = out.getLetterOrd() * 10 + out.getNumOrd();
        return killTable[inTemp][outTemp];
	}

	public boolean getMoveTable(Coord in, Coord out) {
        int inTemp = in.getLetterOrd() * 10 + in.getNumOrd();
        int outTemp = out.getLetterOrd() * 10 + out.getNumOrd();
        return moveTable[inTemp][outTemp];
	}

	public String getType() {
		return type;
	}

    private void createTable() {}
}
