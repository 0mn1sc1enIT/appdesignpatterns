package modelCreator;

import model.Document;
import model.Invoice;

public class InvoiceCreator extends DocumentCreator {
    @Override
    public Document CreateDocument() {
        return new Invoice();
    }
}
