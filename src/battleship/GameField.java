package battleship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GameField {
    enum ShipName {
        AIRCRAFT_CARRIER,
        BATTLESHIP,
        SUBMARINE,
        CRUISER,
        DESTROYER
    }

    Ship aircraftCarrier = new Ship(ShipName.AIRCRAFT_CARRIER, 5);
    Ship battleship = new Ship(ShipName.BATTLESHIP, 4);
    Ship submarine = new Ship(ShipName.SUBMARINE, 3);
    Ship cruiser = new Ship(ShipName.CRUISER, 3);
    Ship destroyer = new Ship(ShipName.DESTROYER, 2);

    public boolean setPosition(ShipName name, ShipPosition position) {
        List<ShipPosition> shipPositionList = this.getShipPositions();
        if (GameUtility.isAnyAdjacent(shipPositionList, position)) {
            return false;
        }

        switch (name) {
            case AIRCRAFT_CARRIER:
                aircraftCarrier.setPosition(position);
                break;
            case BATTLESHIP:
                battleship.setPosition(position);
                break;
            case SUBMARINE:
                submarine.setPosition(position);
                break;
            case CRUISER:
                cruiser.setPosition(position);
                break;
            case DESTROYER:
                destroyer.setPosition(position);
                break;
        }
        return true;
    }

    public  List<ShipPosition> getShipPositions() {
        List<ShipPosition> shipPositionList = new ArrayList<>();

        if (aircraftCarrier.getPosition() != null) {
            shipPositionList.add(aircraftCarrier.getPosition());
        }

        if (battleship.getPosition() != null) {
            shipPositionList.add(battleship.getPosition());
        }

        if (submarine.getPosition() != null) {
            shipPositionList.add(submarine.getPosition());
        }

        if (cruiser.getPosition() != null) {
            shipPositionList.add(cruiser.getPosition());
        }

        if (destroyer.getPosition() != null) {
            shipPositionList.add(destroyer.getPosition());
        }

        return shipPositionList;
    }

    public boolean takeAShot(char letter, int number) {
        if (aircraftCarrier.hasShipPosition(letter, number)) {
            aircraftCarrier.setHit(letter, number);
            if (aircraftCarrier.isShipSunk()) {
                return true;
            }
        }

        if (battleship.hasShipPosition(letter, number)) {
            battleship.setHit(letter, number);
            if (battleship.isShipSunk()) {
                return true;
            }
        }

        if (submarine.hasShipPosition(letter, number)) {
            submarine.setHit(letter, number);
            if (submarine.isShipSunk()) {
                return true;
            }
        }

        if (cruiser.hasShipPosition(letter, number)) {
            cruiser.setHit(letter, number);
            if (cruiser.isShipSunk()) {
                return true;
            }
        }

        if (destroyer.hasShipPosition(letter, number)) {
            destroyer.setHit(letter, number);
            if (destroyer.isShipSunk()) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        if (aircraftCarrier.getPosition() != null) {
            stringBuilder.append("Aircraft Carrier\n" + aircraftCarrier.getPosition().toString());
        }

        if (battleship.getPosition() != null) {
            stringBuilder.append("Battleship\n" + battleship.getPosition().toString());
        }

        if (submarine.getPosition() != null) {
            stringBuilder.append("Submarine\n" + submarine.getPosition().toString());
        }

        if (cruiser.getPosition() != null) {
            stringBuilder.append("Cruiser\n" + cruiser.getPosition().toString());
        }

        if (destroyer.getPosition() != null) {
            stringBuilder.append("Destroyer\n" + destroyer.getPosition().toString());
        }
        return stringBuilder.toString();
    }

    public void setHitMap(ShipName name, HashMap<String, Boolean> map) {

        switch (name) {
            case AIRCRAFT_CARRIER:
                aircraftCarrier.setShipMap(map);
                break;
            case BATTLESHIP:
                battleship.setShipMap(map);
                break;
            case SUBMARINE:
                submarine.setShipMap(map);
                break;
            case CRUISER:
                cruiser.setShipMap(map);
                break;
            case DESTROYER:
                destroyer.setShipMap(map);
                break;
        }
    }
}
