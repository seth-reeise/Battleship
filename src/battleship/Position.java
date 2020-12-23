package battleship;

public class Position {
    private int letter;
    private int number;

    public Position(int letter, int number) {
        this.setLetter(letter);
        this.setNumber(number);
    }

    public int getLetter() {
        return this.letter;
    }

    public void setLetter(int letter) {
        this.letter = letter;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
