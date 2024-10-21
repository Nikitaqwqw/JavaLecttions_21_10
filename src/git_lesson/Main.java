package git_lesson;

public class Main {

    public static void main(String[] args) {

        Person john = new Person("John","Smith");
        Person barbara = new Person("Barbara","Sweps");

        Car car = new Car();
        car.startEngine();

        System.out.println("=====");
        john.sayHello();
        barbara.sayHello();

        SomeOtherPersonClass.doSomething();
    }

}
