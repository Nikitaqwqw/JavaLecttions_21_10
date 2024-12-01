package lesson32.strategy;


public class Pickup extends CarBasic{

    public Pickup(String brand, String color, DriveStrategy driveStrategy) {
        super(brand, color, driveStrategy);
    }

}
