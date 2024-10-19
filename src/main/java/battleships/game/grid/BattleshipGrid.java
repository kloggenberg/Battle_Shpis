package battleships.game.grid;

public class BattleshipGrid {
    private char[][] grid;  // 2D array to represent the grid
    private static final int GRID_SIZE = 10;  // 10x10 grid

    // Constructor to initialize the grid
    public BattleshipGrid() {
        grid = new char[GRID_SIZE][GRID_SIZE];

        // Initialize all cells to '~' representing water (empty)
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                grid[row][col] = '~';
            }
        }
    }

    // Method to display the grid
    public void displayGrid() {
        System.out.println("  A B C D E F G H I J"); // Column headers
        for (int row = 0; row < GRID_SIZE; row++) {
            System.out.print((row + 1) + " "); // Row headers
            for (int col = 0; col < GRID_SIZE; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }

    // Method to place a ship on the grid
    public boolean placeShip(int row, int col, int size, char orientation) {
        if (orientation == 'H') {  // Horizontal
            if (col + size > GRID_SIZE) return false;  // Out of bounds check
            for (int i = 0; i < size; i++) {
                if (grid[row][col + i] != '~') return false;  // Collision check
            }
            for (int i = 0; i < size; i++) {
                grid[row][col + i] = 'S';  // Place the ship
            }
        } else if (orientation == 'V') {  // Vertical
            if (row + size > GRID_SIZE) return false;  // Out of bounds check
            for (int i = 0; i < size; i++) {
                if (grid[row + i][col] != '~') return false;  // Collision check
            }
            for (int i = 0; i < size; i++) {
                grid[row + i][col] = 'S';  // Place the ship
            }
        } else {
            return false;  // Invalid orientation
        }
        return true;
    }

    // Method to handle an attack (shot fired)
    public String fireAt(int row, int col) {
        if (grid[row][col] == 'S') {
            grid[row][col] = 'X';  // Mark hit
            return "Hit!";
        } else if (grid[row][col] == '~') {
            grid[row][col] = 'O';  // Mark miss
            return "Miss!";
        } else {
            return "Already fired here!";
        }
    }
}
