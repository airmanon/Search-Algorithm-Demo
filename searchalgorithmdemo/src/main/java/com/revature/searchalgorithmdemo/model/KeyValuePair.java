/**
 * This class is mainly meant to help demonstrate the difference between linear search and binary search
 * 		while also to help demonstrate the problems of using a binary search without sorting the list.
 */
package com.revature.searchalgorithmdemo.model;

/**
 * @author Dipanjali Ghosh
 *
 */
public class KeyValuePair {
	private int key;
	private String value;
	
	/**
	 * @param key
	 * @param value
	 */
	public KeyValuePair(int key, String value) {
		super();
		this.key = key;
		this.value = value;
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
	
	@Override
	public String toString() {
		return "KeyValuePair [key=" + key + ", value=" + value + "]";
	}
}
