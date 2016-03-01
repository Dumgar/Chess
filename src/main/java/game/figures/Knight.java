package game.figures;

public class Knight extends Figure {

    public Knight(boolean color) {
        this.color = color;
        this.type = "knight";

        createTable();
        killTable = moveTable;
    }

    private void createTable() {
        moveTable = new boolean[64][64];
        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
                if ((j - i) == 6 && i%8 !=0 && (i-1)%8 !=0) {
                    moveTable[i][j] = true;
                }
                if ((i - j) == 6 && j%8 !=0 && (j-1)%8 !=0) {
                    moveTable[i][j] = true;
                }

                if ((j - i) == 10&& (i+2)%8 !=0 && (i+1)%8 !=0) {
                    moveTable[i][j] = true;
                }
                if ((i - j) == 10&& (j+2)%8 !=0 && (j+1)%8 !=0) {
                    moveTable[i][j] = true;
                }

                if ((j - i) == 15 && i%8!=0) {
                    moveTable[i][j] = true;
                }
                if ((i - j) == 15 && j%8!=0) {
                    moveTable[i][j] = true;
                }

                if ((j - i) == 17&& (i+1)%8!=0) {
                    moveTable[i][j] = true;
                }
                if ((i - j) == 17&& (j+1)%8!=0) {
                    moveTable[i][j] = true;
                }
            }
        }
    }
}
