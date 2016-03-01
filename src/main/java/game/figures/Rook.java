package game.figures;

public class Rook extends Figure {

    public Rook(boolean color) {
        this.color = color;
        this.type = "rook";

        createTable();
        killTable = moveTable;
    }

    private void createTable() {
        moveTable = new boolean[64][64];
        for (int i =0; i <64; i++){
            int nk = (i+8)/8;
            for (int j = 8*nk-8; j < 8*nk ; j++){
                if (i!=j)
                    moveTable[i][j]=true;
            }

            for (int j1 = 0; j1 < 64; j1++){
                if ((j1-i)%8 == 0 &&i!=j1)
                    moveTable[i][j1]=true;
            }
        }
    }
}
