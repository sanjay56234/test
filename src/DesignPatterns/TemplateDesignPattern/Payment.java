package DesignPatterns.TemplateDesignPattern;

public abstract class Payment {

    public abstract void validate();
    public abstract void debit();
    public abstract void send();

    public  final void makePayment(){
        /// all the child will follow the same step, they can't override makePayment bcz it is made final
        validate();
        debit();
        send();
    }

}
