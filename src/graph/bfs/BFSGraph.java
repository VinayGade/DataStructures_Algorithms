package graph.bfs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSGraph {
	
	private int V; // number of vertices
	private LinkedList<Integer> adjacentLists[];  // list of adjacent Lists
	
	@SuppressWarnings("unchecked")
	BFSGraph(int v){
		
		V = v;
		adjacentLists = new LinkedList[v];
		
		for(int i=0; i<v; ++i)
			adjacentLists[i] = new LinkedList();
		
	}
	
	// Function to add an edge into the graph
    void addEdge(int v,int w){
    	adjacentLists[v].add(w); // add edge(v,w)
    }
    
    // prints BFS traversal from a given source s
    void bfs(int s) {
    	
    	// Mark all the vertices as not visited (By default set as false)
        boolean visited[] = new boolean[V];
        
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        visited[s] = true;
        queue.add(s);
        
        while(!queue.isEmpty()) {
        	
        	// Dequeue a vertex from queue and print it
        	s = queue.poll();
        	System.out.print(s+" ");
        	
        	/* Get all adjacent vertices of the dequeued vertex s
             If a adjacent has not been visited, then mark it
             visited and enqueue it
             */
        	Iterator<Integer> iter = adjacentLists[s].listIterator();
        	
        	while(iter.hasNext()) {
        		int n = iter.next();
        		if(!visited[n]) {
        			visited[n] = true;
        			queue.add(n);
        		}
        	}	
        }
    }

    public static void main(String args[]){
    	BFSGraph g = new BFSGraph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.bfs(2);
    }
}
