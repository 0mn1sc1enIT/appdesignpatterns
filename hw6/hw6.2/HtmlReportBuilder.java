public class HtmlReportBuilder implements IReportBuilder {
    private StringBuilder report = new StringBuilder();

    @Override
    public void setHeader(String header) {
        report.append("<h1>").append(header).append("</h1>\n");
    }

    @Override
    public void setContent(String content) {
        report.append("<p>").append(content).append("</p>\n");
    }

    @Override
    public void setFooter(String footer) {
        report.append("<footer>").append(footer).append("</footer>\n");
    }

    @Override
    public Report getReport() {
        return new Report(report.toString());
    }
}
