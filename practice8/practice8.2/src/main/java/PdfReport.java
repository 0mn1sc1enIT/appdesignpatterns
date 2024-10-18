import com.itextpdf.io.exceptions.IOException;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;

public class PdfReport extends ReportGenerator {
    private String name;
    PdfDocument pdfDocument;
    Document document;

    public PdfReport(String name) throws FileNotFoundException {
        this.name = name;
        pdfDocument = new PdfDocument(new PdfWriter(name));
        document = new Document(pdfDocument);
    }

    @Override
    protected void gatherData(){
        Paragraph paragraph = new Paragraph("Some content in PDF file");
        document.add(paragraph);
    }
    @Override
    protected void formatData() {}

    @Override
    protected void createHeaders() {}

    @Override
    protected void saveToFile() throws IOException {
        pdfDocument.setDefaultPageSize(PageSize.A4);
        document.close();
        System.out.println(STR."PDF-отчет сохранен как \{name}");
    }
}
