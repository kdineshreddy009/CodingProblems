package graphs;

import java.util.ArrayList;

/*
https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1/?track=SPC-Graph&batchId=145

BFS solution - https://www.geeksforgeeks.org/islands-in-a-graph-using-bfs/

Find the number of islands 
Given a Matrix consisting of 0s and 1s. Find the number of islands of connected 1s present in the matrix. 
Note: A 1 is said to be connected if it has another 1 around it (either of the 8 directions).

Input:
The first line of input will be the number of testcases T, then T test cases follow. The first line of each testcase contains two space separated integers N and M. Then in the next line are the NxM inputs of the matrix A separated by space .

Output:
For each testcase in a new line, print the number of islands present.

Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(N*M).

Constraints:
1 <= T <= 100
1 <= N, M <= 100
0 <= A[i][j] <= 1

Example(To be used only for expected output) :
Input
2
3 3
1 1 0 0 0 1 1 0 1
4 4
1 1 0 0 0 0 1 0 0 0 0 1 0 1 0 0

Output
2
2

Explanation:
Testcase 1: The graph will look like
1 1 0
0 0 1
1 0 1
Here, two islands will be formed
First island will be formed by elements {A[0][0] ,  A[0][1], A[1][2], A[2][2]}
Second island will be formed by {A[2][0]}.
Testcase 2: The graph will look like
1 1 0 0
0 0 1 0
0 0 0 1
0 1 0 0
Here, two islands will be formed
First island will be formed by elements {A[0][0] ,  A[0][1], A[1][2], A[2][3]}
Second island will be formed by {A[3][1]}.

*/
public class NumberOfIslandsUsingDfs {
	static int[][] visited;
	// Function to find the number of island in the given list A
	// N, M: size of list row and column respectively
	//	A: is adjacent matrix representation
	static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {
		visited = new int[N][M];
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (A.get(r).get(c) == 1 && visited[r][c] == 0) {
					dfs(r, c, A);
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static void dfs(int r, int c, ArrayList<ArrayList<Integer>> all) {
		visited[r][c] = 1;
		// here diagonal needs to be checked
		int[] row_range = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] col_range = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int k = 0; k < row_range.length; k++) {
			if (isContinous(r + row_range[k], c + col_range[k], all)) {
				dfs(r + row_range[k], c + col_range[k], all);
			}
		}
	}

	private static boolean isContinous(int rw, int cl, ArrayList<ArrayList<Integer>> all) {
		return rw >= 0 && cl >= 0 && rw < all.size() && cl < all.get(0).size() && all.get(rw).get(cl) == 1
				&& visited[rw][cl] != 1;
	}
}
