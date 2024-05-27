package DesignPatterns.ProxyDesignPattern;

public class EmployeeProxy implements EmployeeDOInterface{
    EmployeeDOInterface employeeDOInterface;

    public EmployeeProxy(){
        employeeDOInterface = new EmployeeImp();
    }
    @Override
    public void create(String client, Employee employee) {
        if(client == "ADMIN"){
            employeeDOInterface.create(client, employee);
        }
    }

    @Override
    public void delete(String client, String employeeId) {
        if(client == "ADMIN"){
            employeeDOInterface.delete(client, employeeId);
        }
    }

    @Override
    public void get(String client, String employeeId) {
        if(client == "ADMIN"){
            employeeDOInterface.get(client, employeeId);
        }
    }
}
