
/*
 * Title: Java Program to Implement Binary Tree
 * Author: Manish Bhojasia
 * Availability: http://www.sanfoundry.com/java-program-implement-binary-tree/
 *
 * Compile: `javac BTNode.java BinaryTree.java TestDriver.java`
 * Run: `java -ea TestDriver`
 */


/* Class to implement the abstract data type binary tree. */
class BT {
	BTNode root;    // ROOT BTNODE of the binary tree

	/* Constructor that initializes this binary tree's ROOT node to null. */
	public BT() {
		root = null;
	}

	/* Method to check if tree is empty.
     *
     * @return  a boolean indicating if the tree is empty or not
     */
	public boolean isEmpty() {
		return root == null;
	}

	/* Method to insert DATA into the tree from the ROOT.
     *
     * @param  DATA  the integer to insert into this tree
     */
	public void insert(int data) {
		root = insert(root, data);
	}

	/* Method to insert data recursively.
     *
     * @param   NODE    a BTNODE instance
     * @param   DATA    the integer to insert into this tree
     * @return          the ROOT node of the subtree
     */
	private BTNode insert(BTNode node, int data) {
		if (node == null)
			node = new BTNode(data);
		else {
			if (node.getRight() == null)
				node.right = insert(node.right, data);
			else
				node.left = insert(node.left, data);
		}
		return node;
	}

	/* Method to count the number of nodes in the tree.
     *
     * @return  the integer count of the number of nodes in this tree
     */
	public int countNodes() {
		return countNodes(root);
	}

	/* Method to count number of nodes in the tree recursively.
     *
     * @param   R  the ROOT BTNODE of this subtree
     * @return     the total count of this subtree's nodes
     */
	private int countNodes(BTNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.getLeft());
			l += countNodes(r.getRight());
			return l;
		}
	}

	/* Method to search for an element.
     *
     * @param   VAL  the integer DATA value to search for in this tree
     * @return       a boolean indicating whether or not the searched for value
     *               was found
     */
	public boolean search(int val) {
		return search(root, val);
	}

	/* Method to search for an element recursively.
     *
     * @param   R    the ROOT BTNODE of this subtree
     * @param   VAL  the integer DATA value to search for
     * @return       a boolean indicating whether or not the searched for value
     *               was found
     */
	private boolean search(BTNode r, int val) {
		if (r.getData() == val)
			return true;
		if (r.getLeft() != null)
			if (search(r.getLeft(), val))
				return true;
		if (r.getRight() != null)
			if (search(r.getRight(), val))
				return true;
		return false;
	}
}
