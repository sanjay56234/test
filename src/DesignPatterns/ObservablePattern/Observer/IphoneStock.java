package DesignPatterns.ObservablePattern.Observer;

import DesignPatterns.ObservablePattern.Observable.NotificationAlertObservable;

import java.util.ArrayList;
import java.util.List;

public class IphoneStock implements StockObserver{
    int stock;
    List<NotificationAlertObservable> notificationAlertObservableList;
    
    public IphoneStock(){
        this.stock = 0;
        this.notificationAlertObservableList = new ArrayList<>();
    }
    @Override
    public void add(NotificationAlertObservable notificationAlertObservable) {
        notificationAlertObservableList.add(notificationAlertObservable);
    }

    @Override
    public void remove(NotificationAlertObservable notificationAlertObservable) {
        notificationAlertObservableList.remove(notificationAlertObservable);
    }

    @Override
    public void notifySubscribers() {
            for(NotificationAlertObservable notificationAlertObservable: notificationAlertObservableList){
                notificationAlertObservable.update();
            }
    }
    
    public void setStock(int count){
        if(stock==0){
            this.stock+=count;
            notifySubscribers();
        }
        else{
            this.stock+=count;
        }
    }
    
    public int getStock(){
        return this.stock;
    }
}
