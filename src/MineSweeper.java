
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class MineSweeper {
    Scanner input = new Scanner(System.in);
    int row, rowMax;
    int col, colMax;
    int mineNumber;
    String[][] mineTable;
    String[][] gameTable;
    int count;
    boolean isCheck = true;

    public MineSweeper(int row, int col) {
        //values are taken from here
        this.rowMax = row;
        this.colMax = col;
        this.mineNumber = ((row * col) / 4);

        this.mineTable = new String[col][row];
        this.gameTable = new String[col][row];

    }

    public void setupTable() {
        //MineTable created

        for (int i = 0; i < this.rowMax; i++) {
            for (int j = 0; j < this.colMax; j++) {

                gameTable[i][j] = "-";
                mineTable[i][j] = "-";
                System.out.print(gameTable[i][j] + " ");

            }
            System.out.println();
        }
        for (int i = 0; i < mineNumber; i++){
            int randRow = (int) (Math.random()*this.rowMax);
            int randCol = (int) (Math.random()*this.colMax);
            if(mineTable[randRow][randCol].equals("*")){
                i--;
            }
            mineTable[randRow][randCol]= "*";

        }

    }


    public void playerTurn() {
        isCheck = false;
        System.out.println("===================");
        System.out.println("Satır Giriniz : ");
        row = input.nextInt();
        System.out.println("Sütun Giriniz : ");
        col = input.nextInt();

        while (!isCheck) {
            if (0 <= row && 0 <= col && row < this.rowMax && col < this.colMax) {
                isCheck = true;
            } else {
                System.out.println("Harita dışında bir nokta seçtiniz! Tekrar ilgili değerleri giriniz:");
                System.out.println("Satır Giriniz : ");
                row = input.nextInt();
                System.out.println("Sütun Giriniz : ");
                col = input.nextInt();

            }
        }
    }

    public void mineCheck() {

        for (int i = (row - 1); i <= (row + 1); i++) {
            for (int j = (col - 1); j <= (col + 1); j++) {

                if ((i < 0 || j < 0 || i >= this.rowMax || j >= this.colMax)) {

                    continue;

                } else {
                    if (mineTable[i][j].equals("*")) {

                        mineNumber++;

                    }
                }
            }
        }
        mineTable[row][col] = String.valueOf(mineNumber);
        gameTable[row][col] = String.valueOf(mineNumber);
        for (int i = 0; i < this.mineTable.length; i++) {
            for (int j = 0; j < this.mineTable[0].length; j++) {

                System.out.print(gameTable[i][j] + " ");

            }

            System.out.println();

        }
    }

    public void writeMineMap(){
        for(int i = 0; i < this.rowMax; i++){
         for (int j = 0; j < this.colMax; j++){

            System.out.print(mineTable[i][j] + " ");

            }

            System.out.println("");

         }
    }

    public boolean isWin(){
        for(int i = 0; i < this.rowMax; i++){
            for (int j = 0; j < this.colMax; j++){
                if (mineTable[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }


    void run() {
        setupTable();

        while(isCheck){
            playerTurn();

            if(mineTable[row][col].equals("*")){

                System.out.println("Game Over ! ");
                writeMineMap();
                isCheck = false;

            } else {
                mineCheck();
                if (isWin()){
                    System.out.println("Kazandınız! Mayınların yerleri : ");
                    writeMineMap();
                    isCheck = false;
                }
            }
        }
    }
}
