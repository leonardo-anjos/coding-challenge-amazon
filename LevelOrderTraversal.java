import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (null == root)
			return result;

		int cur = 1, next = 0;

		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		ArrayList<Integer> curLevel = new ArrayList<Integer>();

		nodes.add(root);

		while (nodes.size() > 0) {
			TreeNode node = nodes.peek();
			nodes.remove();
			cur--;

			if (null != node) {
				curLevel.add(node.val);
				nodes.add(node.left);
				nodes.add(node.right);
				next += 2;
			}

			if (0 == cur) {
				if (curLevel.size() > 0)
					result.add(curLevel);
				cur = next;
				next = 0;
				curLevel = new ArrayList<Integer>();
			}
		}
		return result;
	}
}