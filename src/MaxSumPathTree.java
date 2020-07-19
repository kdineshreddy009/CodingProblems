// https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/
//  Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}

public class MaxSumPathTree {
	static int maxSoFar;

	public int maxPathSum(TreeNode A) {
		maxSoFar = Integer.MIN_VALUE;
		maxPath(A);
		return maxSoFar;
	}

	private int maxPath(TreeNode A) {
		if (A == null) {
			return 0;
		}
		int l = maxPath(A.left);
		int r = maxPath(A.right);
//		At each node store the max path from i) root+left ii) root+right iii)root+left+right
		maxSoFar = Math.max(maxSoFar, Math.max(Math.max(A.val, A.val + l), Math.max(A.val + r, A.val + l + r)));
//		At each node return max path value to its parent; Root+(left path  Or right path Or nothing)		
		return Math.max(A.val, Math.max(A.val + r, A.val + l));
	}
}
