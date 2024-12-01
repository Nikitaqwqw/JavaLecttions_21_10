package lesson32.builder;

public class Car {
    private String brand;
    private String engine;
    private String color;
    private String transmission;

    private Car() {};

    public static class Builder {
        private String brand;
        private String engine;
        private String color;
        private String transmission;

        public Builder setBrand(String brand){
            this.brand = brand;
            return this;
        }

        public Builder setEngine(String engine){
            this.engine = engine;
            return this;
        }

        public Builder setColor(String color){
            this.color = color;
            return this;
        }

        public Builder setTransmission(String transmission){
            this.transmission = transmission;
            return this;
        }

        public Car build(){
            Car car = new Car();
            car.brand = this.brand;
            car.color = this.color;
            car.engine = this.engine;
            car.transmission = this.transmission;
            return car;
        }

    }

    public void drive(){
        System.out.println("Start ...");
    }

    public void stopCar(){
        System.out.println("Stop ...");
    }

    public void openDoors(){
        System.out.println("Open doors");
    }

    public String getColor(){
        if (this.color == null) return "";
        return this.color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", engine='" + engine + '\'' +
                ", color='" + color + '\'' +
                ", transmission='" + transmission + '\'' +
                '}';
    }
}
