package graph.adjacency_matrix;

//Undirected graph
public class Graph {

	private boolean adjMatrix[][];
	private int V;                  // vertex count
	
	public Graph(int v) {
		V = v;
		adjMatrix = new boolean[V][V];
	}
	
	public void addEdge(int u, int v) {
		adjMatrix[u][v]=true;
		adjMatrix[v][u]=true;
	}
	
	public void removeEdge(int u, int v) {
		adjMatrix[u][v]=false;
		adjMatrix[v][u]=false;
	}
	
	// Print matrix in 0, 1 form
	public String toString() {
		
		StringBuilder s = new StringBuilder();
	    for (int i = 0; i < V; i++) {
	      s.append(i + ": ");
	      for (boolean j : adjMatrix[i]) 
	        s.append((j ? 1 : 0) + " ");
	      
	      s.append("\n");
	    }
	    return s.toString();
	}
	
	public static void main(String[] args) {
		
		Graph g = new Graph(4);

	    g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(1, 3);
	    g.addEdge(0, 3);
	    
	   // g.removeEdge(2,1);
	    g.removeEdge(3,1);
	    //g.removeEdge(1,3);
	    
	    g.removeEdge(0,3);
	    //g.removeEdge(3,0);
	    
	    System.out.print(g.toString());

	}

}
