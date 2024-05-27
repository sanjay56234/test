package DesignPatterns.FascadePattern.Fascade;

import DesignPatterns.FascadePattern.Product.Notification;
import DesignPatterns.FascadePattern.Product.Payment;
import DesignPatterns.FascadePattern.Product.Product;

public class OrderDAO {

    Product product;
    Payment payment;
    Notification notification;

    public OrderDAO(){
        product = new Product();
        payment = new Payment();
        notification = new Notification();
    }

    public void createOrder(){
        product.getProduct();
        payment.makePayment();
        notification.sendNotification();
    }


}
