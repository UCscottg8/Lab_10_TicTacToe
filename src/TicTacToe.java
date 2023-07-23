import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        clearBoard();
        String currentPlayer = "X";

        while (true) {
            display();

            int row;
            int col;
            do {
                row = SafeInput.getRangedInt(scanner, "Enter the row (1-3) for " + currentPlayer + "'s move", 1, 3) - 1;
                col = SafeInput.getRangedInt(scanner, "Enter the column (1-3) for " + currentPlayer + "'s move", 1, 3) - 1;
            } while (!isValidMove(row, col));

            board[row][col] = currentPlayer;

            if (isWin(currentPlayer)) {
                display();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (isTie()) {
                display();
                System.out.println("It's a tie!");
                break;
            }

            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        }
    }
    private static void clearBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                board[i][j] = " ";
            }
        }
    }

    private static void display() {
        for (int i = 0; i < ROW; i++) {
            System.out.println("-------------");
            for (int j = 0; j < COL; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    private static boolean isValidMove(int row, int col) {
        return " ".equals(board[row][col]);
    }

    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagonalWin(player);
    }

    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROW; i++) {
            if (player.equals(board[i][0]) && player.equals(board[i][1]) && player.equals(board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isColWin(String player) {
        for (int i = 0; i < COL; i++) {
            if (player.equals(board[0][i]) && player.equals(board[1][i]) && player.equals(board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(String player) {
        boolean diagonal1 = player.equals(board[0][0]) && player.equals(board[1][1]) && player.equals(board[2][2]);
        boolean diagonal2 = player.equals(board[0][2]) && player.equals(board[1][1]) && player.equals(board[2][0]);
        return diagonal1 || diagonal2;
    }

    private static boolean isTie() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (" ".equals(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}




