package graph.dfs;

import java.util.Iterator;
import java.util.LinkedList;

class Graph{
	
	int V;
	LinkedList<Integer> adj[];
	
	// Constructor
    @SuppressWarnings("unchecked")
	Graph(int v){
    	
		V= v;
		adj = new LinkedList[v];
		
		for(int i=0; i<v; i++)
			adj[i] = new LinkedList();
	}
    
    void addEdge (int u, int v) {
    	adj[u].add(v);
    }
    
    void dfsUtil(int v, boolean visited[]) {
    	
    	//mark the current node as visited and print it...
    	visited[v] = true;
    	System.out.print(v + " ");
    	
    	
    	//Recur for all vertices adjacent to this vertex
    	 Iterator<Integer> iter = adj[v].listIterator();
    	 
    	 while (iter.hasNext()) {
    		 int n = iter.next();
    		 if(!visited[n])
    			 dfsUtil(n, visited);
    	 }
    }
    
    void dfs(int v)
    {
        // Mark all the vertices as
        // not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];
 
        // Call the recursive helper
        // function to print DFS
        // traversal
        dfsUtil(v, visited);
    }
}

public class Dfs {
	public static void main(String[] args) {
		
		Graph g = new Graph(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println(
            "Following is Depth First Traversal "
            + "(starting from vertex 2)");
 
        g.dfs(2);

	}

}
