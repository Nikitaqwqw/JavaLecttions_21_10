package lesson32.observer;

public class TVSubscriber implements Subscriber {

    @Override
    public void updateData(String degree) {
        System.out.println("Телевізор отримав нове значення температури: " + degree);
        showUpdatedTemperature();
    }

    public void showUpdatedTemperature(){
        System.out.println("Update temperature on TV");
    }
}
