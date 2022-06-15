package graph.dfs;

import java.util.ArrayList;

public class DepthFirstSearch {

	public void dfsRecursive( ArrayList<ArrayList<Integer>> adjacent, int r, boolean[] visited) {
		
		visited[r] = true;
		System.out.println(r + " ");
		
		for(int u: adjacent.get(r)) 
			if(visited[u] == false)
				dfsRecursive( adjacent, u, visited);	
	}
	
	public void dfs( ArrayList<ArrayList<Integer>> adjacent, int v) {
		
		boolean visited [] = new boolean[v];
		
		for(int i = 0; i<v; i++)
			if(visited[i] == false)
				dfsRecursive( adjacent, i, visited);
	}
}