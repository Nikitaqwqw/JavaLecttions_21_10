package lesson32;

import lesson32.factory.Coffee;
import lesson32.factory.CoffeeShop;
import lesson32.factory.SimpleCoffeeFactory;
import lesson32.factory.CoffeeType;


public class Patterns {

    //(Creational Patterns) - породжуючі паттерни
    // (Behavioral Patterns) - поведінкові паттерни

    public static void main(String[] args) {

    }

}

//Factory
//        CoffeeShop coffeeShop = new CoffeeShop(new SimpleCoffeeFactory());
//        CoffeeShop coffeeShop2 = new CoffeeShop(new SimpleCoffeeFactory());
//        Coffee latte = coffeeShop.orderCoffee(CoffeeType.LATTE);

//Decorator
//        SimpleCoffee simpleCoffee = new SimpleCoffee();
//        System.out.println(simpleCoffee.getDescription() + " -> Cost: " + simpleCoffee.getCost());
//
//        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
//        System.out.println(milkCoffee.getDescription() + " -> Cost: " + milkCoffee.getCost());
//
//        Coffee sugarCoffee = new SugarDecorator(milkCoffee);
//        System.out.println(sugarCoffee.getDescription() + " -> Cost: " + sugarCoffee.getCost());
//
//        Coffee chocolateCoffee = new ChocolateDecorator(sugarCoffee);
//        System.out.println(chocolateCoffee.getDescription() + " -> Cost: " + chocolateCoffee.getCost() + " гривні");
//
//        Coffee coffee = new MilkDecorator(new SimpleCoffee());
//        System.out.println(coffee.getDescription() + " -> Cost: " + coffee.getCost() + " гривні");
//
//
//        SimpleCoffeeWithoutDecorator simpleCoffeeWithoutDecorator =
//                new SimpleCoffeeWithoutDecorator(true,true,true);
//        System.out.println(simpleCoffeeWithoutDecorator.getDescription() + " -> Cost: " + simpleCoffeeWithoutDecorator.getCost() + " гривні");


//Observer
//    PhoneSubscriber phoneSubscriber = new PhoneSubscriber();
//    TVSubscriber tvSubscriber = new TVSubscriber();
//
//    MeteoStationObservable meteoStationObservable = new MeteoStationObservable();
//        meteoStationObservable.addSubscriber(phoneSubscriber);
//                meteoStationObservable.addSubscriber(tvSubscriber);
//                meteoStationObservable.updateDegreeInfo("30 градусів");
//
//                meteoStationObservable.updateDegreeInfo("35 degree");
//                meteoStationObservable.deleteSubscriber(tvSubscriber);
//                meteoStationObservable.updateDegreeInfo("40 degree");

//Strategy
//    DefaultDriveStrategy defaultDriveStrategy = new DefaultDriveStrategy();
//    CabrioleteStrategy cabrioleteStrategy = new CabrioleteStrategy();
//    Sedan sedan = new Sedan("BMW","black", defaultDriveStrategy);
//    Van van = new Van("Mercedes","Yellow", defaultDriveStrategy);
//    Pickup pickup = new Pickup("Ford","White", defaultDriveStrategy);
//    Cabriolette cabriolette = new Cabriolette("Fiat","Red",cabrioleteStrategy);
//
//        sedan.drive();
//                van.drive();
//                pickup.drive();
//                cabriolette.drive();
//
//                cabriolette.changeDriveStrategy(defaultDriveStrategy);
//                cabriolette.drive();
//
//                cabriolette.changeDriveStrategy(() -> {
//                System.out.println("Some custom strategy of start");
//                });
//                cabriolette.drive();


//Builder
//      Car car = new Car.Builder()
//              .setBrand("BMW")
//              .setEngine("V8")
//              .setTransmission("Automatic")
//              .setColor("Yellow")
//              .build();
