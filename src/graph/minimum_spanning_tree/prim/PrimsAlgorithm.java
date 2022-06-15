package graph.minimum_spanning_tree.prim;

import java.util.Arrays;

public class PrimsAlgorithm {

	public void prim(int graph[][], int vertex) {

		int INF = 9999999;
		int edgeCount; // number of edge

		// create a array to track selected vertex
		// selected will become true otherwise false
		boolean[] selected = new boolean[vertex];

		// set selected false initially
		Arrays.fill(selected, false);

		// set number of edge to 0
		edgeCount = 0;

		// the number of egde in minimum spanning tree will be
		// always less than (V -1), where V is number of vertices in
		// graph

		// choose 0th vertex and make it true
		selected[0] = true;

		// print for edge and weight
		System.out.println("Edge : Weight");

		while (edgeCount < vertex - 1) {
			// For every vertex in the set S, find the all adjacent vertices
			// , calculate the distance from the vertex selected at step 1.
			// if the vertex is already in the set S, discard it otherwise
			// choose another vertex nearest to selected vertex at step 1.

			int min = INF;
			int x = 0; // row number
			int y = 0; // col number

			for (int i = 0; i < vertex; i++) {
				if (selected[i]) {
					for (int j = 0; j < vertex; j++) {
						// not in selected and there is an edge
						if (!selected[j] && graph[i][j] != 0) {
							if (min > graph[i][j]) {
								min = graph[i][j];
								x = i;
								y = j;
							}
						}
					}
				}
			}
			System.out.println(x + " - " + y + " :  " + graph[x][y]);
			selected[y] = true;
			edgeCount++;
		}
	}

	public static void main(String[] args) {
		PrimsAlgorithm graph = new PrimsAlgorithm();

		// number of vertices in grapj
		int vertexCount = 5;

		// create a 2d array of size 5x5
		// for adjacency matrix to represent graph
		int[][] primGraph = 
		{ 
					{ 0, 9, 75, 0, 0 }, 
					{ 9, 0, 95, 19, 42 }, 
					{ 75, 95, 0, 51, 66 }, 
					{ 0, 19, 51, 0, 31 },
					{ 0, 42, 66, 31, 0 } 
		};

		graph.prim( primGraph, vertexCount);
	}
}
