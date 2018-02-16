
/*
 * Title: Java Program to Implement Binary Tree
 * Author: Manish Bhojasia
 * Availability: http://www.sanfoundry.com/java-program-implement-binary-tree/
 *
 * Run tets:
 *     Compile: `javac BTNode.java BinaryTree.java TestDriver.java`
 *     Run: `java -ea TestDriver`
 *
 * Run mutation tests:
 *     Compile: `javac BTNode_mutation.java BinaryTree_mutation.java TestDriver.java`
 *     Run: `java -ea TestDriver`
 */


/*
 * Class for a binary tree's node. Contains reference IDs to the LEFT and RIGHT
 * children of this node and a class variable DATA containing an integer.
 */
class BTNode {
	BTNode left, right;   // LEFT and RIGHT BTNODE reference IDs
	int data;             // DATA value to be stored in this BTNODE

	/* Constructor that does not specify DATA upon object initialization. */
	public BTNode() {
		//left = null;
		left = new BTNode(1);
		right = null;
		//data = 0;
		data = 1;
	}

	/* Constructor that does specify DATA upon object initialization.
     *
     * @param  N  the integer DATA value to associate with this node
     */
	public BTNode(int n) {
		left = null;
		right = null;
		//data = n;
		data = n+1;
	}

	/* Method to set the LEFT child reference ID to another BTNODE.
     *
     * @param  N  the BTNODE reference ID to associate with this node's LEFT
     *            child
     */
	public void setLeft(BTNode n) {
		//left = n;
		left = new BTNode();
	}

	/* Method to set the RIGHT child reference ID to another BTNODE.
     *
     * @param  N  the BTNODE reference ID to associate with this node's RIGHT
     *            child
     */
	public void setRight(BTNode n) {
		//right = n;
		right = new BTNode();
	}

	/* Method to get the reference ID of the LEFT node.
     *
     * @return  the BTNODE referenced by the LEFT child
     */
	public BTNode getLeft() {
		//return left;
		return right;
	}

	/* Method to get the reference ID of the RIGHT node.
     *
     * @return  the BTNODE referenced by the RIGHT child
     */
	public BTNode getRight() {
		//return left;
		return right;
	}

	/* Method to set the DATA of this BTNODE.
     *
     * @param  d  the DATA to associate with this BTNODE
     */
	public void setData(int d) {
		//data = d;
		data = d+1;
	}

	/* Method to get the DATA of this BTNODE.
     *
     * @return  the integer DATA associated with this BTNODE
     */
	public int getData() {
		//return data;
		return -1;
	}
}
