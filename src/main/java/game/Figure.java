package game;

import java.util.Arrays;

public abstract class Figure {

	private boolean color;

	/**
	 * Таблица возможных ходов
	 */
	private final Arrays moveTable;

	private final String type;

    /**
     * TODO Если у нас таблица и тип константы, то их нельзя мутить в абстрактном классе
     */

	/**
	 * Таблица куда можно рубить
	 * 
	 */
	private Arrays killTable;

	public boolean isWhite() {
		return false;
	}

	public boolean getKillTable() {
		return false;
	}

	public boolean getMoveTable() {
		return false;
	}

	public String getType() {
		return null;
	}

	/**
	 * принимает на вход координаты  в виде пары значений перечислимого типа
	 */
	public boolean checkMove(Coord in, Coord out) {
		return false;
	}

}
