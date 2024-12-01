package lesson32.strategy;

public class CabrioleteStrategy  implements DriveStrategy{

    @Override
    public void start() {
        System.out.println("Open roof first. Start after");
    }
}
