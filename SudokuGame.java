import java.util.Scanner;

public class SudokuGame {

// Pre-filled Sudoku puzzle (0 = empty)
static int[][] board = {
    {5, 3, 0, 0, 7, 0, 0, 0, 0},
    {6, 0, 0, 1, 9, 5, 0, 0, 0},
    {0, 9, 8, 0, 0, 0, 0, 6, 0},
    {8, 0, 0, 0, 6, 0, 0, 0, 3},
    {4, 0, 0, 8, 0, 3, 0, 0, 1},
    {7, 0, 0, 0, 2, 0, 0, 0, 6},
    {0, 6, 0, 0, 0, 0, 2, 8, 0},
    {0, 0, 0, 4, 1, 9, 0, 0, 5},
    {0, 0, 0, 0, 8, 0, 0, 7, 9}
};

public static void displayBoard() {
    System.out.println("\nCurrent Sudoku Board:\n");
    
    for (int i = 0; i < 9; i++) {
        if (i % 3 == 0 && i != 0)
            System.out.println("------+-------+------");
        
        for (int j = 0; j < 9; j++) {
            if (j % 3 == 0 && j != 0)
                System.out.print("| ");
            System.out.print(board[i][j] == 0 ? ". " : board[i][j] + " ");
        }
        System.out.println();
    }
    System.out.println();
}

public static boolean isValid(int row, int col, int num) {
    // Check row
    for (int j = 0; j < 9; j++)
        if (board[row][j] == num)
            return false;

    // Check column
    for (int i = 0; i < 9; i++)
        if (board[i][col] == num)
            return false;

    // Check 3×3 box
    int r = row - row % 3;
    int c = col - col % 3;

    for (int i = r; i < r + 3; i++)
        for (int j = c; j < c + 3; j++)
            if (board[i][j] == num)
                return false;

    return true;
}

public static boolean isBoardComplete() {
    for (int i = 0; i < 9; i++)
        for (int j = 0; j < 9; j++)
            if (board[i][j] == 0)
                return false;
    return true;
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("🎮 Sudoku Game Started!");
    System.out.println("Enter row, col, number (0 0 0 to exit)");

    while (true) {
        displayBoard();

        System.out.print("Row (0-8): ");
        int row = sc.nextInt();

        System.out.print("Col (0-8): ");
        int col = sc.nextInt();

        System.out.print("Number (1-9): ");
        int num = sc.nextInt();

        // Exit
        if (row == 0 && col == 0 && num == 0) {
            System.out.println("Game Ended.");
            break;
        }

        if (board[row][col] != 0) {
            System.out.println("❌ Spot already filled!");
            continue;
        }

        if (isValid(row, col, num)) {
            board[row][col] = num;
            System.out.println("✔ Added!");
        } else {
            System.out.println("❌ Invalid move!");
        }

        if (isBoardComplete()) {
            displayBoard();
            System.out.println("🎉 Congratulations! You completed the Sudoku!");
            break;
        }
    }
    sc.close();
}
}
