package HotelManagement.payment;

public class CashPayment implements Payment{
    @Override
    public boolean makePayment(Double amount) {
        return true;
    }
}
