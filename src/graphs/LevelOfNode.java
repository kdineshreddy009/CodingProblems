package graphs;

// https://www.geeksforgeeks.org/level-node-tree-source-node-using-bfs/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOfNode {
	static int[] visited;
	static int[] isAdded;
	static int resultLevel;
	/*
	ArrayList<ArrayList<Integer>> list: to represent graph containing vertices
	                                    and edges between them
	x: starting vertex of graph
	in: represent vertex whose level we have to find
	*/
	static int levels(ArrayList<ArrayList<Integer>> list, int x, int in) {
		resultLevel = 0;
		visited = new int[list.size()];
		isAdded = new int[list.size()];
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		int cur_cnt = 1;
		int cnt = 0;
		while (!q.isEmpty()) {
			int cur_vertex = q.poll();
			if (cur_vertex == in)
				return resultLevel;
			visited[cur_vertex] = 1;
			for (int i = 0; i < list.get(cur_vertex).size(); i++) {
				int new_vertex = list.get(cur_vertex).get(i);
				if (visited[new_vertex] == 0 && isAdded[new_vertex] == 0) {
					q.add(new_vertex);
					isAdded[new_vertex] = 1;
					cnt++;
				}
			}
			cur_cnt--;
			if (cur_cnt == 0) {
				resultLevel++;
				cur_cnt = cnt;
				cnt = 0;
			}
		}
		return -1;
	}
}
