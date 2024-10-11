import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Report {
    private String content;

    public Report(String content) {
        this.content = content;
    }

    public void export(String fileType) {
        String fileName = "report." + fileType;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println(STR."Report exported to \{fileName}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
