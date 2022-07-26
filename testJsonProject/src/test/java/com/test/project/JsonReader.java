package com.test.project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
	
	public JSONArray readJson(String filepath, String key) {
		
		FileReader reader = null;
		try {
			reader = new FileReader(filepath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		JSONParser jsonparser = new JSONParser();
		Object obj = null;
		try {
			try {
				obj = jsonparser.parse(reader);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		JSONObject jsonobj = (JSONObject)obj;
		
		JSONArray array = (JSONArray)jsonobj.get(key);
		
		return array;
		
		}

}
