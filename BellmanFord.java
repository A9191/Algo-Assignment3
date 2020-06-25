import java.util.HashMap;

public class BellmanFord {
	
	public static void bellmanFord(int source,int vertices, int Edges, int[][] graph) {

		// hashmap is used to save vertices with their name and their values
		HashMap<Integer, Node> nodesHashMap = new HashMap<>();
		for (int i = 1; i < graph.length; i++) {

			// First we make the value of the source equal to zero, then the rest vertices
			//should be equal to infinity. 
			//the path will goes throw each vertices and change infinity to the passed edges value
			//and if the destination would be the same source, it defines zero
			nodesHashMap.put(i, new Node(i, i == source ? 0 : Integer.MAX_VALUE, i == source ? 
                Integer.toString(i) : ""));
		}
 
		// the loop will run for all vertices except the source 
		for (int var = 1; var <= vertices - 1; var++) {
			// this loop on the set of Edges on hashmap 
			for (Edge e : Edge.getEdges(Edges, graph)) {
				Node u = nodesHashMap.get(e.u);
				Node v = nodesHashMap.get(e.v);
				
				// update shortest path from previous vertices
				if (v.distance > u.distance + graph[u.value][v.value]) {
					v.distance = u.distance + graph[u.value][v.value];
					v.path = u.path + "->" + Integer.toString(v.value);
				}
			}
		}
 
		// this loop in random set of Edges to check for negative cycle
		for (Edge e : Edge.getEdges(Edges, graph)) {
			Node u = nodesHashMap.get(e.u);
			Node v = nodesHashMap.get(e.v);	 

			 //if there is still better shortest path it means there is negative cycle
			 //here the algorithm start relaxing on the mentioned node and return to check other paths
			if (v.distance > u.distance + graph[u.value][v.value]) {
				System.out.println("Negative cycle");
				return;
			}
		}
		//this loop updates the key value
		for (int node : nodesHashMap.keySet()) {
			System.out.println(nodesHashMap.get(node));
		}
	}

}