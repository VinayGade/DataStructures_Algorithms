package graph.dfs;

import java.util.ArrayList;

import graph.adjancency_list.AdjacencyListGraph;

public class DFSDemo {

	public static void main(String[] args) {

		AdjacencyListGraph graph = new AdjacencyListGraph();

		final int CAPACITY = 5;

		ArrayList<ArrayList<Integer>> adjacentList = new ArrayList<ArrayList<Integer>>( CAPACITY);
		
		for(int i=0; i < CAPACITY; i++) 
			adjacentList.add(new ArrayList<Integer>());

		graph.addEdge(adjacentList, 0, 1);
		graph.addEdge(adjacentList, 0, 4);

		graph.addEdge(adjacentList, 1, 2);
		graph.addEdge(adjacentList, 1, 3);

		graph.addEdge(adjacentList, 1, 4);
		graph.addEdge(adjacentList, 2, 3);
		graph.addEdge(adjacentList, 3, 4);

		graph.print(adjacentList);
		
		System.out.println("Depth First Search :");
		DepthFirstSearch dfSearch = new DepthFirstSearch();
		dfSearch.dfs(adjacentList, CAPACITY);

	}
}
