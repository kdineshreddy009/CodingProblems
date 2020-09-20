package graphs;

import java.util.ArrayList;
/* 
problem:- https://practice.geeksforgeeks.org/problems/mother-vertex/1/?track=DSASP-Graph&batchId=145
Explanation:- https://youtu.be/_fPBbYtlG_w?t=393

Mother Vertex(NOT Strongly Connected Component):
Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.
*/

public class MotherVertex {
	static int[] visited;
	static int findMother(ArrayList<ArrayList<Integer>> adjacencyList, int n) {
		visited = new int[n];
		int last_visited = -1;
		// i) Do DFS on graph at all vertices if not visited yet.
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				dfs(i, adjacencyList);
				// ii) track the lastly visited node, where we did DFS.
				// (If at all there is a mother vertex, it will be last one{we can't have
				// unvisited node, if any previous nodes were a mother} Else there won't be any)
				last_visited = i;
			}
		}

		if (last_visited == -1)
			return -1;
		// iii) renew visited array
		visited = new int[n];
		// iv) do DFS with last_visited, to find if last_visited is capable to be mother
		// vertex.
		dfs(last_visited, adjacencyList);
		for (int i = 0; i < n; i++) {
			if (visited[i] != 1)
				return -1;
		}
		return last_visited;
	}

	static void dfs(int vertex, ArrayList<ArrayList<Integer>> adjacencyList) {
		visited[vertex] = 1;
		for (int i = 0; i < adjacencyList.get(vertex).size(); i++) {
			int current_vertex = adjacencyList.get(vertex).get(i);
			if (visited[current_vertex] != 1)
				dfs(current_vertex, adjacencyList);
		}
	}
}