package lesson32.strategy;

public abstract class CarBasic {
    private String brand;
    private String color;
    private DriveStrategy driveStrategy;

    public CarBasic(String brand, String color, DriveStrategy driveStrategy) {
        this.brand = brand;
        this.color = color;
        this.driveStrategy = driveStrategy;
    }

    //Звичайний автомобіль
    //Вантажівка
    //Мікроавтобус
    //Пікап
    //Кабріолет
    public void drive(){
        driveStrategy.start();
    }

    public void changeDriveStrategy(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public final void printBrandName(){
        System.out.println(brand);
    }

    public final void printCarColor(){
        System.out.println(color);
    }

    public void stop(){
        System.out.println("Stop");
    }

    public void openDoors(){
        System.out.println("Open 4 doors");
    }

    public void closeDoors(){
        System.out.println("Close doors");
    }
}










