import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingDecorator extends ReportDecorator {

    public SortingDecorator(IReport report) {
        super(report);
    }

    @Override
    public String Generate() {
        List<Map<String, String>> data = new ArrayList<>();

        IReport report = getReport();
        if (getReport() instanceof SalesReport) {
            data = ((SalesReport) report).getSalesData();
        } else if (report instanceof UserReport) {
            data = ((UserReport) report).getUserData();
        }

        List<Map<String, String>> sortedData = data.stream()
                .sorted(Comparator.comparing(entry -> entry.get("date")))
                .toList();

        StringBuilder reportBuilder = new StringBuilder();
        for (Map<String, String> entry : sortedData) {
            reportBuilder.append(entry.toString()).append("\n");
        }
        return reportBuilder.toString().trim();
    }
}
