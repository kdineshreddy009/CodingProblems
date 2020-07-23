package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
BFS of graph: 
Given a directed graph. The task is to do Breadth First Search of this graph.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of two lines. Description of testcases is as follows: The First line of each test case contains two integers 'N' and 'E'  which denotes the no of vertices and no of edges respectively. The Second line of each test case contains 'E'  space separated pairs u and v denoting that there is a edge from u to v .

Output:
For each testcase, print the BFS of the graph starting from 0.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

Constraints:
1 <= T <= 100
2 <= N <= 104
1 <= E <= (N*(N-1))/2
Graph doesn't contain multiple edges and self loops.
 */

public class DirectedBFS {
	static ArrayList<Integer> result;

	static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
		// add your code here
		result = new ArrayList<Integer>();
		int[] visited = new int[g.size()];
		bfs(g, 0, visited);
		// Uncomment below, if you want to perform BFS for every node
		// for(int i=0;i<g.size();i++){
		// if(visited[i]!=1){
		//		bfs(g, i, visited);
		// }
		// }
		return result;
	}

	private static void bfs(ArrayList<ArrayList<Integer>> adjacencyList, int vertex, int[] isVisited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		while (!q.isEmpty()) {
			int cur_vertex = q.poll();
			if (isVisited[cur_vertex] != 1) {
				isVisited[cur_vertex] = 1;
				result.add(cur_vertex);
				for (int i = 0; i < adjacencyList.get(cur_vertex).size(); i++) {
					int element_mapped_from_cur_vertex = adjacencyList.get(cur_vertex).get(i);
					q.add(element_mapped_from_cur_vertex);
				}
			}
		}
	}
}

/*
 * Test Case: Input: 10 17 0 2 1 3 1 4 1 5 2 3 2 8 2 9 3 7 3 9 4 6 4 7 5 6 5 7 5
 * 9 6 8 7 8 7 9
 * 
 * Its Correct output is: 0 2 3 8 9 7
 */