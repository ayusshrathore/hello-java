package Executors;

// Executors -> A framework to manage threads (creation, assigning tasks, etc...) rather than explicitly
// handling them, so we do need to perform any thread manipulation on our own & let java's executor framework
// handle that
// But Executor framework doesn't protect us from concurrency issues such as Race condition & visibility problem

public class Main {
    public static void main(String[] args) {
        ExecutorsDemo.show();
    }
}
