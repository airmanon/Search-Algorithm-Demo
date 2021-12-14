/**
 *  Code derived from: https://www.baeldung.com/java-avl-trees
 *  
 *  We are using an AVL Tree to help demonstrate Search Algorithms
 */
package com.revature.searchalgorithmdemo.model;

/**
 * @author Dipanjali Ghosh
 *
 */
public class AVLTree {

    private Node root;

    /**
	 * Empty Constructor
	 */
	public AVLTree() {
		super();
		this.root = null;
	}

	/**
	 * @param root
	 */
	public AVLTree(Node root) {
		super();
		this.root = root;
	}

	void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    int height(Node n) {
        return n == null ? -1 : n.height;
    }

    int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

	/**
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

	@Override
	public String toString() {
		return "AVLTree [root=" + root + "]";
	}

	/**
	 * @param y the root of the tree to rotate right
	 * @return the root of the rotated tree
	 * */
	Node rotateRight(Node y) {
	    Node x = y.left;
	    Node z = x.right;
	    x.right = y;
	    y.left = z;
	    updateHeight(y);
	    updateHeight(x);
	    return x;
	}
	
	/**
	 * @param y the root of the tree to rotate left
	 * @return the root of the rotated tree
	 * */
	Node rotateLeft(Node y) {
	    Node x = y.right;
	    Node z = x.left;
	    x.left = y;
	    y.right = z;
	    updateHeight(y);
	    updateHeight(x);
	    return x;
	}
	
	/**
	 * @param z the root of the tree to re-balance
	 * @return the root of the re-balanced tree
	 * */
	Node rebalance(Node z) {
	    updateHeight(z);
	    int balance = getBalance(z);
	    if (balance > 1) {
	        if (height(z.right.right) > height(z.right.left)) {
	            z = rotateLeft(z);
	        } else {
	            z.right = rotateRight(z.right);
	            z = rotateLeft(z);
	        }
	    } else if (balance < -1) {
	        if (height(z.left.left) > height(z.left.right))
	            z = rotateRight(z);
	        else {
	            z.left = rotateLeft(z.left);
	            z = rotateRight(z);
	        }
	    }
	    return z;
	}
	
	Node insert(Node node, int key, String value) {
	    if (node == null) {
	        return new Node(key, value);
	    } else if (node.key > key) {
	        node.left = insert(node.left, key);
	    } else if (node.key < key) {
	        node.right = insert(node.right, key);
	    } else {
	        throw new RuntimeException("duplicate Key!");
	    }
	    return rebalance(node);
	}
}
