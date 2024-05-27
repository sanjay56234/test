package DesignPatterns.ProxyDesignPattern;

public class EmployeeImp implements EmployeeDOInterface{
    @Override
    public void create(String client, Employee employee) {
        System.out.println("Created Employee");
    }

    @Override
    public void delete(String client, String employeeId) {
        System.out.println("Delete Employee");
    }

    @Override
    public void get(String client, String employeeId) {
        System.out.println("Get Employee");
    }
}
