public class ConnectFour {
    private int [][] grid;
    private int lastColor = 0;
    private int rowCheck [];
    private int numberRound = 0;

    public ConnectFour() {
        this.grid = new int[6][7];
        this.rowCheck = new int [7];
    }

    public int setColorAt(int column, int color) {
         if (color!=1 && color!=2) return 1; //colore corretto
         if (lastColor==color) return 2; //turno esatto
         if (rowCheck[column]==6) return 3; //colonna piena
         if (column<0 || column>6) return 4; //fuori griglia

        this.grid[rowCheck[column]][column] = color;
        rowCheck[column]++;
        lastColor = color;
        numberRound++;
        return 0;
    }

    public int youWin() {
        for (int i=0; i<6; i++) {
            for (int j=0; j<4; j++) {
                int sum = grid[j][i] + grid[j+1][i] + grid[j+2][i] + grid[j+3][i];
                if (sum==4 || sum==20) return 0; //winner
            }
            for (int y=0; y<7; y++) {
                int sum1 = grid[i][y] + grid[i][y+1] + grid[i][y+2] + grid[i][y+3];
                if (sum1==4 || sum1==20) return 0; //winner
            }
        }
        return 1;
    }
}
