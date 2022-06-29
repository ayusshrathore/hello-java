
public class Main {
    public static void main(String[] args) throws Exception {
        Array arrays = new Array(1);
        arrays.insert(2);
        arrays.insert(2);
        arrays.insert(5);
        arrays.removeAt(1);
        arrays.print();
        arrays.indexOf(5);
        int result = arrays.indexOf(5);
        System.out.println(result);

    }
}
