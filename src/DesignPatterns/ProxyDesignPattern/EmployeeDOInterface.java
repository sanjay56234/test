package DesignPatterns.ProxyDesignPattern;

public interface EmployeeDOInterface {

    public void create(String client, Employee employee);
    public void delete(String client, String employeeId);
    public void get(String client, String employeeId);
}
