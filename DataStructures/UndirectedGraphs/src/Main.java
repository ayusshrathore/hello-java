public class Main {
    public static void main(String[] args) {
        // weighted undirected graph
        var graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 2);
        graph.addEdge("B", "C", 3);
        graph.addEdge("A", "C", 7);
        graph.print();
        System.out.println(graph.getShortestPath("A", "C"));
    }
}