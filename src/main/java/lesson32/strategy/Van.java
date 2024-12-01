package lesson32.strategy;

public class Van extends CarBasic{

    public Van(String brand, String color, DriveStrategy driveStrategy) {
        super(brand, color, driveStrategy);
    }

}
