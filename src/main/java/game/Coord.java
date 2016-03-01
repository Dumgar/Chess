package game;

import game.Exeptions.InputDataException;

public class Coord {

	private char letter;

	private int num;

	public Coord(char letter, int num) {
        this.letter = Character.toLowerCase(letter);
        this.num = num;
    }

    public Coord(int i, int j){

    }

	public char getLetter() {
		return letter;
	}

	public int getNum() {
		return num;
	}

    public int getLetterOrd() {
        switch (letter) {
            case 'a': return 0;
            case 'b': return 1;
            case 'c': return 2;
            case 'd': return 3;
            case 'e': return 4;
            case 'f': return 5;
            case 'g': return 6;
            case 'h': return 7;
            default: return 0;
        }
    }

    public char getLetterByOrd(int letterNum) throws InputDataException{
        if (letterNum >= 0 && letterNum <= 7){
            switch (letterNum) {
                case 0: return 'a';
                case 1: return 'b';
                case 2: return 'c';
                case 3: return 'd';
                case 4: return 'e';
                case 5: return 'f';
                case 6: return 'g';
                case 7: return 'h';
            }
        }
        throw new InputDataException("Неверный входной параметр в методе " + this.getClass().getName());
    }

    public int getNumOrd() {
        return num - 1;
    }
}

// TODO создать 4 геттера + перевод координат в нужном.