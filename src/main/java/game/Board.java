package game;

import game.Exeptions.MoveException;
import game.figures.*;

public class Board {
    private Figure[][] cells;


	Board(){
		cells = new Figure[8][8];
		Figure whitePawn = new Pawn(true);
		Figure blackPawn = new Pawn(false);
		Figure whiteBishop = new Bishop(true);
		Figure blackBishop = new Bishop(false);
		Figure whiteRook = new Rook(true);
		Figure blackRook = new Rook(false);
		Figure whiteKnight = new Knight(true);
		Figure blackKnight = new Knight(false);
		Figure whiteQueen = new Queen(true);
		Figure blackQueen = new Queen(false);
		Figure whiteKing = new King(true);
		Figure blackKing = new King(false);
		for (int i = 0; i < 8; i++){
			cells[i][1] = whitePawn;
		}
		for (int i = 0; i < 8; i++){
			cells[i][6] = blackPawn;
		}
		cells[0][0] = cells[7][0] = whiteRook;
		cells[0][7] = cells[7][7] = blackRook;
		cells[1][0] = cells[6][0] = whiteKnight;
		cells[1][7] = cells[6][7] = blackKnight;
		cells[2][0] = cells[5][0] = whiteBishop;
		cells[2][7] = cells[4][7] = blackBishop;
		cells[4][0] = whiteQueen;
		cells[4][7] = blackQueen;
		cells[5][0] = whiteKing;
		cells[5][7] = blackKing;
	}

    Board(Figure[][] currentCells){
        cells = currentCells;
    }





	//TODO Будет ли метод давать исключение?
	public void move(Coord in, Coord out) throws MoveException{
		if (!checkMove(in,out)){
            throw new MoveException("Данный ход не возможен, фигура "+ cells[in.getLetterOrd()][in.getNumOrd()].getType() + " не может туда ходить, или на пути другая фигура");
		}
		if (getCell(out) != null){
			if (!getCell(in).getKillTable(in, out)){
                throw new MoveException("Данный ход не возможен, фигура "+ cells[in.getLetterOrd()][in.getNumOrd()].getType() + " не может туда рубить");
			}
            if (getCell(in).getColor() == getCell(out).getColor()){
                throw new MoveException("Данный ход не возможен, фигура не может рубить фигуры своего цвета");
            }
		}
		cells[out.getLetterOrd()][out.getNumOrd()] = getCell(in);
		cells[in.getLetterOrd()][in.getNumOrd()] = null;
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

	private Coord findKing(boolean color) {
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if ((cells[i][j] instanceof King) && cells[i][j].getColor() == color){
					return new Coord(i,j);
				}
			}
		}
		return null;
	}


    //Проверить шах королю цвета color.
	public boolean checkCheck(boolean color){
        Coord king = findKing(color);
        for (int i = 0; i<8; i++){
            for (int j=0; j<8; j++){
                if ((cells[i][j] != null) && (cells[i][j].getKillTable(new Coord(i,j),king))){
                    return true;
                }
            }
        }
		return false;
	}

    //проверить мат королю цвета color
	public  boolean checkMate(boolean color) {
        Board nextTurnBoard;
        boolean result = false;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if ((cells[i][j] != null) && (cells[i][j].getColor() == color)){
                    Coord inCoord = new Coord(i,j);
                    for (int t=0; t<8; t++){
                        for (int k=0; k<8; k++){
                            Coord outCoord = new Coord(t,k);
                            if (cells[i][j].getMoveTable(inCoord,outCoord)){
                                nextTurnBoard = new Board(cells);
                                try {
                                    nextTurnBoard.move(inCoord,outCoord);
                                } catch (MoveException e) {
                                    System.out.println(e.getMessage());
                                    e.printStackTrace();
                                }
                                if (nextTurnBoard.checkCheck(color) == false){
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
	}


}
