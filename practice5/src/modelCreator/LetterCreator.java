package modelCreator;

import model.Document;
import model.Letter;

public class LetterCreator extends DocumentCreator {
    @Override
    public Document CreateDocument() {
        return new Letter();
    }
}
