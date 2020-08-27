package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

	TreeMap<Integer, ArrayList<Integer>> tm;

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		tm = new TreeMap<Integer, ArrayList<Integer>>();
		Queue<Integer> flags = new LinkedList();
		Queue<TreeNode> que = new LinkedList();
		que.add(root);
		flags.add(0);
		ArrayList<Integer> al = new ArrayList();
		al.add(root.val);
		tm.put(0, al);

		while (!que.isEmpty()) {
			TreeNode cur = que.poll();
			int flag = flags.poll();
			if (cur.left != null) {
				al = tm.getOrDefault(flag - 1, new ArrayList());
				al.add(cur.left.val);
				tm.put(flag - 1, al);
				que.add(cur.left);
				flags.add(flag - 1);
			}

			if (cur.right != null) {
				al = tm.getOrDefault(flag + 1, new ArrayList());
				al.add(cur.right.val);
				tm.put(flag + 1, al);
				que.add(cur.right);
				flags.add(flag + 1);
			}
		}
		List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (Map.Entry<Integer, ArrayList<Integer>> entry : tm.entrySet()) {
			res.add(entry.getValue());
		}
		return (List) res;
	}

	private void fillFlagstraversal(TreeNode root, int flag) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (tm.containsKey(flag)) {
			al = tm.get(flag);
			al.add(root.val);
			tm.put(flag, al);
		} else {
			al.add(root.val);
			tm.put(flag, al);
		}
		if (root.left != null) {
			fillFlagstraversal(root.left, flag - 1);
		}
		if (root.right != null) {
			fillFlagstraversal(root.right, flag + 1);
		}
	}
}
