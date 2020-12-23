package battleship;

public class Ship {
    public GameField.ShipName name;
    private int size;
    private ShipPosition position;

    public Ship (GameField.ShipName name, int size) {
        this.name = name;
        this.size = size;
    }

    public GameField.ShipName getName() {
        return name;
    }

    public void setName(GameField.ShipName name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ShipPosition getPosition() {
        return position;
    }

    public void setPosition(ShipPosition position) {
        this.position = position;
    }

}
