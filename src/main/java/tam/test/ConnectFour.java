package tam.test;

public class ConnectFour {

    public static void main(String[] args) {
        Board gameBoard = new Board();
        Player redPlayer = new Player("Player1 [RED]", "R");
        Player greenPlayer = new Player("Player1 [GREEN]", "G");

        boolean continued = true;
        int noOfMoves = 0;
        gameBoard.draw();
        while (continued) {
            if (noOfMoves % 2 == 0) {
                redPlayer.move(gameBoard);
            } else {
                greenPlayer.move(gameBoard);
            }
            noOfMoves++;
            gameBoard.draw();
            if (gameBoard.checkWinner() != null) {
                foundWinner(gameBoard, redPlayer, greenPlayer);
                continued = false;
            }
            if (gameBoard.isDrawGame(noOfMoves)) {
                System.out.println("Draw game!");
                continued = false;
            }
        }
    }

    private static void foundWinner(Board gameBoard, Player redPlayer, Player greenPlayer) {
        if (redPlayer.getDisc().equals(gameBoard.checkWinner())) {
            printWinner(redPlayer);
        } else if (greenPlayer.getDisc().equals(gameBoard.checkWinner())) {
            printWinner(greenPlayer);
        }
    }

    private static void printWinner(Player redPlayer) {
        System.out.printf("%s won.%n", redPlayer.getName());
    }
}