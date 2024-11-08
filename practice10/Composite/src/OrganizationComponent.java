import java.util.ArrayList;
import java.util.List;

public abstract class OrganizationComponent {
    protected String name;

    public OrganizationComponent(String name) {
        this.name = name;
    }

    public String GetName() {
        return name;
    }

    public abstract double GetBudget();
    public abstract int GetEmployeeCount();
    public abstract void DisplayStructure(String indent);
    public abstract OrganizationComponent FindEmployeeByName(String name);

    public void Add(OrganizationComponent component) {
        throw new UnsupportedOperationException();
    }

    public void Remove(OrganizationComponent component) {
        throw new UnsupportedOperationException();
    }

    public List<Employee> GetAllEmployees() {
        return new ArrayList<>();
    }
}


