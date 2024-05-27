package HotelManagement.payment;

public class CardPayment implements Payment{
    @Override
    public boolean makePayment(Double amount) {
        return true;
    }
}
