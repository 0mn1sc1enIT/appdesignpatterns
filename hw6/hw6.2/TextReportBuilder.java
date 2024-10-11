public class TextReportBuilder implements IReportBuilder {
    private StringBuilder report = new StringBuilder();

    @Override
    public void setHeader(String header) {
        report.append(header).append("\n");
    }

    @Override
    public void setContent(String content) {
        report.append(content).append("\n");
    }

    @Override
    public void setFooter(String footer) {
        report.append(footer).append("\n");
    }

    @Override
    public Report getReport() {
        return new Report(report.toString());
    }
}
