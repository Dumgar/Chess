package game.figures;

public class Bishop extends Figure {

    public Bishop(boolean color) {
        this.color = color;
        this.type = "bishop";

        createTable();
        killTable = moveTable;
    }

    private void createTable() {
        moveTable = new boolean[64][64];
        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
                if ((j - i) % 7 == 0 && i!=j) {
                    moveTable[i][j] = true;
                }

                if ((j - i) % 9 == 0 && i!=j) {
                    moveTable[i][j] = true;
                }
            }
        }

        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
                if ((j - i) % 7 == 0) {
                    int k = Math.abs(j-i)/7;
                    for (int l = 0; l < k; l++){
                        if((i-l)%8 == 0){
                            moveTable[i][j]=false;
                        }
                    }

                }

                if ((j - i) % 9 == 0) {
                    int k = Math.abs(j-i)/9;
                    for (int l = 0; l < k; l++){
                        if((i+l+1)%8 == 0){
                            moveTable[i][j]=false;
                        }
                    }
                }
            }
        }
    }
}
