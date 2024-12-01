package lesson32.decorator;

public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 10.0;
    }
}
