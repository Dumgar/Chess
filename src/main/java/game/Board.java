package game;

import game.figures.Figure;

public class Board {

	private Figure[][] cells = new Figure[64][64];


	private void move() {

	}

	public Figure getCell(Coord coord) {

		return cells[coord.getLetter().ordinal()][coord.getNum().ordinal()];
	}
	public Figure getCell(int i, int j) {
		return cells[i][j];
	}

	/**
	 * принимает на вход координаты  в виде пары значений перечислимого типа
	 * ПЕРЕНЕС этот метод из фигуры сюда.
	 */
	public boolean checkMove(Coord in, Coord out) {
		if (getCell(in).getMoveTable(in, out) || getCell(in).getKillTable(in, out)){
			int horizonDelta=0;
			int verticalDelta=0;
			if (in.getLetter()==out.getLetter()){
				verticalDelta = out.getNum().ordinal()-in.getNum().ordinal();
				if (verticalDelta>0){
					for (int i = in.getNum().ordinal()+1;i<out.getNum().ordinal();i++){
						if (getCell(i, in.getLetter().ordinal()) != (null)){
							return false;
						}
					}
					//Дальше проверяем.
				}
			}
		}
		return false;
	}


}
