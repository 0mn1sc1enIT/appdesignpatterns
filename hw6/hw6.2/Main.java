public class Main {
    public static void main(String[] args) {
        ReportDirector director = new ReportDirector();

        IReportBuilder textBuilder = new TextReportBuilder();
        director.constructReport(textBuilder, "Введение", "Содержание отчета", "Заключение");
        Report textReport = textBuilder.getReport();
        System.out.println("Текст:");
        textReport.display();

        IReportBuilder htmlBuilder = new HtmlReportBuilder();
        director.constructReport(htmlBuilder, "HTML отчет", "Содержание HTML отчета", "Подвал HTML отчета");
        Report htmlReport = htmlBuilder.getReport();
        System.out.println("HTML:");
        htmlReport.display();
    }
}
