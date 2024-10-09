public class DocumentManager {
    public Document createDocument(IPrototype prototype) {
        return (Document) prototype.clone();
    }
}
