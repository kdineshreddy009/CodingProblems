package graphs;

import java.util.ArrayList;

/*
https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/?track=SPC-Graph&batchId=145

Detect cycle in an undirected graph 
Given a Undirected Graph. Check whether it contains a cycle or not. 

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' testcases follow. Each testcase consists of two lines. Description of testcases are as follows: The First line of each testcase contains two integers 'N' and 'M' which denotes the no of vertices and no of edges respectively. The Second line of each test case contains 'M'  space separated pairs u and v denoting that there is a bidirectional  edge from u to v .

Output:
The method should return 1 if there is a cycle else it should return 0.

User task:
You don't need to read input or print anything. Your task is to complete the function isCyclic which takes the Graph and the number of vertices as inputs and returns true if the given undirected graph contains any cycle. Else, it returns false.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

Constraints:
1 <= T <= 100
2 <= N <= 104
1 <= M <= (N*(N-1))/2
0 <= u, v <=  N-1
Graph doesn't contain multiple edges and self loops.

Example:
Input:
3
2 1
0 1
4 3
0 1 1 2 2 3
5 4
0 1 2 3 3 4 4 2

Output:
0
0
1
*/
public class DetectCycleUndirected {
	static boolean isCyclePresent;
	static int[] vis;

	static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V) {
		isCyclePresent = false;
		vis = new int[g.size()];
		for (int i = 0; i < g.size(); i++) {
			if (vis[i] != 1) {
				vis[i] = 1;
				dfs(g, i, -1);
			}
			if (isCyclePresent)
				break;
		}
		return isCyclePresent;
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adjacencyList, int vertex, Integer parent) {
		for (int i = 0; i < adjacencyList.get(vertex).size(); i++) {
			int cur = adjacencyList.get(vertex).get(i);
			if (vis[cur] == 1 && cur != parent) {
				isCyclePresent = true;
				break;
			}
			if (vis[cur] != 1) {
				vis[cur] = 1;
				dfs(adjacencyList, cur, vertex);
			}
		}
	}
}
