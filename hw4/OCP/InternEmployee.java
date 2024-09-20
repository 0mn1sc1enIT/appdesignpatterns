package OCP;

public class InternEmployee extends Employee {
    public InternEmployee(String name, double baseSalary) {
        super(name, baseSalary);
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary() * 0.8; // Intern gets 80% of the base salary
    }
}
