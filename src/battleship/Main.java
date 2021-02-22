package battleship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    // Create new GameField
    static GameField gameField = new GameField();
    static GameField gameField2 = new GameField();
    static Scanner scanner = new Scanner(System.in);
    static int shipSankCountP1 = 0;
    static int shipSankCountP2 = 0;
    static int playerNumber;
    static boolean playerWon = false;

    public static void main(String[] args) {
        boolean finished = false;
        String startInput = "";
        String endInput = "";


        // Create 10 X 10 fieldP1 for your game fieldP1
        char[][] fieldP1 = new char[10][10];

        // Initialize empty fieldP1
        for (char[] chars : fieldP1) {
            Arrays.fill(chars, '~');
        }

        // Created fieldP1 that does not show where the ships are at
        char[][] hiddenFieldP1 = new char[10][10];

        // Initialize hidden fieldP1
        for (char[] chars : hiddenFieldP1) {
            Arrays.fill(chars, '~');
        }



        // Create 10 X 10 fieldP2 for your game fieldP1
        char[][] fieldP2 = new char[10][10];

        // Initialize empty fieldP2
        for (char[] chars : fieldP2) {
            Arrays.fill(chars, '~');
        }

        // Created fieldP2 that does not show where the ships are at
        char[][] hiddenFieldP2 = new char[10][10];

        // Initialize hidden fieldP2
        for (char[] chars : hiddenFieldP2) {
            Arrays.fill(chars, '~');
        }


        // -------------Player 1 -----------------
        System.out.println("Player 1" + ", place your ships on the game field");

        // Print empty battle fieldP1
        GameUtility.printBattleField(fieldP1);

        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Aircraft carrier (5 cells):");
        getShipPlacement(gameField, GameField.ShipName.AIRCRAFT_CARRIER, fieldP1, startInput, endInput);

        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        getShipPlacement(gameField, GameField.ShipName.BATTLESHIP, fieldP1, startInput, endInput);


        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        getShipPlacement(gameField, GameField.ShipName.SUBMARINE, fieldP1, startInput, endInput);

        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        getShipPlacement(gameField, GameField.ShipName.CRUISER, fieldP1, startInput, endInput);

        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        getShipPlacement(gameField, GameField.ShipName.DESTROYER, fieldP1, startInput, endInput);
        // -----------End Player 1------------------
        System.out.println("Press enter and pass the move to another player");
        pressAnyKeyToContinue();

//        testGetShipPlacement(gameField, GameField.ShipName.AIRCRAFT_CARRIER, fieldP1, "F3", "F7");
//        testGetShipPlacement(gameField, GameField.ShipName.BATTLESHIP, fieldP1, "A1", "D1");
//        testGetShipPlacement(gameField, GameField.ShipName.SUBMARINE, fieldP1, "J10", "J8");
//        testGetShipPlacement(gameField, GameField.ShipName.CRUISER, fieldP1, "B9", "D9");
//        testGetShipPlacement(gameField, GameField.ShipName.DESTROYER, fieldP1, "I2", "J2");




        // -----------Player 2 -----------------
        System.out.println("Player 2" + ", place your ships to the game field");

        // Print empty battle fieldP1
        GameUtility.printBattleField(fieldP2);

        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Aircraft carrier (5 cells):");
        getShipPlacement(gameField2, GameField.ShipName.AIRCRAFT_CARRIER, fieldP2, startInput, endInput);

        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        getShipPlacement(gameField2, GameField.ShipName.BATTLESHIP, fieldP2, startInput, endInput);


        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        getShipPlacement(gameField2, GameField.ShipName.SUBMARINE, fieldP2, startInput, endInput);

        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        getShipPlacement(gameField2, GameField.ShipName.CRUISER, fieldP2, startInput, endInput);

        // Get Aircraft carrier placement and put in battlefield
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        getShipPlacement(gameField2, GameField.ShipName.DESTROYER, fieldP2, startInput, endInput);
        // ---------------End Player 2--------------
        System.out.println("Press enter and pass the move to another player");
        pressAnyKeyToContinue();

//        testGetShipPlacement(gameField2, GameField.ShipName.AIRCRAFT_CARRIER, fieldP2, "H2", "H6");
//        testGetShipPlacement(gameField2, GameField.ShipName.BATTLESHIP, fieldP2, "F3", "F6");
//        testGetShipPlacement(gameField2, GameField.ShipName.SUBMARINE, fieldP2, "H8", "F8");
//        testGetShipPlacement(gameField2, GameField.ShipName.CRUISER, fieldP2, "D4", "D6");
//        testGetShipPlacement(gameField2, GameField.ShipName.DESTROYER, fieldP2, "C8", "D8");


        while (!playerWon) {
            // start game

            if(shipSankCountP1 < 5  && shipSankCountP2 < 5) {
                GameUtility.printBattleField(hiddenFieldP1);
                System.out.println("---------------------");
                GameUtility.printBattleField(fieldP1);
                System.out.println("Player 1, it's your turn:");
                playerNumber = 1;
                takeAShot(fieldP1, hiddenFieldP1, fieldP2, hiddenFieldP2, playerNumber);
            } else {
                playerWon = true;
            }

            if(shipSankCountP1 < 5 && shipSankCountP2 < 5) {
                System.out.println("Press enter and pass the move to another player");
                pressAnyKeyToContinue();

                GameUtility.printBattleField(hiddenFieldP2);
                System.out.println("---------------------");
                GameUtility.printBattleField(fieldP2);
                System.out.println("Player 2, it's your turn:");
                playerNumber = 2;
                takeAShot(fieldP1, hiddenFieldP1, fieldP2, hiddenFieldP2, playerNumber);

                if(shipSankCountP1 < 5 && shipSankCountP2 <5) {
                    System.out.println("Press enter and pass the move to another player");
                    pressAnyKeyToContinue();
                } else {
                    playerWon = true;
                }
            } else {
                playerWon = true;
            }
        }

        System.out.println("You sank the last ship. You won. Congratulations!");

    }

    public static void takeAShot(char[][] fieldP1, char[][] hiddenFieldP1, char[][] fieldP2, char[][] hiddenFieldP2, int playerNumber) {

        /*
        String input = scanner.next();
        Position position = GameUtility.parsePosition(input);
        int letter = position.getLetter();
        int number = position.getNumber();

         */
        char[][] field;
        char[][] hiddenField;
        if (playerNumber == 1) {
            field = fieldP2;
            hiddenField = hiddenFieldP1;
        } else {
            field = fieldP1;
            hiddenField = hiddenFieldP2;
        }


        try {

            String input = scanner.next();
            char hashMapLetter = input.charAt(0);
            Position position = GameUtility.parsePosition(input);
            int letter = position.getLetter();
            int number = position.getNumber();

            /*
            if (number + 1 > 11) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                takeAShot(field, hiddenField);
            }

             */



            // Reduce coordinate number by 1 for array processing
            number -= 1;


            if (field[letter][number] == 'O' || field[letter][number] == 'X' || field[letter][number] == 'M' ) {


                if (gameField.takeAShot(hashMapLetter, number) && field[letter][number] == 'O') {
                    if (playerNumber == 1) {
                        shipSankCountP1 +=1;
                        if (shipSankCountP1 < 5) {
                            System.out.println("You sank a ship!");
                        }

                    } else {
                        shipSankCountP2 += 1;
                        if (shipSankCountP2 < 5) {
                            System.out.println("You sank a ship!");
                        }
                    }



                } else {
                    System.out.println("You hit a ship!");
                }

                if(playerNumber == 1) {
                    hiddenFieldP1[letter][number] = 'X';
                    fieldP2[letter][number] = 'X';
                } else {
                    hiddenFieldP2[letter][number] = 'X';
                    fieldP1[letter][number] = 'X';
                }
                //GameUtility.printBattleField(hiddenField);
                //GameUtility.printBattleField(hiddenField);

            } else if (field[letter][number] == '~') {
                if(playerNumber == 1) {
                    hiddenFieldP1[letter][number] = 'M';
                    fieldP2[letter][number] = 'M';
                } else {
                    hiddenFieldP2[letter][number] = 'M';
                    fieldP1[letter][number] = 'M';
                }

                //GameUtility.printBattleField(hiddenField);
                System.out.println("You missed!");
                //GameUtility.printBattleField(hiddenField);


            } else {
                System.out.println("Error! Your entered the wrong coordinates! Try again:");
                takeAShot(fieldP1, hiddenFieldP1, fieldP2, hiddenFieldP2, playerNumber);

            }

        } catch (Exception e) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            takeAShot(fieldP1, hiddenFieldP1, fieldP2, hiddenFieldP2, playerNumber);

        }

    }


    public static void getShipPlacement(GameField gameField, GameField.ShipName shipName, char[][] field, String startInput, String endInput) {

        boolean correctSize = false;

        // While loop to get input and verify input is correct
        while (!correctSize) {
            // Get coordinates of ships to be placed
            startInput = scanner.next();
            endInput = scanner.next();

            // Create new shipPosition per input
            ShipPosition shipPosition = new ShipPosition(startInput, endInput);

            // if branch to verify if new ship is to close to another one, if it is diagonal, or if it is the correct length
            if (!gameField.setPosition(shipName, shipPosition)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            } else if (GameUtility.isDiagonal(shipPosition)) {
                System.out.println("Error! Wrong ship location! Try again:");
            } else if (!GameUtility.isCorrectLength(shipName, shipPosition)) {
                String nameOfShipToPrint = shipName.toString().toLowerCase();
                nameOfShipToPrint = nameOfShipToPrint.substring(0, 1).toUpperCase() + nameOfShipToPrint.substring(1).toLowerCase();
                System.out.println("Error! Wrong length of " + nameOfShipToPrint + "! Try again:");
            } else {
                correctSize = true;
                HashMap<String, Boolean> map = shipPosition.addShipToArray(shipPosition, field);
                gameField.setHitMap(shipName, map);

                // Print battle field with new ship placement
                shipPosition.toString(field);
            }
        }
    }

    public static void testGetShipPlacement(GameField gameField, GameField.ShipName shipName, char[][] field, String startInput, String endInput) {
        ShipPosition shipPosition = new ShipPosition(startInput, endInput);
        HashMap<String, Boolean> map = shipPosition.addShipToArray(shipPosition, field);
        gameField.setHitMap(shipName, map);

        // Print battle field with new ship placement
        shipPosition.toString(field);
    }

    private static void pressAnyKeyToContinue()
    {
        //System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}
