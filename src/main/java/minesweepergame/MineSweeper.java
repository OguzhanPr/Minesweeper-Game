package minesweepergame;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber; //
    int colNumber;
    int size;
    int success=0;
    int [][] map;
    int [][] board; //user playing board
    boolean game = true; //

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    //constructor
    public MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new int[rowNumber][colNumber]; //Object uretildiginde otomatik olarak olusacak
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber*colNumber;
    }

    public void run(){
        int row,col,success=0;
        prepareGame();
        print(map);
        System.out.println("The game begins");
        while(true){
            print(board);
            System.out.println("Enter the row numbers : "); //
            row=scan.nextInt();
            System.out.println("Enter the column numbers : ");
            col=scan.nextInt();
            if(row<0 || row>= rowNumber){ //
                System.out.println("Invalid coordinate");
                continue;
            }if(col<0 || col>= colNumber){ //0'dan buyukrcolNumber dan kucuk sayi araligi
                System.out.println("Invalid coordinate");
                continue;
            }if(map[row][col] != -1 ){  //Ther is no m ine
                checkMine(row,col);    //I'll check the mine around
                success++;  //+1 if there is no mine
                if(success == (size - (size/4))){
                    System.out.println("You Won");
                    return;
                }
            }else{
                //game =false;
                System.out.println("Game Over!");
                System.exit(0);
            }
            //break;
        }
    }

    //This method will check how many mines are around it without mines
    public void checkMine(int r, int c){
        if(map[r][c]==0){  //yani mayin yoksa islemi yapsin
            if( (c<colNumber-1) && (map[r][c+1] == -1)){  //saga
                board[r][c]++;
            }
            if( (r<rowNumber-1) && (map[r+1][c] == -1)){  //asagi
                board[r][c]++;
            }
            if( (r>0) && (map[r-1][c] == -1)){  //yukari
                board[r][c]++;
            }
            if( (c>0) && (map[r][c-1] == -1)){  //sola
                board[r][c]++;
            }
            if(board[r][c]==0){
               board[r][c]=-2;
            }
        }
    }

    //prepareGame //Oyunu hazirla //rastgele mayinlari yerlestirmek icin
    public void prepareGame(){

        int randRow;
        int randCol;
        int counter=0;
        while (counter != (size/4)) {       //(size/4) ==>add on the board 1/4 mine
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);

            if(map[randRow][randCol] != -1 ){      //first==> row
                                                   //-1 is mine
                map[randRow][randCol] =-1;         //add mine with -1 if there is no mine around
                counter++;
            }
        }
    }
    //this method has a print feature
    public void print(int[][] arr ){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                if(arr[i][j] >= 0){
                    System.out.print(" "); //
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
