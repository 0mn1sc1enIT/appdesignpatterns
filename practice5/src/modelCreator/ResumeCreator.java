package modelCreator;

import model.Document;
import model.Resume;

public class ResumeCreator extends DocumentCreator {
    @Override
    public Document CreateDocument() {
        return new Resume();
    }
}
