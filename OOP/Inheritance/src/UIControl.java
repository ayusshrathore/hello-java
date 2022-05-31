public abstract class UIControl { // abstract class is a class that can't be instantiated
    private boolean isEnabled = true;

    // public UIControl(boolean isEnabled) {
    // this.isEnabled = isEnabled;
    // System.out.println("UIControl");
    // }

    public static void main(String[] args) throws Exception {

    }

    // generic method (abstract concept) to render the control objects
    // methods can be classified as abstract, which will enforce the subclasses to
    // have their own definition of render method
    public abstract void render();

    public void enable() {
        isEnabled = true;
    }

    public void disable() {
        isEnabled = false;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
