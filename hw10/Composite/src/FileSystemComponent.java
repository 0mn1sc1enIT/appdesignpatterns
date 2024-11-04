public abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void Display(int depth);
    public abstract float GetSize();

    public void Add(FileSystemComponent component) {
        throw new UnsupportedOperationException();
    }

    public void Remove(FileSystemComponent component) {
        throw new UnsupportedOperationException();
    }
    public FileSystemComponent GetChild(int index) {
        throw new UnsupportedOperationException("Cannot get child from a file");
    }
}
