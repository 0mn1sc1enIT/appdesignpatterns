import java.util.ArrayList;
import java.util.List;

public class Document implements IPrototype {
    private String title;
    private String content;
    private List<Section> sections = new ArrayList<>();
    private List<Image> images = new ArrayList<>();

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public List<Section> getSections() {
        return sections;
    }

    public List<Image> getImages() {
        return images;
    }

    @Override
    public IPrototype clone() {
        Document clonedDocument = new Document(this.title, this.content);
        for (Section section : this.sections) {
            clonedDocument.addSection((Section) section.clone());
        }
        for (Image image : this.images) {
            clonedDocument.addImage((Image) image.clone());
        }
        return clonedDocument;
    }

    @Override
    public String toString() {
        return STR."Document \{title}\ncontent=\{content}\nsections:\n\{sections} images:\n\{images}\n";
    }
}
