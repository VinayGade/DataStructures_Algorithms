package graph.adjancency_list;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph {

	public static void main(String[] args) {

		final int CAPACITY = 5;

		AdjacencyListGraph graph = new AdjacencyListGraph();

		ArrayList<ArrayList<Integer>> adjacentList = new ArrayList<ArrayList<Integer>>(CAPACITY);

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
	}

	public void addEdge( ArrayList<ArrayList<Integer>> adjacentList, int u, int v) {
		adjacentList.get(u).add(v);
		adjacentList.get(v).add(u);    //  undirected graph
	}

	public void print( ArrayList<ArrayList<Integer>> adjacentList) {
		for(int i = 0; i < adjacentList.size(); i++) {
			List<Integer> edges = adjacentList.get(i);
			for(Integer j : edges) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}