
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Connect 4!\nPlace 4 counters in a row (horizontally, vertically or diagonally to win).");

        System.out.print("Would you like to play a game? (Y/N) ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        while (answer.equalsIgnoreCase("Y")) {
            playGame();
            System.out.print("Would you like to play again? ");
            answer = scanner.nextLine();
        }

    }

    public static void printBoard(char[][] board) {
        System.out.println("");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j < board[i].length - 1) {
                    System.out.print(" " + board[i][j] + "  | ");
                } else {
                    System.out.print(" " + board[i][j]);
                }
            }
            System.out.println("\n---------------------------");
        }
        System.out.println(" 1  |  2  |  3  |  4  |  5");
        System.out.println("---------------------------\n");

    }

    public static void playGame() {
        char[][] board = {{' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' '}};

        int i = 0;
        while (i <= 20) {
            printBoard(board);

            if (i % 2 == 0) {
                playerTurn(board, 'X', 1);
                if (checkWin(board)) {
                    System.out.println("Congratulations Player 1, you won!");
                    break;
                }
            } else {
                playerTurn(board, 'O', 2);
                if (checkWin(board)) {
                    System.out.println("Congratulations Player 2, you won!");
                    break;
                }
            }
            if (i == 20) {
                System.out.println("It's a tie!");
            }
            i++;
        }
    }

    public static void playerTurn(char[][] board, char letter, int player) {

        System.out.print("Player " + player + " in which column would you like to place a counter? ");
        Scanner reader = new Scanner(System.in);
        int column = Integer.parseInt(reader.nextLine());
        boolean placed = false;
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][column - 1] == ' ') {
                board[i][column - 1] = letter;
                placed = true;
                break;
            }
        }
        if (!placed) {
            System.out.println("Column is full, please try again!");
            playerTurn(board, letter, player);
        }
    }

    public static boolean checkWin(char[][] board) {
        // Horizontal win conditions
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][2] == board[0][3] && (board[0][3] == 'X' || board[0][3] == 'O')) {
            return true;
        }
        if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] == board[1][3] && (board[1][3] == 'X' || board[1][3] == 'O')) {
            return true;
        }
        if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] == board[2][3] && (board[2][3] == 'X' || board[2][3] == 'O')) {
            return true;
        }
        if (board[3][0] == board[3][1] && board[3][1] == board[3][2] && board[3][2] == board[3][3] && (board[3][2] == 'X' || board[3][2] == 'O')) {
            return true;
        }
        if (board[0][3] == board[0][4] && board[0][1] == board[0][2] && board[0][2] == board[0][3] && (board[0][3] == 'X' || board[0][3] == 'O')) {
            return true;
        }
        if (board[1][3] == board[1][4] && board[1][1] == board[1][2] && board[1][2] == board[1][3] && (board[1][3] == 'X' || board[1][3] == 'O')) {
            return true;
        }
        if (board[2][3] == board[2][4] && board[2][1] == board[2][2] && board[2][2] == board[2][3] && (board[2][3] == 'X' || board[2][3] == 'O')) {
            return true;
        }
        if (board[3][3] == board[3][4] && board[3][1] == board[3][2] && board[3][2] == board[3][3] && (board[3][3] == 'X' || board[3][3] == 'O')) {
            return true;
        }

        // Vertical win condiitons
        if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] == board[3][0] && (board[3][0] == 'X' || board[3][0] == 'O')) {
            return true;
        }
        if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] == board[3][1] && (board[3][1] == 'X' || board[3][1] == 'O')) {
            return true;
        }
        if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] == board[3][2] && (board[3][2] == 'X' || board[3][2] == 'O')) {
            return true;
        }
        if (board[0][3] == board[1][3] && board[1][3] == board[2][3] && board[2][3] == board[3][3] && (board[2][3] == 'X' || board[2][3] == 'O')) {
            return true;
        }
        if (board[0][4] == board[1][4] && board[1][4] == board[2][4] && board[2][4] == board[3][4] && (board[3][4] == 'X' || board[3][4] == 'O')) {
            return true;
        }

        // Diagonal win conditions
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == board[3][3] && (board[3][3] == 'X' || board[3][3] == 'O')) {
            return true;
        }
        if (board[3][1] == board[2][2] && board[2][2] == board[1][3] && board[1][3] == board[0][4] && (board[0][4] == 'X' || board[0][4] == 'O')) {
            return true;
        }
        if (board[0][1] == board[1][2] && board[1][2] == board[2][3] && board[2][4] == board[3][4] && (board[3][4] == 'X' || board[3][4] == 'O')) {
            return true;
        }
        if (board[3][0] == board[2][1] && board[2][1] == board[1][2] && board[1][2] == board[0][3] && (board[0][3] == 'X' || board[0][3] == 'O')) {
            return true;
        }

        return false;
    }
}
