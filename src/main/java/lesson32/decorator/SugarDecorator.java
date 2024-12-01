package lesson32.decorator;

public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) { // MilkDecorator
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " sugar";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}
