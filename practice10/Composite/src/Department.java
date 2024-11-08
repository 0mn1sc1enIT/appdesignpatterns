import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void Add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void Remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public double GetBudget() {
        double totalBudget = 0;
        for (OrganizationComponent component : components) {
            totalBudget += component.GetBudget();
        }
        return totalBudget;
    }

    @Override
    public int GetEmployeeCount() {
        int totalEmployees = 0;
        for (OrganizationComponent component : components) {
            totalEmployees += component.GetEmployeeCount();
        }
        return totalEmployees;
    }

    @Override
    public void DisplayStructure(String indent) {
        System.out.println(STR."\{indent}+ \{name}");
        for (OrganizationComponent component : components) {
            component.DisplayStructure(STR."\{indent}  ");
        }
    }

    @Override
    public OrganizationComponent FindEmployeeByName(String name) {
        for (OrganizationComponent component : components) {
            OrganizationComponent found = component.FindEmployeeByName(name);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    @Override
    public List<Employee> GetAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        for (OrganizationComponent component : components) {
            if (component instanceof Employee) {
                allEmployees.add((Employee) component);
            } else if (component instanceof Department) {
                allEmployees.addAll(((Department) component).GetAllEmployees());
            }
        }
        return allEmployees;
    }
}
