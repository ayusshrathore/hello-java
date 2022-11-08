// Combining all interfaces, in order to do so we could extend this UIWidget Interface with Draggable interface
// In java Interface can have multiple parents, but classes can't
public interface UIWidget extends Draggable, Resizable {
    void render();
}

