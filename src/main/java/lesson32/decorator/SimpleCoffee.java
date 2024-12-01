package lesson32.decorator;

public class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Simple cofee";
    }

    @Override
    public double getCost() {
        return 50.0;
    }
}
