package graphs;

/*
https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1/?track=DSASP-Graph&batchId=145
Find whether path exist 
Given a square matrix filled with 0, 1, 2, 3. Check whether there is a path possible from the source to destination. You can traverse up, down, right and left. (Check Your Task for more details).

Input:
The first line of input is an integer T denoting the no of testcases. Then T test cases follow. Each test case consists of 2 lines. The first line of each test case contains an integer N denoting the size of the square matrix. Then in the next line are N*N space-separated values of the matrix (M).

Output:
Complete isExist function and return 1 if the path exists from source to destination else return 0.

Your Task:
You don't need to read input or print anything. Your task is to complete the function is_possible() which takes a square matrix (M) and its size (N) as inputs and returns true if there's path possible from the source to destination. Else, it returns false. 
You have to start from the Source, traverse through the blank cells and reach the Destination. You can move Up, Down, Right and Left. The description of cells is as follows:

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Wall.
Note: There are only a single source and a single destination.

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N2).

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
4
3 0 0 0 0 3 3 0 0 1 0 3 0 2 3 3 
3
0 3 2 3 0 0 1 0 0

Output:
1
0

Explanation:
Testcase 1: The matrix for the above given input is:
3 0 0 0
0 3 3 0
0 1 0 3
0 2 3 3
From the matrix we can see that there exists a path from to reach destination 2 from source 1.
Testcase 2: The matrix for the above-given input is:
0 3 2
3 0 0
1 0 0
From the matrix, we can see that there does not exist any path to reach destination 2 from source 1.
*/
class Solution {

	// M : input matrix
	// m : size of the matrix
	static int[][] vis;

	public static int is_possible(int M[][], int m) {
		vis = new int[m][m];
		int x = 0, y = 0;
		int i = 0, j = 0;
		for (i = 0; i < m; i++) {
			for (j = 0; j < m; j++) {
				if (M[i][j] == 1) {
					x = i;
					y = j;
					break;
				}
			}
		}

		int res = isTherePath(x, y, vis, M);
		return res;
	}

	private static int isTherePath(int i, int j, int[][] visited, int[][] m) {

		if ((i < 0 || i >= m.length) || (j < 0 || j >= m.length) || m[i][j] == 0 || visited[i][j] == 1) {
			return 0;
		}

		if (m[i][j] == 2) {
			return 1;
		}

		visited[i][j] = 1;

		if (isTherePath(i + 1, j, visited, m) == 1) {
			return 1;
		}
		if (isTherePath(i - 1, j, visited, m) == 1) {
			return 1;
		}
		if (isTherePath(i, j + 1, visited, m) == 1) {
			return 1;
		}
		if (isTherePath(i, j - 1, visited, m) == 1) {
			return 1;
		}
		return 0;
	}
}