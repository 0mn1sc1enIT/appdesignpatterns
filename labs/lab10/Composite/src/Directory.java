import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public void Add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void Remove(FileSystemComponent component) {
        children.remove(component);
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
}
