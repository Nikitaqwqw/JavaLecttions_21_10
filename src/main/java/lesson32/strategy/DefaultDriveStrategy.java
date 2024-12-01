package lesson32.strategy;

public class DefaultDriveStrategy implements DriveStrategy {

    @Override
    public void start() {
        System.out.println("Start as usual");
    }
}
