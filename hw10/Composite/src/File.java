public class File extends FileSystemComponent {
    private float size;

    public File(String name, float size) {
        super(name);
        this.size = size;
    }

    @Override
    public void Display(int depth) {
        System.out.println(STR."\{" ".repeat(depth)}File: \{name} [\{size} KB]");
    }
    @Override
    public float GetSize() {
        return size;
    }
}
