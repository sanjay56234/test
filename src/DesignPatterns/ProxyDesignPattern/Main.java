package DesignPatterns.ProxyDesignPattern;

public class Main {
    public static void main(String[] args) {
        EmployeeProxy employeeProxy = new EmployeeProxy();

        employeeProxy.create("ADMIN", new Employee());
    }
}
