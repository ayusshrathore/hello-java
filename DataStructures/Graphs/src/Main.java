import java.util.Arrays;

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

        // Topological Sort
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");
        graph.addEdge("X", "A");
        graph.addEdge("X", "B");
        graph.addEdge("B", "P");
        graph.addEdge("A", "P");
        System.out.println(graph.topoLogicalSort().toString());;

        // hasCycle()
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        System.out.println(graph.hasCycle());
    }
}