public final class CheckBox extends UIControl { // now we cannot declare a class that extends the checkBox class with
                                                // final keyword

    // each class has it's own method to render encapsulation in action, we are
    // bundling the data and each operation on data into single unit
    @Override
    public void render() {
        System.out.println("Render CheckBox");
    }

}
