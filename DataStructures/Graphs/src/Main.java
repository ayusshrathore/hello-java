public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph();
        // DFS
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("B", "C");
        graph.addEdge("A", "C");
        graph.print();
        graph.removeEdge("A", "C");
        graph.print();
        graph.traverseDepthFirst("A");
        graph.traverseDepthFirstIterative("A");

        // BFS
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.traverseBreadthFirst("A");
    }
}