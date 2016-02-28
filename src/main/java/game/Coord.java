package game;

public class Coord {

	private CoordLetter letter;

	private CoordNum num;

	public Coord(CoordLetter letter, CoordNum num) {
        this.letter = letter;
        this.num = num;
    }

	public CoordLetter getLetter() {
		return letter;
	}

	public CoordNum getNum() {
		return num;
	}
}
