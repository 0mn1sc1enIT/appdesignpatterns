import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DateFilterDecorator extends ReportDecorator {
    private LocalDate startDate;
    private LocalDate endDate;

    public DateFilterDecorator(IReport report, LocalDate startDate, LocalDate endDate) {
        super(report);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String Generate() {
        List<Map<String, String>> filteredData = new ArrayList<>();
        IReport report = getReport();

        if (report instanceof SalesReport) {
            List<Map<String, String>> salesData = ((SalesReport) report).getSalesData();
            for (Map<String, String> sale : salesData) {
                LocalDate date = LocalDate.parse(sale.get("date"));
                if ((date.isEqual(startDate) || date.isAfter(startDate)) && (date.isEqual(endDate) || date.isBefore(endDate))) {
                    filteredData.add(sale);
                }
            }
        } else if (report instanceof UserReport) {
            List<Map<String, String>> userData = ((UserReport) report).getUserData();
            for (Map<String, String> user : userData) {
                LocalDate date = LocalDate.parse(user.get("date"));
                if ((date.isEqual(startDate) || date.isAfter(startDate)) && (date.isEqual(endDate) || date.isBefore(endDate))) {
                    filteredData.add(user);
                }
            }
        }

        StringBuilder reportBuilder = new StringBuilder();
        for (Map<String, String> entry : filteredData) {
            reportBuilder.append(entry.toString()).append("\n");
        }
        return reportBuilder.toString().trim();
    }
}
