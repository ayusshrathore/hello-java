public class TextBox extends UIControl { // to inherit fields & methods from UIControl
    private String text = "";

    public TextBox() {
        // super(true); // to call the constructor of the base class, this is called
        // constructor
        // chaining & should be the very first statement in the constructor
        System.out.println("TextBox");
    }

    @Override
    public void render() {
        System.out.println("Render TextBox");
    }

    @Override // annotation (label attached with class memebers) to give extra info to
    // compiler i.e overiding the method
    public String toString() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void clear() {
        text = "";
    }
}
