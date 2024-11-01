public class Main {
    public static void main(String[] args) {
        IReport salesReport = new SalesReport();
        System.out.println("Базовый отчет по продажам:");
        System.out.println(salesReport.Generate());

        System.out.println("\nСоздание отчета по продажам с декораторами:");
        IReport decoratedSalesReport = ReportDecoratorFactory.createReportWithDecorators(salesReport);
        System.out.println(decoratedSalesReport.Generate());

        System.out.println("\nЭкспорт отчета в CSV:");
        ReportDecorator CsvReport = new CsvExportDecorator(decoratedSalesReport);
        System.out.println(CsvReport.Generate());

        IReport userReport = new UserReport();
        System.out.println("\nБазовый отчет по пользователям");
        System.out.println(userReport.Generate());

        System.out.println("\nСоздание отчета по пользователям с декоратор");
        IReport decoratedUserReport = ReportDecoratorFactory.createReportWithDecorators(userReport);
        System.out.println(decoratedUserReport.Generate());

        System.out.println("\nЭкспорт отчета в CSV:");
        ReportDecorator PdfReport = new PdfExportDecorator(decoratedUserReport);
        System.out.println(PdfReport.Generate());
    }
}
