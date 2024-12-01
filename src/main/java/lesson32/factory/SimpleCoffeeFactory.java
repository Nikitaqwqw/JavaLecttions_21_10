package lesson32.factory;

interface CoffeeFactory {

    Coffee createCoffee(CoffeeType coffeeType);
}

public class SimpleCoffeeFactory implements CoffeeFactory {

    Coffee coffee = null;

    @Override
    public Coffee createCoffee(CoffeeType type) {
        switch (type) {
            case AMERICANO:
                coffee = new Americano();
                break;
            case LATTE:
                coffee = new Latte();
                break;
            case CAPPUCCINO:
                coffee = new Cappuccino();
                break;
            case ESPRESSO:
                coffee = new Espresso();
                break;
        }
        return coffee;
    }

}
