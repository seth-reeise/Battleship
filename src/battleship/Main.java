package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create 10 X 10 field for your game field
        char[][] field = new char[10][10];

        // Initialize empty field
        for (char[] chars : field) {
            Arrays.fill(chars, '~');
        }

        // Create new GameField
        GameField gameField = new GameField();

        // Print empty battle field
        GameUtility.printBattleField(field);


        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Aircraft carrier (5 cells):");
        getShipPlacement(scanner, gameField, GameField.ShipName.AIRCRAFT_CARRIER, field);

        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        getShipPlacement(scanner, gameField, GameField.ShipName.BATTLESHIP, field);

        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        getShipPlacement(scanner, gameField, GameField.ShipName.SUBMARINE, field);

        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        getShipPlacement(scanner, gameField, GameField.ShipName.CRUISER, field);

        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        getShipPlacement(scanner, gameField, GameField.ShipName.DESTROYER, field);
    }

    public static void getShipPlacement(Scanner scanner, GameField gameField, GameField.ShipName shipName, char[][] field) {

        boolean correctSize = false;

        // While loop to get input and verify input is correct
        while (!correctSize) {
            // Get coordinates of ships to be placed
            String startInput = scanner.next();
            String endInput = scanner.next();

            // Creat new shipPosition per input
            ShipPosition shipPosition = new ShipPosition(startInput, endInput);

            // if branch to verify if new ship is to close to another one, if it is diagonal, or if it is the correct length
            if (!gameField.setPosition(shipName, shipPosition)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            } else if (GameUtility.isDiagonal(shipPosition)) {
                System.out.println("Error! Wrong ship location! Try again:");
            } else if (!GameUtility.isCorrectLength(shipName, shipPosition)) {
                System.out.println("Error! Wrong length of ship! Try again:");
            } else {
                correctSize = true;
                shipPosition.addShipToArray(shipPosition, field);
                // Print battle field with new ship placement
                shipPosition.toString(field);

            }
        }
    }
}

