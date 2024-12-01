package lesson32.strategy;

public class Sedan extends  CarBasic {

    public Sedan(String brand, String color, DriveStrategy driveStrategy) {
        super(brand, color, driveStrategy);
    }

}
