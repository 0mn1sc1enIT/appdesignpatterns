public class TextReportBuilder implements IReportBuilder {
    private StringBuilder report = new StringBuilder();
    private ReportStyle style;

    @Override
    public void setHeader(String header) {
        report.append("Header: ").append(header).append("\n");
    }

    @Override
    public void setContent(String content) {
        report.append("Content: ").append(content).append("\n");
    }

    @Override
    public void setFooter(String footer) {
        report.append("Footer: ").append(footer).append("\n");
    }

    @Override
    public void addSection(String sectionName, String sectionContent) {
        report.append("Section: ").append(sectionName).append("\n")
                .append(sectionContent).append("\n");
    }

    @Override
    public void setStyle(ReportStyle style) {
        this.style = style;
    }

    @Override
    public Report getReport() {
        return new Report(report.toString());
    }
}
