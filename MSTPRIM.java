import java.util.ArrayList;

public class MSTPRIM {
    public static void prim(ArrayList<ArrayList<Edge>> graph) {
        if (graph == null) {
            return;
        }
        
        int numVertices = graph.size();
        if (numVertices < 1) {
            return;
        }
        // list of edges that pass the nodes with prim minimum spanning tree
        ArrayList<ArrayList<Edge>> tree = new ArrayList<ArrayList<Edge>>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            tree.add(i, new ArrayList<Edge>());
        }
        
        boolean[] visited = new boolean[numVertices];       
        long totalMSTWeight = 0;
        MinHeap edges = new MinHeap();
        
        // Visit vertice 0
        visited[0] = true;              
        for (Edge e : graph.get(0)) {
            edges.push(e);
        }
        
        while (!edges.empty()) {
            Edge leastEdge = edges.pop();
            //Add the value of edge to the total value of edges which get from the passed nodes(parrents), and add it to the value of the node
            if (visited[leastEdge.getToVertex()] == false) {
                visited[leastEdge.getToVertex()] = true;
                totalMSTWeight += leastEdge.getWeight();
                tree.get(leastEdge.getFromVertex()).add(leastEdge);
                
                for (Edge e : graph.get(leastEdge.getToVertex())) {
                    if (visited[e.getToVertex()] == false) {
                        edges.push(e);
                    }
                }
            }
        }
              
        System.out.println("\n");
        for (int i = 0; i < tree.size(); i++) {
            for (Edge e : tree.get(i)) {
                //Present the weight of minimum spanning tree between two nodes
                System.out.println("Weight between "+(e.getFromVertex() + 1) + " and " + (e.getToVertex() + 1) +  " is : " + e.getWeight());
            }
        }
        //Total value of the passed nodes by prim minimum spanning tree algorithms
        System.out.println("Total Prim MST Weight is: "+totalMSTWeight);
        return;
    }
}