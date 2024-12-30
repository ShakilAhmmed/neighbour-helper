package neighbourhelper.datastructure;

public class Tree {

	private class TreeNode implements Comparable {
		private Comparable value;
		private TreeNode leftNode;
		private TreeNode rightNode;

		public TreeNode(Comparable v) {
			value = v;
			leftNode = null;
			rightNode = null;
		}

		public TreeNode(Comparable v, TreeNode left, TreeNode right) {
			value = v;
			leftNode = left;
			rightNode = right;
		}

		public TreeNode getLeftTree() {
			return leftNode;
		}

		public TreeNode getRightTree() {
			return rightNode;
		}

		public Comparable getValue() {
			return value;
		}

		public int compareTo(Object o) {
			return value.compareTo(((TreeNode) o).value);
		}
	}

	// the root of our tree
	private TreeNode root;

	public Tree() {
		root = null;
	}

	public void insert(Comparable element) {
		this.insertAtNode(element, root, null);
	}

	private void insertAtNode(Comparable element, TreeNode current, TreeNode parent) {
		// if the node we check is empty
		if (current == null) {
			TreeNode newNode = new TreeNode(element);
			// the current node is empty , but we have a parent
			if (parent != null) {
				// do we add it to the left ?
				if (element.compareTo(parent.value) < 0) {
					parent.leftNode = newNode;
				}
				// or do we add it to the right ?
				else {
					parent.rightNode = newNode;
				}
			}
			// the current node is empty and it has no parent ,
			// we actually have an empty tree
			else {
				root = newNode;
			}

		} else if (element.compareTo(current.value) == 0) {
			// if the element is already in the tree ,
			// what do we do ?
			// at this point , we don ’t care
		}
		// if the element is smaller than current , go left
		else if (element.compareTo(current.value) < 0) {
			this.insertAtNode(element, current.getLeftTree(), current);
		}
		// if the element is bigger than current , go right
		else {
			this.insertAtNode(element, current.getRightTree(), current);
		}

	}

	public boolean find(Comparable element) {
		return this.findInNode(element, root);
	}

	private boolean findInNode(Comparable element, TreeNode current) {
		// If the current node is null, the element is not in the tree
		if (current == null) {
			return false;
		}
		// If the current node's value matches the element, we found it
		if (element.compareTo(current.value) == 0) {
			return true;
		}
		// If the element is smaller, search in the left subtree
		else if (element.compareTo(current.value) < 0) {
			return findInNode(element, current.getLeftTree());
		}
		// If the element is larger, search in the right subtree
		else {
			return findInNode(element, current.getRightTree());
		}
	}
}
