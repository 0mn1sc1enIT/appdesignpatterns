import model.*;
import modelCreator.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Выберите тип файла: ");
        String choice = scan.next().toLowerCase();
        switch (choice) {
            case "report":
                DocumentCreator reportCreator = new ReportCreator();
                Document report = reportCreator.CreateDocument();
                report.open();
                break;
            case "resume":
                DocumentCreator resumeCreator = new ResumeCreator();
                Document resume = resumeCreator.CreateDocument();
                resume.open();
                break;
            case "letter":
                DocumentCreator letterCreator = new LetterCreator();
                Document letter = letterCreator.CreateDocument();
                letter.open();
            case "invoice":
                DocumentCreator invoiceCreator = new InvoiceCreator();
                Document invoice = invoiceCreator.CreateDocument();
                invoice.open();
            default:
                throw new IllegalStateException("Неподходящий тип файла: " + choice);
        }
    }
}