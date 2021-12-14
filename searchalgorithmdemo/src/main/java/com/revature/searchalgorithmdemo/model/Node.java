/**
 *  Code derived from: https://www.baeldung.com/java-avl-trees
 */
package com.revature.searchalgorithmdemo.model;

/**
 * @author Dipanjali Ghosh
 *
 */
public class Node {
    int key;
    int height;
    String value;
    Node left;
    Node right;
	
    
    /**
	 * Empty Constructor
	 */
	public Node() {
		super();
		this.left = null;
		this.right = null;
	}

	/**
	 * @param key
	 * @param value
	 */
	public Node(int key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * @param key
	 * @param height
	 * @param value
	 */
	public Node(int key, int height, String value) {
		super();
		this.key = key;
		this.height = height;
		this.value = value;
	}


	/**
	 * @param key
	 * @param height
	 * @param value
	 * @param left
	 * @param right
	 */
	public Node(int key, int height, String value, Node left, Node right) {
		super();
		this.key = key;
		this.height = height;
		this.value = value;
		this.left = left;
		this.right = right;
	}


	/**
	 * @return the key
	 */
	public int getKey() {
		return key;
	}


	/**
	 * @param key the key to set
	 */
	public void setKey(int key) {
		this.key = key;
	}


	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}


	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}


	/**
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}


	/**
	 * @param left the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}


	/**
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}


	/**
	 * @param right the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}
    
    
}
