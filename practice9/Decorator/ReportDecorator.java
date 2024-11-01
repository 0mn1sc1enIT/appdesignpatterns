public abstract class ReportDecorator implements IReport {
    private IReport report;
    public ReportDecorator(IReport report) {
        this.report = report;
    }

    public IReport getReport() {
        return report;
    }
    @Override
    public String Generate() {
        return report.Generate();
    }
}
