import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public void Add(FileSystemComponent component) {
        if (!children.contains(component)) {
            children.add(component);
        } else {
            System.out.println(STR."Component '\{component.name}' already exists in '\{name}'.");
        }
    }

    @Override
    public void Remove(FileSystemComponent component) {
        if (children.contains(component)) {
            children.remove(component);
        } else {
            System.out.println(STR."Component '\{component.name}' not found in '\{name}'.");
        }
    }

    @Override
    public FileSystemComponent GetChild(int index) {
        return children.get(index);
    }
    @Override
    public void Display(int depth) {
        System.out.println(STR."\{" ".repeat(depth)}Directory: \{name}");
        for (FileSystemComponent component : children) {
            component.Display(depth + 2);
        }
    }

    @Override
    public float GetSize() {
        float totalSize = 0f;
        for (FileSystemComponent component : children) {
            totalSize += component.GetSize();
        }
        return totalSize;
    }
}
