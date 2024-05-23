package DesignPatterns.TemplateDesignPattern;

public class PaymentToMerchant extends Payment{
    @Override
    public void validate() {
        System.out.println("Payment to merchant");
    }

    @Override
    public void debit() {
        System.out.println("Payment to merchant");
    }

    @Override
    public void send() {
        System.out.println("Payment to merchant");
    }
}
