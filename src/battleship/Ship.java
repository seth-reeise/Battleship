package battleship;

import java.util.HashMap;
import java.util.Map;

public class Ship {
    public GameField.ShipName name;
    private int size;
    private ShipPosition position;
    boolean isSunk = false;
    HashMap<String, Boolean> shipHitMap = new HashMap<>();

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

    public boolean hasShipPosition(char letter, int number) {
        number += 1;
        String pos = Character.toString(letter) + Integer.toString(number);
        return shipHitMap.containsKey(pos);
    }

    public boolean isShipSunk() {
        return this.isSunk;
    }

    public void setHit(char letter, int number) {
        number += 1;
        String pos = Character.toString(letter) + Integer.toString(number);

        shipHitMap.put(pos, true);

        boolean sunk = true;

        for (Map.Entry<String, Boolean> entry : shipHitMap.entrySet()) {
            if (!entry.getValue()) {
                sunk = false;
                break;
            }
        }

        isSunk = sunk;

    }

    public void setShipMap(HashMap<String, Boolean> map) {
        shipHitMap = map;
    }
}
