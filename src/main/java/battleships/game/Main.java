package battleships.game;

//import battleships.game.ships.Carrier;

import battleships.game.grid.BattleshipGrid;

public class Main {
    public static void main(String[] args) {
        BattleshipGrid grid = new BattleshipGrid();

        // Placing ships on the grid
        grid.placeShip(0, 0, 5, 'H');  // Place Carrier horizontally (5 spaces)
        grid.placeShip(3, 2, 4, 'V');  // Place Battleship vertically (4 spaces)

        // Display the grid
        grid.displayGrid();

        // Firing at some positions
        System.out.println(grid.fireAt(0, 0));  // Hit!
        System.out.println(grid.fireAt(5, 5));  // Miss!

        // Display the grid again after attacks
        grid.displayGrid();
    }
}
