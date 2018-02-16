/*
 *  Java program to implement a binary tree
 */

import java.util.Scanner;

/*
 * Class for a binary tree's node. Contains reference IDs to the LEFT and RIGHT
 * children of this node and a class variable DATA containing an integer.
 */
class BTNode {
	BTNode left, right;   // LEFT and RIGHT BTNODE reference IDs
	int data;             // DATA value to be stored in this BTNODE

	/* Constructor that does not specify DATA upon object initialization. */
	public BTNode() {
		left = null;
		right = null;
		data = 0;
	}

	/* Constructor that does specify DATA upon object initialization.
     *
     * @param  N  the integer DATA value to associate with this node
     */
	public BTNode(int n) {
		left = null;
		right = null;
		data = n;
	}

	/* Method to set the LEFT child reference ID to another BTNODE.
     *
     * @param  N  the BTNODE reference ID to associate with this node's LEFT
     *            child
     */
	public void setLeft(BTNode n) {
		left = n;
	}

	/* Method to set the RIGHT child reference ID to another BTNODE.
     *
     * @param  N  the BTNODE reference ID to associate with this node's RIGHT
     *            child
     */
	public void setRight(BTNode n) {
		right = n;
	}

	/* Method to get the reference ID of the LEFT node.
     *
     * @return  the BTNODE referenced by the LEFT child
     */
	public BTNode getLeft() {
		return left;
	}

	/* Method to get the reference ID of the RIGHT node.
     *
     * @return  the BTNODE referenced by the RIGHT child
     */
	public BTNode getRight() {
		return right;
	}

	/* Method to set the DATA of this BTNODE.
     *
     * @param  d  the DATA to associate with this BTNODE
     */
	public void setData(int d) {
		data = d;
	}

	/* Method to get the DATA of this BTNODE.
     *
     * @return  the integer DATA associated with this BTNODE
     */
	public int getData() {
		return data;
	}
}

/* Class to implement the abstract data type binary tree. */
class BT {
	private BTNode root;    // ROOT BTNODE of the binary tree

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

	/* Method for inorder traversal of the tree. */
	public void inorder() {
		inorder(root);
	}

    /* Method for recursive inorder traversal of the tree.
     *
     * @param  R  the ROOT BTNODE of this subtree
     */
	private void inorder(BTNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.print(r.getData() + " ");
			inorder(r.getRight());
		}
	}

	/* Method for preorder traversal of the tree. */
	public void preorder() {
		preorder(root);
	}

    /* Method for recursive preorder traversal of the tree.
     *
     * @param  R  the ROOT BTNODE of this subtree
     */
	private void preorder(BTNode r) {
		if (r != null) {
			System.out.print(r.getData() + " ");
			preorder(r.getLeft());
			preorder(r.getRight());
		}
	}

	/* Method for postorder traversal of the tree. */
	public void postorder() {
		postorder(root);
	}

    /* Method for recursive postorder traversal of the tree.
     *
     * @param  R  the ROOT BTNODE of this subtree
     */
	private void postorder(BTNode r) {
		if (r != null) {
			postorder(r.getLeft());
			postorder(r.getRight());
			System.out.print(r.getData() + " ");
		}
	}
}

/* Class used as a test driver for this binary tree program. */
public class BinaryTree {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		/* Instantiating a BT object. */
		BT bt = new BT();

		/* Perform tree operations */
		System.out.println("Binary Tree Test\n");
		char ch;

		do {
			System.out.println("\nBinary Tree Operations\n");
			System.out.println("1. insert ");
			System.out.println("2. search");
			System.out.println("3. count nodes");
			System.out.println("4. check empty\n");

			int choice = scan.nextInt();
			switch (choice) {
                case 1:
                    System.out.println("\nEnter integer element to insert");
                    bt.insert(scan.nextInt());
                    break;
                case 2:
                    System.out.println("\nEnter integer element to search");
                    System.out.println("Search result : " + bt.search(scan.nextInt()));
                    break;
                case 3:
                    System.out.println("\nNodes = " + bt.countNodes());
                    break;
                case 4:
                    System.out.println("\nEmpty status = " + bt.isEmpty());
                    break;
                default:
                    System.out.println("\nWrong entry \n ");
                    break;
			}

			/* Display tree */
			System.out.print("\nPost-order: ");
			bt.postorder();
			System.out.print("\nPre-order: ");
			bt.preorder();
			System.out.print("\nIn-order: ");
			bt.inorder();

			System.out.println("\n\nDo you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}
}
