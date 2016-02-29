package game.figures;

public class King extends Figure {

    public King(boolean color) {
        this.color = color;
        this.type = "king";

        createTable();
    }

    private void createTable() {

        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
                if (Math.abs(j - i) == 1 && (i+j+1)%16!=0) {
                    moveTable[i][j] = true;
                }
                if ((j - i) == 7 && i%8!=0) {
                    moveTable[i][j] = true;
                }
                if ((i - j) == 7 && j%8!=0) {
                    moveTable[i][j] = true;
                }
                if (Math.abs(j - i) == 8) {
                    moveTable[i][j] = true;
                }
                if ((j - i) == 9 && (i+1)%8!=0) {
                    moveTable[i][j] = true;
                }
                if ((i - j) == 9 && (j+1)%8!=0) {
                    moveTable[i][j] = true;
                }
            }
        }
    }
}
