package DesignPatterns.ObservablePattern.Observable;

import DesignPatterns.ObservablePattern.Observer.IphoneStock;
import DesignPatterns.ObservablePattern.Observer.StockObserver;

public class EmailNotification implements NotificationAlertObservable{

    IphoneStock stockObserver;
    public EmailNotification(IphoneStock stockObserver){
        this.stockObserver = stockObserver;
    }
    @Override
    public void update() {
        System.out.println(String.format("Email : Iphone stock has updated by : %s", stockObserver.getStock()));
    }
}
