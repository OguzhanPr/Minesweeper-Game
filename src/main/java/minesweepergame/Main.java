package minesweepergame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the sizes you want to play (4x2 , 3x3) : ");

        System.out.println("Row");
        int row = scan.nextInt();
        System.out.println("Column"); //
        int column = scan.nextInt();

        MineSweeper ms = new MineSweeper(row, column); //object //nesnemi olusturdum
        ms.run();

    }

    static {
        System.out.println("Welcome to minesweeper game");
    }

}
