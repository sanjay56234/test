package DesignPatterns.TemplateDesignPattern;

public class PaymentToFriend extends Payment{
    @Override
    public void validate() {
        System.out.println("Payment to friend");
    }

    @Override
    public void debit() {
        System.out.println("Payment to friend");
    }

    @Override
    public void send() {
        System.out.println("Payment to friend");
    }
}
