public class Main {
    public static void main(String[] args) {
        Document originalDocument = new Document("Original Title", "Original Content");
        originalDocument.addSection(new Section("Section 1", "Content of Section 1"));
        originalDocument.addImage(new Image("https://images.com/picture.jpg"));

        DocumentManager documentManager = new DocumentManager();

        Document clonedDocument = documentManager.createDocument(originalDocument);

        clonedDocument.setTitle("Cloned Title");
        clonedDocument.addSection(new Section("Section 2", "Content of Section 2"));
        clonedDocument.addImage(new Image("https://example.com/image.jpg"));

        System.out.println("Original Document: ");
        System.out.println(originalDocument);

        System.out.println("\nCloned Document: ");
        System.out.println(clonedDocument);
    }
}
