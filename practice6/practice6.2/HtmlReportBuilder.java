public class HtmlReportBuilder implements IReportBuilder {
    private StringBuilder report = new StringBuilder();
    private ReportStyle style;

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
    public void addSection(String sectionName, String sectionContent) {
        report.append("<h2>").append(sectionName).append("</h2>\n") // Добавляем раздел
                .append("<p>").append(sectionContent).append("</p>\n");
    }

    @Override
    public void setStyle(ReportStyle style) {
        this.style = style;
    }

    @Override
    public Report getReport() {
        StringBuilder css = new StringBuilder();
        css.append("\n<style>")
                .append("body {")
                .append("background-color: ").append(style.getBackgroundColor()).append(";")
                .append("font-family: ").append(style.getFont()).append(";")
                .append("font-size: ").append(style.getFontSize()).append("px;")
                .append("}")
                .append("</style>\n");

        // Оборачиваем весь отчет в HTML
        String completeReport = STR."<html><head><title>Report</title>\{css.toString()}</head><body>\n\{report.toString()}</body></html>";
        return new Report(completeReport);
    }
}
