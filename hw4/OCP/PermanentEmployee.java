package OCP;

public class PermanentEmployee extends Employee{
    public PermanentEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary() * 1.2; // Permanent employee gets 20% bonus
    }
}
