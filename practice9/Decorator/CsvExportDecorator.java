public class CsvExportDecorator extends ReportDecorator {

    public CsvExportDecorator(IReport report) {
        super(report);
    }

    @Override
    public String Generate() {
        return STR."Exporting to CSV:\n\{super.Generate()}";
    }
}
