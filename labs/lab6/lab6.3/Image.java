public class Image implements IPrototype {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    @Override
    public IPrototype clone() {
        return new Image(this.url);
    }

    @Override
    public String toString() {
        return STR."Image: url=\{url}";
    }
}
