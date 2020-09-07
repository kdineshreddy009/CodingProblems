package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1/?track=DSASP-Graph&batchId=145
 * https://www.geeksforgeeks.org/distance-nearest-cell-1-binary-matrix/
 */
public class DistanceNearestCell {
/*
 * Function to find the distance of nearest cell having 1 mat: The input matrix
 * of 0s and 1s N, M: rows and cols in given matrix Return the resultant matrix
 * of size (N x M) representing the nearest distance 1 from each cell
 */
	static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int N, int M) {
		Queue<String> q = new LinkedList<>();
// 1.we will be doing BFS at each node(starts with node having 1s)
// 2.Then continue on newly formed nodes by pushing into queue
// 3.we will separate each level of BFS with a delimiter
		for (int i = 0; i < mat.size(); i++) {
			for (int j = 0; j < mat.get(0).size(); j++) {
				if (mat.get(i).get(j) == 1)
					q.add(i + "-" + j);
			}
		}
		
		q.add("delimiter");
		int dist = 0;
		int row_size = mat.size();
		int col_size = mat.get(0).size();
		while (!q.isEmpty()) {
			int row = Integer.valueOf(q.peek().split("-")[0]);
			int col = Integer.valueOf(q.peek().split("-")[1]);
			q.poll();
			int cur = dist + mat.get(row).get(col);
			
// checking four sides of a cell for 0s
			if (row - 1 >= 0) {
				if (mat.get(row - 1).get(col) == 0) {
					mat.get(row - 1).set(col, cur);
					q.add((row - 1) + "-" + col);
				}
			}

			if (row + 1 < row_size) {
				if (mat.get(row + 1).get(col) == 0) {
					mat.get(row + 1).set(col, cur);
					q.add((row + 1) + "-" + col);
				}
			}

			if (col - 1 >= 0) {
				if (mat.get(row).get(col - 1) == 0) {
					mat.get(row).set(col - 1, cur);
					q.add((row) + "-" + (col - 1));
				}
			}
			if (col + 1 < col_size) {
				if (mat.get(row).get(col + 1) == 0) {
					mat.get(row).set(col + 1, cur);
					q.add((row) + "-" + (col + 1));
				}
			}
			
// Mark given 1s as 0s, to turn them off at end as dist=0 for them  
			if (dist == 0) {
				mat.get(row).set(col, -1);
			}
// we will complete level in BFS & reach a delimiter, so check & append delimiter for next level at end  
			if (q.peek() == "delimiter") {
				q.poll();
				if (!q.isEmpty()) {
					q.add("delimiter");
					if (dist == 0)
						dist = dist + 1;
				}
			}
		}
// turn real 1s to 0s
		for (int i = 0; i < mat.size(); i++) {
			for (int j = 0; j < mat.get(0).size(); j++) {
				if (mat.get(i).get(j) == -1)
					mat.get(i).set(j, 0);
			}
		}
		return mat;
	}
}
