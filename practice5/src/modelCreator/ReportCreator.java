package modelCreator;

import model.Document;
import model.Report;

public class ReportCreator extends DocumentCreator {
    @Override
    public Document CreateDocument() {
        return new Report();
    }
}
