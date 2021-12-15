package com.revature.searchalgorithmdemo;

/**
 * code adapted from https://crunchify.com/how-to-read-json-object-from-file-in-java/ for parsing JSON objects
 * */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.searchalgorithmdemo.model.KeyValuePair;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

@SpringBootApplication
public class SearchalgorithmdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchalgorithmdemoApplication.class, args);
		int min = 1;
		int max = 26;
		
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
				keyValueList.get(i);
				//
			}
			
			System.out.println(keyValueList);
			// An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
			// Iterators differ from enumerations in two ways:
			// 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
			// 2. Method names have been improved.
//			Iterator<JSONArray> iterator = keyValueList.iterator();
//			while (iterator.hasNext()) {
//				System.out.println(iterator.next());
//				iterator.
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
