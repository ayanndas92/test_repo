package com.test.project;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RcbJsonTestCase {
	
	JsonReader jsonreader = new JsonReader();
	static String filepath = ".\\jsonFiles\\TeamRCB.json";
	static String key = "player";
	
	@Test
	public void verifyForeignPlayersCount() {
		
		boolean condition = false;
		int fpcount = foreignPlayersCount();
		if (fpcount == 4) {
			condition = true;
		}
		Assert.assertTrue(condition, "There are 4 foreign players");
	}
	
	@Test
	public void verifyAtleastOneWicketKeeperPresent() {
		
		boolean onewkpresent = atLeastOneWicketKeeper();
		
		Assert.assertTrue(onewkpresent, "At Least one wicket keeper is present");
		
	}
	
	public int foreignPlayersCount() {
		
		int count = 0;
		
		
		
		JSONArray playerarray = jsonreader.readJson(filepath, key);
		
		for (int i = 0; i<playerarray.size(); i++) {
			
			String country = (String)((JSONObject)playerarray.get(i)).get("country");
			if (!country.equalsIgnoreCase("India") && !country.equals(null)) {
				count++;
			}
		}
		System.out.println("count is "+count);
		
		return count;
	}
	
	public boolean atLeastOneWicketKeeper() {
		
		boolean atleastonewk = false;
		
		
		JSONArray playerarray = jsonreader.readJson(filepath, key);
		
		for (int i = 0; i<playerarray.size(); i++) {
			
			String role = (String)((JSONObject)playerarray.get(i)).get("role");
			if (role.equalsIgnoreCase("Wicket-keeper")) {
				atleastonewk = true;
				break;
			}
		}
		System.out.println("at least one wk present "+atleastonewk);
		
		return atleastonewk;
	}

}
