package lesson32.factory;

import lesson32.decorator.SimpleCoffee;

public class CoffeeShop {

    private final CoffeeFactory coffeeFactory;

    public CoffeeShop(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee(CoffeeType coffeeType){
        Coffee coffee = coffeeFactory.createCoffee(coffeeType);
        coffee.makeCoffee();
        return coffee;
    }

}
