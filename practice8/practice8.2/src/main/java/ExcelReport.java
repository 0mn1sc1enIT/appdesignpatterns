import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReport extends ReportGenerator {
    private String name;
    private Workbook workbook;
    private Sheet sheet;
    private String[][] data;

    public ExcelReport(String name) {
        this.name = name;
    }
    @Override
    protected void gatherData() {
        data = new String[][]{
                {"Заголовок", "Данные"},
                {"Строка 1", "Данные 1"},
                {"Строка 2", "Данные 2"},
                {"Строка 3", "Данные 3"}
        };

        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("Отчет");
    }

    @Override
    protected void formatData() {
        CellStyle headerStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        headerStyle.setFont(font);

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < data[0].length; i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(data[0][i]);
            headerCell.setCellStyle(headerStyle);
        }
    }

    @Override
    protected void createHeaders() {
        for (int i = 1; i < data.length; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }
    }

    @Override
    protected void saveToFile() throws IOException {
        for (int i = 0; i < data[0].length; i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream(name)) {
            workbook.write(fileOut);
            System.out.println(STR."Excel-отчет сохранен как \{name}");
        }

        workbook.close();
    }
}
