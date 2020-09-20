package graphs;

public class UnitAreaGroupedOnes {
	/*
	 * https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-
	 * 1587115620/1/?track=DSASP-Graph&batchId=145
	 * https://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/
	 * SIZE: declared globally for matrix definition N, M: row and column of matrix
	 * A[][]: 2D matrix from input
	 */
	static int result, count;
	static int[][] visited;

	static int findMaxArea(int N, int M, int A[][]) {
		// Need to find the maximum grouped 1s in any direction
		result = 1;
		count = 0;
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] != 1) {
					dfs(i, j, A, N, M);
					if (count > 1)
						result = Math.max(result, count);
					count = 0;
				}
			}
		}
		return result;
	}

	private static void dfs(int i, int j, int[][] adjacentMatrix, int n, int m) {
		if (visited[i][j] == 1 || adjacentMatrix[i][j] != 1) {
			visited[i][j] = 1;
			return;
		}
		visited[i][j] = 1;
		count += 1;
		// above row possible paths
		if (isValid(i - 1, j - 1, n, m))
			dfs(i - 1, j - 1, adjacentMatrix, n, m);
		if (isValid(i - 1, j, n, m))
			dfs(i - 1, j, adjacentMatrix, n, m);
		if (isValid(i - 1, j + 1, n, m))
			dfs(i - 1, j + 1, adjacentMatrix, n, m);
		// same row possible paths
		if (isValid(i, j - 1, n, m))
			dfs(i, j - 1, adjacentMatrix, n, m);
		if (isValid(i, j + 1, n, m))
			dfs(i, j + 1, adjacentMatrix, n, m);
		// below row possible paths
		if (isValid(i + 1, j - 1, n, m))
			dfs(i + 1, j - 1, adjacentMatrix, n, m);
		if (isValid(i + 1, j, n, m))
			dfs(i + 1, j, adjacentMatrix, n, m);
		if (isValid(i + 1, j + 1, n, m))
			dfs(i + 1, j + 1, adjacentMatrix, n, m);
	}

	private static boolean isValid(int i, int j, int n, int m) {
		if (i < 0 || j < 0 || i >= n || j >= m)
			return false;
		return true;
	}

}
