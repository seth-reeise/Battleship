package battleship;

import java.util.ArrayList;
import java.util.List;

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

    public List<ShipPosition> getShipPositions() {
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
}
