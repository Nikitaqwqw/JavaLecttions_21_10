package lesson32.observer;

public class PhoneSubscriber implements Subscriber {

    @Override
    public void updateData(String degree) {
        System.out.println("Phone Отримав нове значення температури: " + degree);
        showUpdatedTemperature();
    }

    public void showUpdatedTemperature(){
        System.out.println("Update temperature on Phone");
    }
}
