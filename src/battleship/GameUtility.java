package battleship;

import java.util.List;

public class GameUtility {

    public static Position parsePosition(String input) {
        int start;
        int end;

        // Convert letter to number for array processing
        start = convertLetterToNumber(input.charAt(0));
        end = input.length() > 2 ? 10 : Integer.parseInt("" + input.charAt(1));
        return new Position(start, end);
    }

    // Ship position 1 is already placed, position 2 is new ship
    public static boolean isAdjacent(ShipPosition position1, ShipPosition position2) {
        int tempStartLetter = position2.getStart().getLetter();
        int tempStartNumber = position2.getStart().getNumber();
        int tempEndLetter = position2.getEnd().getLetter();
        int tempEndNumber = position2.getEnd().getNumber();

        // B2 E2
        // A2 F2
        if (position2.getDirection() == ShipPosition.Direction.VERTICAL) {
            if (tempStartLetter >= 1) {
                if (
                    (position1.getStart().getLetter() == (tempStartLetter - 1) && position1.getStart().getNumber() == tempStartNumber)
                    || (position1.getEnd().getLetter() == (tempEndLetter + 1) && position1.getEnd().getNumber() == tempEndNumber)
                ) {
                    return true;
                }
            }
            // B2 E2   B2 E2
            // B1 E1   B3 E3
            for (int i = tempStartLetter; i <= tempEndLetter; i++) {
                if (position1.getStart().getLetter() == i) {
                    if (position1.getStart().getNumber() == (tempStartNumber - 1) || position1.getStart().getNumber() == (tempStartNumber + 1)) {
                        return true;
                    }
                }
                if (position1.getStart().getLetter() + 1 == i) {
                    if (position1.getStart().getNumber() == (tempStartNumber - 1) || position1.getStart().getNumber() == (tempStartNumber + 1)) {
                        return true;
                    }
                }
                if (position1.getStart().getLetter() + 2 == i) {
                    if (position1.getStart().getNumber() == (tempStartNumber - 1) || position1.getStart().getNumber() == (tempStartNumber + 1)) {
                        return true;
                    }
                }
            }
            // F3 F7
            // E6 D6
            for (int i = position1.getStart().getNumber(); i <= position1.getEnd().getNumber(); i++) {
                if ((tempStartLetter + 1 == position1.getStart().getLetter() && tempStartNumber ==  i) || (tempStartLetter -1 == position1.getStart().getLetter() && tempStartNumber == i)) {
                    return true;
                }
            }


            // else HORIZONTAL
        } else {
            // B2 B5
            // B1 B6


            // Changed second if statement first clause, was backwards, second one might be too
            if (tempStartNumber >= 1 && position1.getStart().getLetter() == tempStartLetter) {
                if (tempStartNumber == (position1.getStart().getNumber() - 1) || (position1.getEnd().getNumber() == (tempEndNumber + 1))
                ) {
                    return true;
                }
            }
            // B2 B5   B2 B5
            // A2 A5   C2 C5

            for (int i = tempStartNumber; i <= tempEndNumber; i++) {
                if (position1.getStart().getNumber() == i) {
                    if ((position1.getStart().getLetter() == tempStartLetter - 1) || (position1.getEnd().getLetter() == (tempEndLetter + 1))) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public static boolean isAnyAdjacent(List<ShipPosition> shipPositionList, ShipPosition shipPosition) {
        if (shipPositionList.isEmpty()) {
            return false;
        }

        for (ShipPosition position : shipPositionList) {
            if (isAdjacent(position, shipPosition)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDiagonal(ShipPosition position) {
        if (position.getStart().getLetter() != position.getEnd().getLetter() && position.getStart().getNumber() != position.getEnd().getNumber()) {
            return true;
        }
        return false;
    }

    public static boolean isCorrectLength(GameField.ShipName shipName, ShipPosition position) {
        int size;
        int correctSize;
        int startLetter = position.getStart().getLetter();
        int startNumber = position.getStart().getNumber();
        int endLetter = position.getEnd().getLetter();
        int endNumber = position.getEnd().getNumber();

        if (shipName == GameField.ShipName.AIRCRAFT_CARRIER) {
            correctSize = 5;
        } else if (shipName == GameField.ShipName.BATTLESHIP) {
            correctSize = 4;
        } else if (shipName == GameField.ShipName.SUBMARINE) {
            correctSize = 3;
        } else if (shipName == GameField.ShipName.CRUISER) {
            correctSize = 3;
        } else if (shipName == GameField.ShipName.DESTROYER) {
            correctSize = 2;
        } else {
            System.out.println("No ship named " + shipName);
            correctSize = 0;
        }

        // if branch to check length of ship is correct
        if (startLetter == endLetter && startNumber < endNumber) {
            size = endNumber + 1 - startNumber;
            return size == correctSize;
        } else if (startLetter == endLetter && startNumber > endNumber) {
            size = startNumber + 1 - endNumber;
            return size == correctSize;
        } else if (startLetter < endLetter) {
            size = endLetter + 1 - startLetter;
            return size == correctSize;
        } else if (startLetter > endLetter) {
            size = startLetter + 1 - endLetter;
            return size == correctSize;
        }

        return false;
    }

    public static int convertLetterToNumber(char coordinate) {

        switch (coordinate) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            case 'I':
                return 8;
            case 'J':
                return 9;
            default:
                throw new IllegalStateException("Unexpected value: " + coordinate);
        }
    }

    // Print empty battle field
    public static void printBattleField(char[][] field) {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < field.length; i++) {
            char letter = 'A';
            System.out.print((letter += i) + " ");
            for (int j = 0; j <field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}
