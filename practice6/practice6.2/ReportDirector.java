public class ReportDirector {
    public void constructReport(IReportBuilder builder, ReportStyle style) {
        builder.setHeader("Header");
        builder.setContent("Content.");
        builder.addSection("Section 1", "Details of section.");
        builder.setFooter("Footer");
        builder.setStyle(style);
    }
}
