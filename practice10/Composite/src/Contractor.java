public class Contractor extends OrganizationComponent {
    private String position;
    private double fixedPayment;

    public Contractor(String name, String position, double fixedPayment) {
        super(name);
        this.position = position;
        this.fixedPayment = fixedPayment;
    }

    public double GetFixedPayment() {
        return fixedPayment;
    }

    @Override
    public double GetBudget() {
        return 0;
    }

    @Override
    public int GetEmployeeCount() {
        return 1;
    }

    @Override
    public void DisplayStructure(String indent) {
        System.out.println(STR."\{indent}- \{name} (\{position}), Контракт на сумму: \{fixedPayment} тенге");
    }

    @Override
    public OrganizationComponent FindEmployeeByName(String name) {
        return this.name.equals(name) ? this : null;
    }
}
