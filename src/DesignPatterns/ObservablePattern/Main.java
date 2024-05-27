package DesignPatterns.ObservablePattern;

import DesignPatterns.ObservablePattern.Observable.EmailNotification;
import DesignPatterns.ObservablePattern.Observable.NotificationAlertObservable;
import DesignPatterns.ObservablePattern.Observer.IphoneStock;
import DesignPatterns.ObservablePattern.Observer.StockObserver;

public class Main {
    public static void main(String[] args) {
        IphoneStock stockObserver = new IphoneStock();

        NotificationAlertObservable notificationAlertObservable = new EmailNotification(stockObserver);
        NotificationAlertObservable notificationAlertObservable1 = new EmailNotification(stockObserver);
        stockObserver.add(notificationAlertObservable);
        stockObserver.add(notificationAlertObservable1);

        stockObserver.setStock(10);
    }
}
