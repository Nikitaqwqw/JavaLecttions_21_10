package lesson32.decorator;

public class SimpleCoffeeWithoutDecorator {

    private final boolean isMilkAdded;
    private final boolean isSugarAdded;
    private final boolean isChocolateAdded;
    private double baseCost = 50.0;

    public SimpleCoffeeWithoutDecorator(boolean isMilkAdded) {
        this.isMilkAdded = isMilkAdded;
        this.isSugarAdded = false;
        this.isChocolateAdded = false;
    }

    public SimpleCoffeeWithoutDecorator(boolean isMilkAdded, boolean isSugarAdded) {
        this.isMilkAdded = isMilkAdded;
        this.isSugarAdded = isSugarAdded;
        this.isChocolateAdded = false;
    }

    public SimpleCoffeeWithoutDecorator(boolean isMilkAdded, boolean isSugarAdded, boolean isChocolateAdded) {
        this.isMilkAdded = isMilkAdded;
        this.isSugarAdded = isSugarAdded;
        this.isChocolateAdded = isChocolateAdded;
    }

    public String getDescription(){
        StringBuilder stringBuilder = new StringBuilder("Simple coffee");
        if (isMilkAdded){
            stringBuilder.append(" with milk");
        }
        if (isSugarAdded){
            stringBuilder.append(" with sugar");
        }
        if (isChocolateAdded){
            stringBuilder.append(" with chocolate");
        }
        return stringBuilder.toString();
    }

    public double getCost(){
        if (isMilkAdded){
            baseCost += 10.0;
        }
        if (isSugarAdded){
            baseCost += 2.0;
        }
        if (isChocolateAdded){
            baseCost += 12.0;
        }
        return baseCost;
    }
}
