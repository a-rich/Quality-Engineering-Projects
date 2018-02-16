
/*
 * Title: Java Program to Implement Binary Tree
 * Author: Manish Bhojasia
 * Availability: http://www.sanfoundry.com/java-program-implement-binary-tree/
 *
 * Run tests:
 *     Compile: `javac BTNode.java BinaryTree.java TestDriver.java`
 *     Run: `java -ea TestDriver`
 *
 * Run mutation tests:
 *     Compile: `javac BTNode_mutation.java BinaryTree_mutation.java TestDriver.java`
 *     Run: `java -ea TestDriver`
 */


/* Class used as a test driver for this binary tree program. */
public class TestDriver {

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
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            assert node.data == 0 : "BTNODE DATA is not 0";
        } catch (AssertionError e) {
            System.out.println(e);
        } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            assert node.data == val :
                    "BTNODE DATA was not initialized to " + val;
        } catch (AssertionError e) {
            System.out.println(e);
        } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            assert node.getLeft().getData() == val :
                    "LEFT child's DATA value was not set properly to " + val;
        } catch (AssertionError e) {
            System.out.println(e);
        } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            assert node.getRight().getData() == val :
                    "RIGHT child's DATA value was not set properly to " + val;
        } catch (AssertionError e) {
            System.out.println(e);
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println(e);
        }
        tree.insert(node.getData());
        try {
            assert tree.isEmpty() == false :
                    "BT is empty when it should not be empty";
        } catch (AssertionError e) {
            System.out.println(e);
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            System.out.println(e);
        }
	}
}
