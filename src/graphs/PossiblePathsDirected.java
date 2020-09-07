package graphs;

import java.util.ArrayList;

/*
DFS:-
https://practice.geeksforgeeks.org/problems/possible-paths-between-2-vertices-1587115620/1/?track=DSASP-Graph&batchId=145
Possible paths between 2 vertices 
Given a Directed Graph. Count the total number of ways or paths that exist between two vertices in the directed graph. These paths doesn’t contain any cycle.

Input:
The first line of input contains an integer T. Then T test cases follow. Each test case contains two integers V and E. In the next line are E space separated values u,v denoting an edge from u to v. Next line contains the starting node s and the ending node e. (The vertices start from 1)

Output: For each test case print the total number of paths that exists between the starting and the ending node.

Your Task:
You don't need to read input or print anything. Your task is to complete the function countPaths() which takes the adjcency list of the graph, the source vertex (s) and the destination vertex (d) as inputs and returns the number of paths in the graph from the source vertex to the destination vertex.

Expected Time Complexity: O(V!).
Expected Auxiliary Space: O(V).

Constraints:
1 <= T <= 100
1 <= V <= 100
1 <= E <= (V*(V-1))/2
1 <= u, v, s, e <= V
Graph doesn't contain multiple edges, self loop and cycles.

Example:
Input:
1
5 7
1 2 1 3 1 5 2 4 2 5 3 5 4 3
1 5

Output:
4

Explanation:
Testcase 1 :  
   There are 4 paths from 1 to 5.
   1 -> 5
   1 -> 2 -> 5
   1 -> 3 -> 5
   1 -> 2 -> 4 -> 3 -> 5
 */
public class PossiblePathsDirected {
	static int cnt;

	static int countPaths(ArrayList<ArrayList<Integer>> g, int s, int d) {
		cnt = 0;
		dfs(g, s, d);
		return cnt;
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adjacencyList, int src_vertex, int dest_vertex) {
		if (dest_vertex == src_vertex) {
			cnt++;
			return;
		}
		for (int i = 0; i < adjacencyList.get(src_vertex).size(); i++) {
			int new_vertex = adjacencyList.get(src_vertex).get(i);
			dfs(adjacencyList, new_vertex, dest_vertex);
		}
	}
}
