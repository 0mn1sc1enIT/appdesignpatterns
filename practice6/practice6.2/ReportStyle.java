public class ReportStyle {
    private String backgroundColor;
    private String font;
    private int fontSize;

    public ReportStyle(String backgroundColor, String font, int fontSize) {
        this.backgroundColor = backgroundColor;
        this.font = font;
        this.fontSize = fontSize;
    }
    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getFont() {
        return font;
    }

    public int getFontSize() {
        return fontSize;
    }
}
