import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SalesFilterDecorator extends ReportDecorator {
    private double minAmount;
    private double maxAmount;

    public SalesFilterDecorator(IReport report, double minAmount, double maxAmount) {
        super(report);
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    @Override
    public String Generate() {
        List<Map<String, String>> filteredSales = new ArrayList<>();

        for (Map<String, String> sale : ((SalesReport) getReport()).getSalesData()) {
            double amount = Double.parseDouble(sale.get("amount"));
            if (amount >= minAmount && amount <= maxAmount) {
                filteredSales.add(sale);
            }
        }

        StringBuilder reportBuilder = new StringBuilder();
        for (Map<String, String> sale : filteredSales) {
            reportBuilder.append(sale.toString()).append("\n");
        }
        return reportBuilder.toString().trim();
    }
}
