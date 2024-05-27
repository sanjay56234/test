package DesignPatterns.ObservablePattern.Observer;

import DesignPatterns.ObservablePattern.Observable.NotificationAlertObservable;

public interface StockObserver {
    public void add(NotificationAlertObservable notificationAlertObservable);
    public void remove(NotificationAlertObservable notificationAlertObservable);
    public void notifySubscribers();
    
}
