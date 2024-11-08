import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", "Developer", 1600000);
        Employee emp2 = new Employee("Bob", "Designer", 1500000);
        Employee emp3 = new Employee("Charlie", "Manager", 1800000);
        Contractor contractor1 = new Contractor("Dave", "Freelance Developer", 900000);

        Department designDept = new Department("Design Department");
        designDept.Add(emp2);

        Department developmentDept = new Department("Development Department");
        developmentDept.Add(emp1);
        developmentDept.Add(contractor1);

        Department headDept = new Department("Head Department");
        headDept.Add(emp3);
        headDept.Add(designDept);
        headDept.Add(developmentDept);

        System.out.println("Структура организации:");
        headDept.DisplayStructure("");

        System.out.println(STR."\nОбщий бюджет \{headDept.GetName()}: \{headDept.GetBudget()} тенге");
        System.out.println(STR."Общее количество сотрудников в \{headDept.GetName()}: \{headDept.GetEmployeeCount()}");

        emp1.SetSalary(2000000);
        System.out.println(STR."\nНовая зарплата для \{emp1.GetName()}: $\{emp1.GetSalary()}");
        System.out.println(STR."Обновленный бюджет \{headDept.GetName()}: $\{headDept.GetBudget()}");

        String searchName = "Alice";
        OrganizationComponent foundEmployee = headDept.FindEmployeeByName(searchName);
        if (foundEmployee != null) {
            System.out.println("\nНайден сотрудник:");
            foundEmployee.DisplayStructure("");
        } else {
            System.out.println(STR."\nСотрудник с именем \{searchName} не найден.");
        }

        System.out.println(STR."\nВсе сотрудники \{headDept.GetName()}:");
        List<Employee> allEmployees = headDept.GetAllEmployees();
        for (Employee employee : allEmployees) {
            System.out.println(STR."- \{employee.GetName()} (\{employee.GetBudget()})");
        }
    }
}
