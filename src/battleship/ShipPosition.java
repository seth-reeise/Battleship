package battleship;

public class ShipPosition {
    private Position start;
    private Position end;
    private Direction direction;

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

    public void addShipToArray(ShipPosition position, char[][] field) {

        int startLetter = position.getStart().getLetter();
        int startNumber = position.getStart().getNumber();
        int endLetter = position.getEnd().getLetter();
        int endNumber = position.getEnd().getNumber();

        if (position.getDirection() == Direction.HORIZONTAL) {
            // Ship is going right
             if (startNumber < endNumber) {
                 for (int i = startLetter; i < startLetter + 1; i++) {
                     for (int j = startNumber - 1; j < endNumber; j++) {
                         field[i][j] = 'O';
                     }
                 }

                 // Ship is going left
            } else {
                 for (int i = startLetter; i < startLetter + 1; i++) {
                     for (int j = startNumber - 1; j >= endNumber - 1; j--) {
                         field[i][j] = 'O';
                     }
                 }
             }
             // Direction is vertical
        } else {
            // Ship is going down
            if (startLetter < endLetter) {
                for (int i = startLetter; i < endLetter + 1; i++) {
                    for (int j = startNumber - 1; j < startNumber; j++) {
                        field[i][j] = 'O';
                    }
                }
                //Ship is going up
            } else {
                for (int i = startLetter; i >= endLetter; i--) {
                    for (int j = startNumber - 1; j < startNumber; j++) {
                        field[i][j] = 'O';
                    }
                }
            }
        }
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
