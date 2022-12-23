import java.util.*;

public class WeightedGraph {
    private class Node{
        String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString(){
            return label;
        }

        public void addEdge(Node to, int weight){
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges(){
            return edges;
        }
    }

    private class Edge{
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return from + "->" + to;
        }

    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label){
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight){
        var fromNode = nodes.get(from);
        if(fromNode == null) throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if(toNode == null) throw new IllegalArgumentException();

        // weighted undirected graph
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    private class NodeEntry{ // wrapper class in add priority to our node Object
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }
    public int getShortestPath(String from, String to){
        var fromNode = nodes.get(from);
        Map<Node, Integer> distances = new HashMap<>();
        for (Node node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);

        distances.replace(fromNode, 0); // make distance from node A->A = 0

        Set<Node> visited =  new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>((
                Comparator.comparingInt(ne -> ne.priority)
        ));
        queue.add(new NodeEntry(fromNode, 0)); // add the initial node to start with

        while(!queue.isEmpty()){ // BFS
            var curr = queue.remove().node;
            visited.add(curr); // mark visited

            for (var edge : curr.getEdges()){
                if(visited.contains(to)) continue;

                var newDistance = distances.get(curr) + edge.weight;
                if(newDistance < distances.get(edge.to)) distances.replace(edge.to, newDistance);
                queue.add(new NodeEntry(edge.to, newDistance));
            }
        }
        return distances.get(nodes.get(to));
    }
    public void print(){
        for(var node: nodes.values()){
            var edges = node.getEdges();
            if(!edges.isEmpty())
                System.out.println(node + " is connected to " + edges);
        }
    }
}
