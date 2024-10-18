import java.io.FileWriter;
import java.io.IOException;

public class HtmlReport extends ReportGenerator {
    private String name;

    private StringBuilder htmlContent;

    public HtmlReport(String name) {
        this.name = name;
    }

    @Override
    protected void gatherData() {
        htmlContent = new StringBuilder();
        htmlContent.append("<table border='1'>");
        htmlContent.append("<tr><th>Заголовок</th><th>Данные</th></tr>");
        htmlContent.append("<tr><td>Строка 1</td><td>Данные 1</td></tr>");
        htmlContent.append("<tr><td>Строка 2</td><td>Данные 2</td></tr>");
        htmlContent.append("<tr><td>Строка 3</td><td>Данные 3</td></tr>");
        htmlContent.append("</table>");
    }

    @Override
    protected void formatData() {
        htmlContent.insert(0, "<style>table {width: 100%;} th, td {padding: 10px; text-align: left;}</style>");
    }

    @Override
    protected void createHeaders() {
        htmlContent.insert(0, "<h1>HTML Отчет</h1>");
    }

    @Override
    protected void saveToFile() throws IOException {
        String html = STR."<html><head><title>Отчет</title></head><body>\{htmlContent.toString()}</body></html>";

        try (FileWriter writer = new FileWriter(name)) {
            writer.write(html);
            System.out.println(STR."HTML-отчет сохранен как \{name}");
        }
    }

}
