package game;

public class Coord {

	private char letter;

	private int num;

	public Coord(char letter, int num) {
        this.letter = Character.toLowerCase(letter);
        this.num = num;
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

    public int getNumOrd() {
        return num - 1;
    }
}

// TODO создать 4 геттера + перевод координат в нужном.