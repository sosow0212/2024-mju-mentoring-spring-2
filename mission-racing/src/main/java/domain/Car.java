package domain;

public class Car {

    private static final int INITIAL_NUMBER = 0;
    private static final int CAR_MOVE_BOUNDARY = 4;

    public int moveCount = INITIAL_NUMBER;
    private final String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public void moveCar(CreateRandomNumber createRandomNumber) {
        if (createRandomNumber.generateRandomNumber() >= CAR_MOVE_BOUNDARY) {
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getCarName() {
        return carName;
    }
}
