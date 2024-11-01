import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesReport implements IReport {
    private List<Map<String, String>> salesData;

    public SalesReport() {
        this.salesData = new ArrayList<>();
        System.out.println("Sales Report");

        Map<String, String> sale1 = new HashMap<>();
        sale1.put("date", "2023-09-05");
        sale1.put("amount", "1000000");

        Map<String, String> sale2 = new HashMap<>();
        sale2.put("date", "2023-01-13");
        sale2.put("amount", "1500000");

        Map<String, String> sale3 = new HashMap<>();
        sale3.put("date", "2023-10-18");
        sale3.put("amount", "900000");

        Map<String, String> sale4 = new HashMap<>();
        sale4.put("date", "2023-08-12");
        sale4.put("amount", "2150000");

        Map<String, String> sale5 = new HashMap<>();
        sale5.put("date", "2024-01-25");
        sale5.put("amount", "1800000");

        Map<String, String> sale6 = new HashMap<>();
        sale6.put("date", "2024-06-30");
        sale6.put("amount", "3100000");

        salesData.add(sale1);
        salesData.add(sale2);
        salesData.add(sale3);
        salesData.add(sale4);
        salesData.add(sale5);
        salesData.add(sale6);
    }

    public List<Map<String, String>> getSalesData() {
        return salesData;
    }

    @Override
    public String Generate() {
        StringBuilder reportBuilder = new StringBuilder();
        for (Map<String, String> sale : salesData) {
            reportBuilder.append(sale.toString()).append("\n");
        }
        return reportBuilder.toString().trim();
    }
}