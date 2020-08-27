/*
https://practice.geeksforgeeks.org/problems/topological-sort/1/?track=DSASP-Graph&batchId=145

Topological sort: 
Given a Directed Graph. Find any Topological Sorting of that Graph.

Input:
The first line of input takes the number of test cases then T test cases follow . Each test case contains two lines. The first  line of each test case  contains two integers E and V representing no of edges and the number of vertices. Then in the next line are E  pairs of integers u, v representing an edge from u to v in the graph.

Output:
For each test case output will be 1 if the topological sort is done correctly else it will be 0.

Your Task:
You don't need to read input or print anything. Your task is to complete the function topoSort() which takes the adjacency list of the Graph and the number of vertices (N) as inputs are returns an array consisting of a the vertices in Topological order. As there are multiple Topological orders possible, you may return any of them.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

Constraints:
1 <= T <= 100
2 <= V <= 104
1 <= E <= (N*(N-1))/2
0 <= u, v <= N-1
Graph doesn't contain multiple edges, self loops and cycles.
Graph may be disconnected.

Example:
Input
2
6 6
5 0 5 2 2 3 4 0 4 1 1 3
3 4
3 0 1 0 2 0

Output:
1
1

Explanation:
Testcase 1: The output 1 denotes that the order is valid.  So, if you have implemented your function correctly, then output would be 1 for all test cases.
*/
package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
	static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
		
		int[] inDegree = new int[N];
		int[] result = new int[N];
		
		// count the in degrees looping all vertices
		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				int vertex = adj.get(i).get(j);
				inDegree[vertex] = inDegree[vertex] + 1;
			}
		}

		Queue<Integer> q = new LinkedList<>();

		// Get all nodes with In-degree = 0 into Queue
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}

		int k = 0;
		while (!q.isEmpty()) {
			result[k] = q.poll();
			int cur_vertex = result[k];
			k++;
			// Keep decrementing the in-degrees as we visit
			for (int i = 0; i < adj.get(cur_vertex).size(); i++) {
				int ind_vertex = adj.get(cur_vertex).get(i);
				inDegree[ind_vertex] = inDegree[ind_vertex] - 1;
				if (inDegree[ind_vertex] == 0) {
					q.add(ind_vertex);
				}
			}
		}
		return result;
	}
}
