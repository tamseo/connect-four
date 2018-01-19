package tam.test;

import java.util.Scanner;

public class Player {

    private String name;
    private String disc;

    public Player(String name, String disc) {
        this.name = name;
        this.disc = disc;
    }

    /**
     * Player makes a move
     *
     * @param gameBoard
     */
    public void move(Board gameBoard) {

        String[][] boardMatrix = gameBoard.getBoardMatrix();
        int col = askColumn();

        //ask to choose again when column is filled up
        while (gameBoard.isColumnFull(col)) {
            System.out.println("Column is full, please choose another");
            col = askColumn();
        }

        for (int i = 5; i >= 0; i--) {
            if (boardMatrix[i][col] == " ") {
                boardMatrix[i][col] = disc;
                break;
            }
        }
    }

    //Ask for which column to move
    private int askColumn() {
        System.out.println(name + " - choose column (1–7): ");
        Scanner scan = new Scanner(System.in);
        int col = scan.nextInt();

        //Avoid input not in range 1-7
        while (col > Board.COL_NO || col < 1) {
            System.out.println("Please choose from 1-7");
            col = scan.nextInt();
        }

        return 2 * (col - 1) + 1;
    }

    public String getName() {
        return name;
    }

    public Player setName(String name) {
        this.name = name;
        return this;
    }

    public String getDisc() {
        return disc;
    }

    public Player setDisc(String disc) {
        this.disc = disc;
        return this;
    }
}
