import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ReportGenerator pdfReport = new PdfReport("Report.pdf");
        ReportGenerator excelReport = new ExcelReport("Report.xlsx");
        ReportGenerator htmlReport = new HtmlReport("Report.html");

        System.out.println("=== PDF Отчет ===");
        pdfReport.generateReport();

        System.out.println("=== Excel Отчет ===");
        excelReport.generateReport();

        System.out.println("=== HTML Отчет ===");
        htmlReport.generateReport();
    }
}
