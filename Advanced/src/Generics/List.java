package Generics;

public class List {
    private Object[] items = new Object[10];
    private int count = 0;

    public void add(Object item){
        items[count++] = item;
    }
    public Object get(int index){
        return items[index];
    }
}
