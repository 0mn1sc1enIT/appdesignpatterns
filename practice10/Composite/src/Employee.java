public class Employee extends OrganizationComponent {
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        super(name);
        this.position = position;
        this.salary = salary;
    }

    public double GetSalary() {
        return salary;
    }

    public void SetSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double GetBudget() {
        return salary;
    }

    @Override
    public int GetEmployeeCount() {
        return 1;
    }

    @Override
    public void DisplayStructure(String indent) {
        System.out.println(STR."\{indent}- \{name} (\{position}), Зарплата: \{salary} тенге");
    }

    @Override
    public OrganizationComponent FindEmployeeByName(String name) {
        return this.name.equals(name) ? this : null;
    }
}
