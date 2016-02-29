package game;

import game.figures.Figure;
import game.figures.Knight;

public class Board {

	private Figure[][] cells = new Figure[64][64];


	private void move() {

	}

	public Figure getCell(Coord coord) {

		return cells[coord.getLetterOrd()][coord.getNumOrd()];
	}
	public Figure getCell(int i, int j) {
		return cells[i][j];
	}

	/**
	 * Метод отвечат на вопрос. Свободен ли путь фигуры из начальной точки в конечную?
	 * Идея метода следующая.
	 * 1) Проверяем по табличке, может ли фигура вообще пойти в искомую точку (первый иф)
	 * 2) Проверяем препятствия на пути. Для этого надо понять, есть ли фигуры в клетках между начальной и конечной клетками маршрута. Начальную и конечную клетку не рассматриваем.
	 * - Проверяем случай когда маршрут вертикальный
	 * -горизонтальный
	 * -диагональный
	 * -это конь (маршрут пуст)
	 *
	 */
	public boolean checkMove(Coord in, Coord out) {
		if (getCell(in).getMoveTable(in, out) || getCell(in).getKillTable(in, out)){
			int delta=0;
			//Вертикальный ход фигуры
			if (in.getLetter()==out.getLetter()){
				delta = out.getNumOrd()-in.getNumOrd();
				if (delta>0){
					for (int i = in.getNumOrd()+1;i<out.getNumOrd();i++){
						if (getCell(i, in.getLetterOrd()) != (null)){
							return false;
						}
					}
					return true;
				}
				if (delta<0){
					for (int i = in.getNumOrd()-1; i > out.getNumOrd(); i--){
						if (getCell(i, in.getLetterOrd()) != (null)){
							return false;
						}
					}
					return true;
				}
			}
			//Горизонтальный ход
			if (in.getNum()==out.getNum()){
				delta = out.getLetterOrd()-in.getLetterOrd();
				if (delta>0) {
					for (int i = in.getLetterOrd()+1; i < out.getLetterOrd(); i++){
						if (getCell(i, in.getNumOrd()) != (null)){
							return false;
						}
					}
					return true;
				}
				if (delta<0) {
					for (int i = in.getLetterOrd()-1; i > out.getLetterOrd(); i--){
						if (getCell(i, in.getNumOrd()) != (null)){
							return false;
						}
					}
					return true;
				}
			}
			//Диагональный ход
			if (out.getLetterOrd()-in.getLetterOrd() == out.getNumOrd() - in.getNumOrd()){
				delta = out.getLetterOrd()-in.getLetterOrd();
				if (delta > 0){
					int j = in.getNumOrd() + 1;
					for (int i = in.getLetterOrd()+1; i < out.getLetterOrd(); i++){
						if (getCell(i,j) != (null)){
							return false;
						}
						j++;
					}
					return true;
				}
				if (delta < 0){
					int j = in.getNumOrd() - 1;
					for (int i = in.getLetterOrd() - 1; i > out.getLetterOrd(); i--){
						if (getCell(i,j) != (null)){
							return false;
						}
						j--;
					}
					return true;
				}
			}
			//Проверяем, а не конь ли наша фигура
			if (getCell(in) instanceof Knight){
				return true;
			}
			return true;
		}
		return false;
	}


}
