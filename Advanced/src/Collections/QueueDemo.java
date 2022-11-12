package Collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void show(){
        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
        // b -> a -> c
        // in some cases of implementations offer method return
        // false when Queue is full & we try to insert an item
        queue.offer("d");
        var front = queue.peek();
        System.out.println(front);
        // similarly element() method return null pointer exception when queue is empty whereas
        // peek return null, also poll return null whereas remove return exception
        front = queue.remove();
        System.out.println(queue);
    }
}
