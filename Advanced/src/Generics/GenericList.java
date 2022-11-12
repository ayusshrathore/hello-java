package Generics;

// Another convention is GenericList<E> E: stands for element we use that when
// we use that when we want a class to act as a collection
public class GenericList<T> {
    private T[] items = (T[]) new Object[10];
    private  int count;

    public void add(T item){
        items[count++] = item;
    }
    public T get(int index){
        return items[index];
    }
}
