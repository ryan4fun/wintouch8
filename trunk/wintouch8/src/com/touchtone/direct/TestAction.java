package com.touchtone.direct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.softwarementors.extjs.djn.config.annotations.DirectMethod;

public class TestAction {
	@DirectMethod
	public DataStore getGrid(Map params) {
		
		DataStore store = new DataStore();
		
		List<Map<String, String>> records = new ArrayList<Map<String, String>>();
		
		Map<String, String> record1 = new HashMap<String, String>();
		record1.put("name", "Yuanyuan");
		record1.put("turnover", "123");
		records.add(record1);
		
		Map<String, String> record2 = new HashMap<String, String>();
		record2.put("name", "Leon");
		record2.put("turnover", "456");
		records.add(record2);
		
		Map<String, String> record3 = new HashMap<String, String>();
		record3.put("name", "Naya");
		record3.put("turnover", "789");
		records.add(record3);
		
		store.setTotalCount(records.size());
		store.setRecords(records);
		return store;
	}
}
