package game.figures;

public class Queen extends Figure {

    public Queen(boolean color) {
        this.color = color;
        this.type = "qeen";

        createTable();
    }

    private void createTable() {
        boolean[][] moveTable1 = new boolean[64][64];
        boolean[][] moveTable2 = new boolean[64][64];
        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
                if ((j - i) % 7 == 0 && i!=j) {
                    moveTable1[i][j] = true;
                }

                if ((j - i) % 9 == 0 && i!=j) {
                    moveTable1[i][j] = true;
                }
            }
        }

        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
                if ((j - i) % 7 == 0) {
                    int k = Math.abs(j-i)/7;
                    for (int l = 0; l < k; l++){
                        if((i-l)%8 == 0){
                            moveTable1[i][j]=false;
                        }
                    }

                }

                if ((j - i) % 9 == 0) {
                    int k = Math.abs(j-i)/9;
                    for (int l = 0; l < k; l++){
                        if((i+l+1)%8 == 0){
                            moveTable1[i][j]=false;
                        }
                    }
                }
            }
        }

        for (int i =0; i <64; i++){
            int nk = (i+8)/8;
            for (int j = 8*nk-8; j < 8*nk ; j++){
                if (i!=j)
                    moveTable2[i][j]=true;
            }

            for (int j1 = 0; j1 < 64; j1++){
                if ((j1-i)%8 == 0 &&i!=j1)
                    moveTable2[i][j1]=true;
            }
        }

        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
                moveTable[i][j] = moveTable1[i][j] || moveTable2[i][j];
            }
        }
    }
}
