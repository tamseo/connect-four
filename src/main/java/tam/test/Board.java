package tam.test;

public class Board {

    public static final String BOARD_BORDER = "|";
    public static final String EMPTY_CELL = " ";
    public static final int ROW_NO = 6;
    public static final int COL_NO = 7;

    private String[][] boardMatrix;

    public Board() {
        boardMatrix = new String[ROW_NO][COL_NO * 2 + 1];
        for (int i = 0; i < boardMatrix.length; i++) {
            for (int j = 0; j < boardMatrix[i].length; j++) {
                if (j % 2 == 0) boardMatrix[i][j] = BOARD_BORDER;
                else boardMatrix[i][j] = EMPTY_CELL;
            }
        }
    }

    /**
     * Draw the board with current board matrix
     */
    public void draw() {
        for (String[] aBoardMatrix : boardMatrix) {
            for (String anABoardMatrix : aBoardMatrix) {
                System.out.print(anABoardMatrix);
            }
            System.out.println();
        }
    }

    /**
     * Check the board to detect 4 connected items
     *
     * @return Winner's disc {@link Player}
     */
    public String checkWinner() {

        //check horizontal line
        for (int i = 0; i < Board.ROW_NO; i++) {
            for (int j = 0; j < Board.COL_NO; j += 2) {
                if ((!boardMatrix[i][j + 1].equals(Board.EMPTY_CELL))
                        && ((boardMatrix[i][j + 1].equals(boardMatrix[i][j + 3]))
                        && (boardMatrix[i][j + 3].equals(boardMatrix[i][j + 5]))
                        && (boardMatrix[i][j + 5].equals(boardMatrix[i][j + 7]))))
                    return boardMatrix[i][j + 1];
            }
        }
        //check vertical line
        for (int i = 1; i < Board.COL_NO * 2 + 1; i += 2) {
            for (int j = 0; j < Board.ROW_NO - 3; j++) {
                if ((!boardMatrix[j][i].equals(Board.EMPTY_CELL))
                        && ((boardMatrix[j][i].equals(boardMatrix[j + 1][i]))
                        && (boardMatrix[j + 1][i].equals(boardMatrix[j + 2][i]))
                        && (boardMatrix[j + 2][i].equals(boardMatrix[j + 3][i]))))
                    return boardMatrix[j][i];
            }
        }

        //left-up to right-down diagonal line
        for (int i = 0; i < Board.ROW_NO - 3; i++) {
            for (int j = 1; j <= Board.COL_NO; j += 2) {
                if ((!boardMatrix[i][j].equals(Board.EMPTY_CELL))
                        && ((boardMatrix[i][j].equals(boardMatrix[i + 1][j + 2]))
                        && (boardMatrix[i + 1][j + 2].equals(boardMatrix[i + 2][j + 4]))
                        && (boardMatrix[i + 2][j + 4].equals(boardMatrix[i + 3][j + 6]))))
                    return boardMatrix[i][j];
            }
        }

        //right-up to left-down diagonal line
        for (int i = 0; i < Board.ROW_NO - 3; i++) {
            for (int j = Board.COL_NO; j < Board.COL_NO * 2 + 1; j += 2) {
                if ((!boardMatrix[i][j].equals(Board.EMPTY_CELL))
                        && ((boardMatrix[i][j].equals(boardMatrix[i + 1][j - 2]))
                        && (boardMatrix[i + 1][j - 2].equals(boardMatrix[i + 2][j - 4]))
                        && (boardMatrix[i + 2][j - 4].equals(boardMatrix[i + 3][j - 6]))))
                    return boardMatrix[i][j];
            }
        }
        //No one win
        return null;
    }

    /**
     * If the number of moves is equal or greater than the total number of cells
     * then games is over and it was a draw game
     *
     * @param noOfMoves Number of moves
     * @return Is it a draw game or not
     */
    public boolean isDrawGame(int noOfMoves) {
        int cellNo = Board.COL_NO * Board.ROW_NO;
        return noOfMoves >= cellNo;
    }

    /**
     * Check if cell in the last row is not empty then the column is full and can't be appended
     *
     * @param colNo The column
     * @return The column is full or not
     */
    public boolean isColumnFull(int colNo) {
        return !EMPTY_CELL.equals(boardMatrix[0][colNo]);
    }

    public String[][] getBoardMatrix() {
        return boardMatrix;
    }
}
