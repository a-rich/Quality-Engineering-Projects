
/*
 * Title: Java Program to Implement Binary Tree
 * Author: Manish Bhojasia
 * Availability: http://www.sanfoundry.com/java-program-implement-binary-tree/
 *
 * Compile: `javac BinaryTree.java`
 * Run: `java -ea BinaryTree`
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

/* Class used as a test driver for this binary tree program. */
public class BinaryTree {

	public static void main(String[] args) {

        /* Test cases must test the following functionalities:
         *     Class BTNode:
         *         - both constructors (1), (2)
         *         - set/get left/right children (3), (4), (5), (6)
         *         - set/get data (7), (8)
         *     Class BT:
         *         - constructor (9)
         *         - is empty (10)
         *         - insert (11)
         *         - count nodes (12)
         *         - search (13)
         *
         *  NOTE: private methods for insert, countNodes, and search are
         *  implicitly tested by testing the public versions of these methods.
         */


        /*
         * Test cases for the BTNODE class.
         */


		/*
         * Instantiating an empty BTNODE object.
         * Test cases: (1)
         */
        BTNode node = new BTNode();
        try {
            assert node.left == null && node.right == null :
                    "BTNODE children are not null";
        } catch (AssertionError e) {
            System.out.println(e);
        }
        try {
            assert node.data == 0 : "BTNODE DATA is not 0";
        } catch (AssertionError e) {
            System.out.println(e);
        }

		/*
         * Instantiating a BTNODE object with a populated DATA field.
         * Test cases: (2)
         */
        int val = 3;
        node = new BTNode(val);
        try {
            assert node.left == null && node.right == null :
                    "BTNODE children are not null";
        } catch (AssertionError e) {
            System.out.println(e);
        }
        try {
            assert node.data == val :
                    "BTNODE DATA was not initialized to " + val;
        } catch (AssertionError e) {
            System.out.println(e);
        }

        /*
         * Setting and getting the LEFT child of a BTNODE.
         * Test cases: (2), (3), (4), (8)
         */
        val = 2;
        BTNode left_child = new BTNode(val);
        node.setLeft(left_child);
        try {
            assert node.getLeft() == left_child :
                    "Parent node's LEFT child is not equal to LEFT_CHILD";
        } catch (AssertionError e) {
            System.out.println(e);
        }
        try {
            assert node.getLeft().getData() == val :
                    "LEFT child's DATA value was not set properly to " + val;
        } catch (AssertionError e) {
            System.out.println(e);
        }

        /*
         * Setting and getting the RIGHT child of a BTNODE.
         * Test cases: (2), (5), (6), (8)
         */
        val = 4;
        BTNode right_child = new BTNode(val);
        node.setRight(right_child);
        try {
            assert node.getRight() == right_child :
                    "Parent node's RIGHT child is not equal to RIGHT_CHILD";
        } catch (AssertionError e) {
            System.out.println(e);
        }
        try {
            assert node.getRight().getData() == val :
                    "RIGHT child's DATA value was not set properly to " + val;
        } catch (AssertionError e) {
            System.out.println(e);
        }

        /*
         * Setting the DATA of a BTNODE.
         * Test cases: (7), (8)
         */
        val = 1;
        int prev = node.getData();
        node.setData(val);
        try {
            assert node.getData() != prev : "BTNODE's DATA was not set properly";
        } catch (AssertionError e) {
            System.out.println(e);
        }


        /*
         * Test cases for the BT class.
         */


        /*
         * Instantiating a BT object.
         * Test cases: (9)
         */
        BT tree = new BT();
        try {
            assert tree.root == null : "ROOT of BT is not null";
        } catch (AssertionError e) {
            System.out.println(e);
        }

        /*
         * Checking if the tree is empty before and after inserting a BTNODE.
         * Test cases: (10)
         */
        try {
            assert tree.isEmpty() == true :
                    "BT is not empty when it should be empty";
        } catch (AssertionError e) {
            System.out.println(e);
        }
        tree.insert(node.getData());
        try {
            assert tree.isEmpty() == false :
                    "BT is empty when it should not be empty";
        } catch (AssertionError e) {
            System.out.println(e);
        }

        /*
         * Checking if the inserted BTNODE is present in the tree.
         * Test cases: (11), (13)
         */
        BTNode other_node = new BTNode(5);
        try {
            assert tree.search(other_node.getData()) == false :
                    "BT should not yet contain OTHER_NODE";
        } catch (AssertionError e) {
            System.out.println(e);
        }
        tree.insert(other_node.getData());
        try {
            assert tree.search(other_node.getData()) == true :
                    "BT should contain OTHER_NODE but it does not";
        } catch (AssertionError e) {
            System.out.println(e);
        }

        /*
         * Counting the number of nodes in BT.
         * Test cases: (12)
         */
        int initial_count = tree.countNodes();
        tree.insert(7);
        try {
            assert tree.countNodes() == ++initial_count :
                    "countNodes did not return the proper amount of nodes";
        } catch (AssertionError e) {
            System.out.println(e);
        }
	}
}
