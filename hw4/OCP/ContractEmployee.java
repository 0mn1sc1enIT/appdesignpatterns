package OCP;

public class ContractEmployee extends Employee{
    public ContractEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary() * 1.1; // Contract employee gets 10% bonus
    }
}
