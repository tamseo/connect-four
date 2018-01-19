import org.junit.Assert;
import org.junit.Test;
import tam.test.Board;

public class BoardTest {

    @Test
    public void horizontallyConnected() throws Exception {

        Board testBoard = new Board();
        String[][] boardMatrix = testBoard.getBoardMatrix();

        for (int i = 7; i < 15; i++) {
            if (Board.EMPTY_CELL.equals(boardMatrix[5][i])) {
                boardMatrix[5][i] = "G";
            }
        }
        testBoard.draw();
        Assert.assertEquals("G", testBoard.checkWinner());
    }

    @Test
    public void verticallyConnected() throws Exception {

        Board testBoard = new Board();
        String[][] boardMatrix = testBoard.getBoardMatrix();

        for (int i = 0; i < 4; i++) {
            if (Board.EMPTY_CELL.equals(boardMatrix[i][1])) {
                boardMatrix[i][1] = "R";
            }
        }
        Assert.assertEquals("R", testBoard.checkWinner());
    }

    @Test
    public void leftUpRightDownConnected() throws Exception {

        Board testBoard = new Board();
        String[][] boardMatrix = testBoard.getBoardMatrix();

        for (int i = 0; i < 4; i++) {
            if (Board.EMPTY_CELL.equals(boardMatrix[i][2 * i + 1])) {
                boardMatrix[i][2 * i + 1] = "R";
            }
        }
        Assert.assertEquals("R", testBoard.checkWinner());
    }

    @Test
    public void rightUpLeftDownConnected() throws Exception {

        Board testBoard = new Board();
        String[][] boardMatrix = testBoard.getBoardMatrix();

        for (int i = 0; i < 4; i++) {
            if (Board.EMPTY_CELL.equals(boardMatrix[i][9 - 2 * i])) {
                boardMatrix[i][9 - 2 * i] = "G";
            }
        }
        Assert.assertEquals("G", testBoard.checkWinner());
    }


}
