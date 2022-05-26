public class Main {
    public static void main(String[] args) throws Exception {
        // inheritance in action
        var box1 = new TextBox();
        box1.disable();
        System.out.println(box1.isEnabled());

        // Object class
        var obj = new Object();
        System.out.println(obj.getClass());

        System.out.println(box1.hashCode()); // output: 1651191114 (int) which is calculted on the basis of the object's
        // memory address (undergoes hash function), mostlly used in comparing objects
        // for equality
        var box2 = box1;
        System.out.println(box2.hashCode()); // same output as box1 since pointing to same memory address
        System.out.println(box1.equals(box2));

        System.out.println(box1.toString()); // returns the string representation of the object

        // constructor and inheritance
        var box3 = new TextBox(); // first constructor of base class is called then the constructor of derived/sub
        // class output: UIControl TextBox

        // if constructor of base class have some parameter

        // Access modifiers
        // public: accessible from anywhere

        // private: accessible from anywhere in the same class (can't be
        // accessed/inherited from outside the class)

        // protected: are public in their package, but also accesible by child classes
        // in other packages (should be avoided)

        // package-private (default): accessible from anywhere in the same package
        // (public anywhere in this package and private outside it)

        // Method overriding: overriding is the process of changing the implementation
        // of a method in a derived class
        // don't confuse it with method overloading, which is the process of writing a
        // method with the same name but different signatures, parameters, return types
        var textBox = new TextBox();
        // System.out.println(textBox.toString()); // suppose we need to change the
        // implementation of toString()
        textBox.setText("hello Java");
        System.out.println(textBox); // no need of explicityly writing toString() here called default on objects

        // Upcasting & Downcasting
        // since textBox is inherited from UIControl, we can use it as a UIControl
        // var control = new UIControl(true);
        var textBox2 = new TextBox();
        // show(textBox2); // this object automatically converted/cast to UIControl this
        // is called upcasting, object is cast to it's parent
        // show(textBox2); // output: empty string since at runtime we are passing the
        // textBox object so when print statement of show method is executed toString()
        // is called on the object
        // show(control);

        // Comparing objects
        var point1 = new Point(1, 2);
        var point2 = new Point(1, 2);
        // System.out.println(point1 == point2); // false since they are not pointing to
        // same memory address

        // for this to change to true, we need to override the equals() method
        // after overiding equlas() method
        System.out.println(point1.equals(point2));
        // comparing with different textBox object
        System.out.println(point1.equals(new TextBox()));

        // both have same hashcode based on content of the object
        System.out.println(point1.hashCode());
        System.out.println(point2.hashCode());

        // Polymorphism
        // polymorphism is the ability of an object to take on many forms
        // creating array of control objects and rendering them on console
        UIControl[] controls = { new TextBox(), new CheckBox() };
        for (var control : controls) {
            control.render(); // polymorphism in action since the control object is taking different forms on
            // each iteration
        }

        // Abstract class and methods: we use abstraction when we don't want to create
        // an instance of that particular class

        // for example here in this array there is no meaning of instantiating UIControl
        // to use render method on it
        // UIControl[] controls = { new UIControl, new TextBox(), new CheckBox() };

        // Final Class and Methods
        // Final class is a class that cannot be extended
        // Final methods are same as final classes
        // public class MyCheckBox extends CheckBox {} // error since CheckBox is final
        // class (this should be used only if we have made many assumptions in
        // implementation of that class, as this will prevent other classes from
        // extending it)
        // String Class is a example of final class because it is immutable
        // every method modfying the string will return a new string

    }

    public static void show(UIControl control) { // UIControl can also be replaced with Object since every textBox is
        if (control instanceof TextBox) {
            // hence a object
            // control. at compile time we doesn't have access to methods of control class
            // jus the members of control class

            // in order to make them accessible we need to downcast the object to the class
            var textBox = (TextBox) control; // downcasting, object is cast to it's child
            textBox.setText("Hello Java");
        }
        System.out.println(control);

        // also we can't convert a control object to a textBox object (by passing a
        // actual control object in show()) since control is more generic than textBox
        // i.e of more sepecific type

        // above condiction can also be resolved by checking if control object which is
        // passed at runtime is a instaceof textBox object, so it can be safely casted
        // to textBox object
    }
}
