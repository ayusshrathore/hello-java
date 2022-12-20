import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private class Node{
        private String label;

        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString() {
            return  label;
        }
    }

    // private List<Node> nodes = new ArrayList<>();
    // using List would result in O(n) time complexity while adding an edge or a node instead we should
    // make use of Map
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>()); // adding node to adjacencyList with empty ArrayList to
        // track number of nodes it is connected to
    }

    public void addEdge(String from, String to){
        var fromNode = nodes.get(from);
        if(fromNode == null) throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if(toNode == null) throw new IllegalArgumentException();

        //uni-directed graph
        adjacencyList.get(fromNode).add(toNode);

        // bi-directed graph
        // adjacencyList.get(fromNode).add(toNode);
        // adjacencyList.get(toNode).add(fromNode);
    }

    public void print(){
        for(var source: adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }
}
