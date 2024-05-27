package DesignPatterns.FascadePattern;

import DesignPatterns.FascadePattern.Fascade.OrderDAO;

public class Main {
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.createOrder();
    }
}
