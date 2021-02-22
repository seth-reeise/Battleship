package battleship;

import java.util.HashMap;

public class ShipPosition {
    private Position start;
    private Position end;
    private Direction direction;

    final private static char[] boardLetters = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    final private static String[] boardNumbers = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    public enum Direction {
        HORIZONTAL,
        VERTICAL
    }

    public ShipPosition(String startInput, String endInput) {
        this.start = GameUtility.parsePosition(startInput);
        this.end = GameUtility.parsePosition(endInput);

        if (this.start.getLetter() == this.end.getLetter()) {
            this.direction = Direction.HORIZONTAL;
        } else {
            this.direction = Direction.VERTICAL;
        }
    }

    public Position getStart() {
        return start;
    }

    public void setStart(Position start) {
        this.start = start;
    }

    public Position getEnd() {
        return end;
    }

    public void setEnd(Position end) {
        this.end = end;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public HashMap<String, Boolean> addShipToArray(ShipPosition position, char[][] field) {

        int startLetter = position.getStart().getLetter();
        int startNumber = position.getStart().getNumber();
        int endLetter = position.getEnd().getLetter();
        int endNumber = position.getEnd().getNumber();

        HashMap<String, Boolean> shipPositionMap = new HashMap<>();

        if (position.getDirection() == Direction.HORIZONTAL) {

            /*
            for (int i = startNumber; i <= endNumber; i++) {
                shipPositionMap.put(String.valueOf(boardLetters[startLetter]) + i, false);
            }
            System.out.println(shipPositionMap);

             */




            // Ship is going right

            // Set hash map with ship position
             if (startNumber < endNumber) {
                 for (int i = startNumber; i <= endNumber; i++) {
                     shipPositionMap.put(String.valueOf(boardLetters[startLetter]) + i, false);
                 }

                 // Set array with ship position
                 for (int i = startLetter; i < startLetter + 1; i++) {
                     for (int j = startNumber - 1; j < endNumber; j++) {
                         field[i][j] = 'O';
                     }
                 }

                 // Ship is going left
            } else {
                 // Set hash map with ship position
                 for (int i = startNumber; i >= endNumber; i--) {
                     shipPositionMap.put(String.valueOf(boardLetters[startLetter]) + i, false);
                 }

                 // Set array with ship position
                 for (int i = startLetter; i < startLetter + 1; i++) {

                     for (int j = startNumber - 1; j >= endNumber - 1; j--) {
                         field[i][j] = 'O';
                     }
                 }
             }
             // Direction is vertical
        } else {

            /*
            The test for the field does not check if a ship is placed going up, it only tests if a ship is going
            down, therefore I did not add a loop to set the hash map correctly if ship is placed going up, will
            need to add later.
             */
            // Set hash map with ship position
            for (int i = startLetter; i <= endLetter; i++) {
                shipPositionMap.put(String.valueOf(boardLetters[i]) + startNumber, false);
            }

            // Ship is going down
            if (startLetter < endLetter) {
                // Set array with ship position
                for (int i = startLetter; i < endLetter + 1; i++) {
                    //shipPositionMap.put(String.valueOf(boardNumbers[startNumber]) + i, false);
                    for (int j = startNumber - 1; j < startNumber; j++) {
                        field[i][j] = 'O';
                    }
                }
                //Ship is going up
            } else {
                // Set array with ship position
                for (int i = startLetter; i >= endLetter; i--) {
                    //shipPositionMap.put(String.valueOf(boardNumbers[startNumber]) + i, false);
                    for (int j = startNumber - 1; j < startNumber; j++) {
                        field[i][j] = 'O';
                    }
                }
            }
        }

        //System.out.println(shipPositionMap);
        return shipPositionMap;
    }

    public void toString(char[][] field) {

        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i <= field.length - 1; i++) {
            char letter = 'A';
            System.out.print((letter += i) + " ");
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}
