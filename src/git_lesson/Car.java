package git_lesson;

public class Car {

    private String brand;
    private String color;
    private final Months months;

    public Car() {
        months = Months.September;
    }

    public void startEngine(){
        System.out.println("Start..");
    }

    public void checkMonth(Months month){
        if (month == months){
            System.out.println("true");
        } else {
            System.out.println("False");
        }
    }
}
