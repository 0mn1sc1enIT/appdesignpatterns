import model.*;
import modelCreator.*;

public class Main {
    public static void main(String[] args) {
        DocumentCreator reportCreator = new ReportCreator();
        Document report = reportCreator.CreateDocument();
        report.open();

        DocumentCreator resumeCreator = new ResumeCreator();
        Document resume = resumeCreator.CreateDocument();
        resume.open();

        DocumentCreator letterCreator = new LetterCreator();
        Document letter = letterCreator.CreateDocument();
        letter.open();

        DocumentCreator invoiceCreator = new InvoiceCreator();
        Document invoice = invoiceCreator.CreateDocument();
        invoice.open();
    }
}