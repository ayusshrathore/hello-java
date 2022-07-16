public class Main {
    public static void main(String[] args) throws Exception {
        Array arrays = new Array(1);
        arrays.insert(1);
        arrays.insert(2);
        arrays.insert(3);
        arrays.insert(4);
        arrays.removeAt(1);
        arrays.print();
        arrays.indexOf(5);
        int result = arrays.indexOf(5);
        System.out.println(result);
        System.out.println(arrays.getLargest());
        arrays.getIntersection(arrays).print();
        arrays.intersect(new int[] { 2, 2, 5 }).print();
        System.out.println();
        arrays.insertAt(9, 0);
        arrays.print();
        System.out.println(arrays.reverseArray());

    }
}
