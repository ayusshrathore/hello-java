public class TextBox {
    // NOTE: In Java fields shouldn't be public.
    public String text = ""; // Field

    public void setText(String text) {
        this.text = text;
    }

    public void clear() {
        text = ""; // no need of this keyword here because we didn't pass any parameters
    }
}
