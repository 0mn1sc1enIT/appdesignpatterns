import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class ReportGenerator {

    public final void generateReport() throws FileNotFoundException {
        gatherData();
        formatData();
        createHeaders();
        try {
            saveToFile();
        } catch (Exception e) {
            System.out.println(STR."Ошибка при сохранении отчета: \{e.getMessage()}");
        }
    }

    protected abstract void gatherData() throws FileNotFoundException;
    protected abstract void formatData();
    protected abstract void createHeaders();
    protected abstract void saveToFile() throws Exception;
}
