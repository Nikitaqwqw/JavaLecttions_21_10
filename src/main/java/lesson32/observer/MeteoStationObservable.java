package lesson32.observer;

import java.util.ArrayList;
import java.util.List;

public class MeteoStationObservable {

    private List<Subscriber> subscriberList = new ArrayList<>();

    public void addSubscriber(Subscriber subscriber){
        subscriberList.add(subscriber);
    }

    public void deleteSubscriber(Subscriber subscriber){
        subscriberList.remove(subscriber);
    }

    public void updateDegreeInfo(String degree){
        notifySubscribers(degree);
    }

    private void notifySubscribers(String degree){
        for (Subscriber subscriber: subscriberList){
            subscriber.updateData(degree);
        }
    }

}
