import java.time.LocalDate;
import java.util.Scanner;

public class ReportDecoratorFactory {
    private static Scanner scanner = new Scanner(System.in);

    public static IReport createReportWithDecorators(IReport baseReport) {
        IReport report = baseReport;
        boolean addMoreDecorators = true;

        while (addMoreDecorators) {
            System.out.println("Выберите декоратор для применения:");
            System.out.println("1. Фильтр по сумме продаж");
            System.out.println("2. Фильтр по дате");
            System.out.println("3. Сортировка по дате");
            System.out.println("0. Завершить выбор декораторов");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    report = applySalesFilter(report);
                    break;
                case 2:
                    report = applyDateFilter(report);
                    break;
                case 3:
                    report = new SortingDecorator(report);
                    break;
                case 0:
                    addMoreDecorators = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        return report;
    }

    private static IReport applySalesFilter(IReport report) {
        System.out.print("Введите минимальную сумму: ");
        double minAmount = scanner.nextDouble();
        System.out.print("Введите максимальную сумму: ");
        double maxAmount = scanner.nextDouble();
        scanner.nextLine();

        return new SalesFilterDecorator(report, minAmount, maxAmount);
    }

    private static IReport applyDateFilter(IReport report) {
        System.out.print("Введите начальную дату (yyyy-mm-dd): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите конечную дату (yyyy-mm-dd): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        return new DateFilterDecorator(report, startDate, endDate);
    }
}
