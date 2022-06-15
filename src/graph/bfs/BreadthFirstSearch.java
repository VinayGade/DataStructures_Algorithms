package graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

	void breadthFirstSearch( ArrayList<ArrayList<Integer>> adjacentLists, int v, int r) {
		
		//v : number of vertices
		//adjacentLists : List of adjacent lists of all v vertices
		//r : root vertex 
		
		boolean visited[] = new boolean[v+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		visited[r] = true;
		queue.add(r);
		
		while(!queue.isEmpty()) {
			
			int x = queue.poll();
			System.out.println(x+" ");
			
			for(int y: adjacentLists.get(x)) {
				
				if(visited[y] == false) {
					
					visited[y] = true;
					queue.add(y);
				}				
			}
		}
	}
}
