public class Section implements IPrototype {
    private String title;
    private String content;

    public Section(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public IPrototype clone() {
        return new Section(this.title, this.content);
    }

    @Override
    public String toString() {
        return STR."Section: title=\{title}, content=\{content}\n";
    }
}
