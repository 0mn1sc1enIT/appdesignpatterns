public class Main {
    public static void main(String[] args) {
        ReportStyle style = new ReportStyle("white", "Times New Roman", 14);

        IReportBuilder textBuilder = new TextReportBuilder();
        ReportDirector director = new ReportDirector();

        director.constructReport(textBuilder, style);
        Report textReport = textBuilder.getReport();
        textReport.export("txt");

        IReportBuilder htmlBuilder = new HtmlReportBuilder();
        director.constructReport(htmlBuilder, style);
        Report htmlReport = htmlBuilder.getReport();
        htmlReport.export("html");
    }
}
