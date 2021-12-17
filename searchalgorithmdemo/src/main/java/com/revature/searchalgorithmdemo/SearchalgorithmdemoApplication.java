package com.revature.searchalgorithmdemo;

/**
 * code adapted from https://crunchify.com/how-to-read-json-object-from-file-in-java/ for parsing JSON objects
 * */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.searchalgorithmdemo.model.AVLTree;
import com.revature.searchalgorithmdemo.model.KeyValuePair;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Iterator;

@SpringBootApplication
public class SearchalgorithmdemoApplication {

	final static String FOUND_MESSAGE_PART_1 = "At index ";
	final static String FOUND_MESSAGE_PART_2 = " -> ";
	
	public static void main(String[] args) {
		SpringApplication.run(SearchalgorithmdemoApplication.class, args);
		int min = 1;
		int max = 26;
		int runs = 5;
		int myKey = 0; // will be used to hold the number being searched for
		
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:\\Users\\anjali\\Documents\\GitHub\\Search-Algorithm-Demo\\searchalgorithmdemo\\src\\main\\resources\\searchData.json"));
 
			// A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
			//JSONObject jsonObject = (JSONObject) obj;
 
			// A JSON array. JSONObject supports java.util.List interface.
			JSONArray keyValueList = (JSONArray) obj;
 
			ArrayList<KeyValuePair> myList = new ArrayList<KeyValuePair>();
			
			for(int i = 0; i < keyValueList.size(); i++)
			{
				JSONObject temp = (JSONObject) keyValueList.get(i);
				myList.add(new KeyValuePair(new Integer(((Long)temp.get("key")).intValue()), (String)temp.get("value")));
			}
			System.out.println("Before Shuffle: " + myList);
			ArrayList<KeyValuePair> mySortedList = new ArrayList<KeyValuePair>(myList);
			Collections.shuffle(myList);
			System.out.println("After Shuffle: " + myList);
			AVLTree myTree = new AVLTree();
			for(int y = 0; y < myList.size(); y++)
			{
				myTree.insert(myList.get(y));
			}
			
			for(int x = 0; x < runs; x++)
			{
				myKey = (int) Math.floor(Math.random()*(max-min+1)+min);
				System.out.println("\nSearching for KeyValuePair with key " + myKey);
				try {
					// linear search for myKey in mySortedList
					System.out.print("Linear Search in a Sorted List: ");
					System.out.println(searchLinear(mySortedList, myKey));
				}
				catch (Exception e)
				{
					System.err.println(e.getMessage());
				}
				
				try {
					// linear search for myKey in myList
					System.out.print("Linear Search in an Unsorted List: ");
					System.out.println(searchLinear(myList, myKey));
				}
				catch (Exception e)
				{
					System.err.println(e.getMessage());
				}
				
				try {
					// binary search for myKey in mySortedList
					System.out.print("Binary Search in a Sorted List: ");
					System.out.println(searchBinary(mySortedList, myKey));
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
					//System.err.println(e.getMessage());
				}
				
				try {
					// binary search for myKey in myList
					System.out.print("Binary Search in an Unsorted List: ");
					System.out.println(searchBinary(myList, myKey));
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
					//System.err.println(e.getMessage());
				}
				System.out.println();
			}
			
			System.out.println("\nDisplaying AVLTree of the list:");
			System.out.println("Depth-First Search Result: " + myTree.displayDepth());
			System.out.println("Breadth-First Search Result: " + myTree.displayBreadth());
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static KeyValuePair searchLinear(ArrayList<KeyValuePair> aList, int key) throws Exception
	{
		for(int x = 0; x < aList.size(); x++)
		{
			if(aList.get(x).getKey() == key)
			{
				System.out.print(FOUND_MESSAGE_PART_1 + x + FOUND_MESSAGE_PART_2);
				return aList.get(x);
			}
		}
		throw new Exception("Key value " + key + " not found!");
	}
	
	public static KeyValuePair searchBinary(ArrayList<KeyValuePair> aList, int key) throws Exception
	{
		if(aList.isEmpty())
		{
			throw new Exception("No keys in the list!");
		}
		return searchBinary(aList, key, 0, aList.size());
	}
	
	public static KeyValuePair searchBinary(ArrayList<KeyValuePair> aList, int key, int minIndex, int maxIndex) throws Exception
	{
		//System.out.println("minIndex = " + minIndex + ", maxIndex = " + maxIndex);
		int temp = (maxIndex + minIndex) / 2;
		if(temp >= maxIndex) // meaning that we're out of bounds
		{
			throw new Exception("Key value " + key + " not found! Halfway point out of bounds!");
		}
		
		if(temp == minIndex)
		{
			if(aList.get(minIndex).getKey() == key)
			{
				System.out.print(FOUND_MESSAGE_PART_1 + minIndex + FOUND_MESSAGE_PART_2);
				return aList.get(minIndex);
			}
			else
			{
				throw new Exception("Key value " + key + " not found!");
			}
		}
		
		KeyValuePair tempPair = aList.get(temp);
		int tempKey = tempPair.getKey();
		//System.out.println("temp = " + temp + ", tempPair = " + tempPair + ", tempKey = " + tempKey);
		if(key == tempKey)
		{
			System.out.print(FOUND_MESSAGE_PART_1 + temp + FOUND_MESSAGE_PART_2);
			return tempPair;
		}
		else
		{
			if(key < tempKey) // meaning that we're looking for something smaller than what we found.
			{
				return searchBinary(aList, key, minIndex, temp);
			}
			else
			{
				return searchBinary(aList, key, temp, maxIndex);
			}
		}
	}
}
