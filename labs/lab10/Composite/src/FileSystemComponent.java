public abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void Display(int depth);

    public void Add(FileSystemComponent component) {
        throw new UnsupportedOperationException();
    }

    public void Remove(FileSystemComponent component) {
        throw new UnsupportedOperationException();
    }

    public FileSystemComponent GetChild(int index) {
        throw new UnsupportedOperationException();
    }
}
