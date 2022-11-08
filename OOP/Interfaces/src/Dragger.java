public class Dragger {
    // coupled with UIWidget interface
    public void drag(Draggable draggable){
        draggable.drag();
        System.out.println("Dragging complete!");
    }

// we could extend the UIWidget Interface with Draggable interface,
// in order to use them together in a class with a single obj
//    public void drag(UIWidget draggable){
//        draggable.drag();
//        System.out.println("Dragging complete!");
//    }
}
