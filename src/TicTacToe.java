
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize the board with spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        char currentPlayer = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            printBoard();
            makeMove(currentPlayer);
            gameOver = checkWin(currentPlayer);
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        printBoard();
        System.out.println("Game over! " + ((currentPlayer == 'X') ? 'O' : 'X') + " is the winner!");
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public static void makeMove(char player) {
        int row;
        int col;
        do {
            row = SafeInput.getRangedInt(scanner, "Enter the row (1-3) for " + player + "'s move", 1, 3) - 1;
            col = SafeInput.getRangedInt(scanner, "Enter the column (1-3) for " + player + "'s move", 1, 3) - 1;
        } while (board[row][col] != ' ');

        board[row][col] = player;
    }

    public static boolean checkWin(char player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}



