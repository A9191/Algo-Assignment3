
public class Edge {
    private int fromVert;
    private int toVert;
    private int weight; //values of the edges
	int u;
	int v;
    //construction
    public Edge(int fromVert, int toVert, int weight) {
        this.fromVert = fromVert;
        this.toVert = toVert;
        this.weight = weight;
    }
    //construction
	public Edge(int u, int v) {
		this.u = u;
		this.v = v;
	}

	public String toString() {
		return this.u + " " + this.v;
	}
    
    public int getFromVertex() {
        return fromVert;
    }
    
    public int getToVertex() {
        return toVert;
    }
    
    public int getWeight() {
        return weight;
    }
    //check reachable edges from each node of graph
    public static Edge[] getEdges(int numEdges, int[][] graph) {
		Edge[] rv = new Edge[numEdges];
		int id = 0;
		for (int u = 1; u < graph.length && id < rv.length; u++) {
		for (int v = 1; v < graph[u].length && id < rv.length; v++) {
				rv[id] = new Edge(u, v);
				id = graph[u][v] != 0 ? id + 1 : id;
			}
		}
 
		return rv;
	}
}