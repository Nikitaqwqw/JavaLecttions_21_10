package lesson32.decorator;

public class ChocolateDecorator extends CoffeeDecorator {

    public ChocolateDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " chocolate";
    }

    @Override
    public double getCost() {
        return super.getCost() + 12.0;
    }
}
