package com.touchtone.action;

import java.util.List;
import java.util.Map;

public class DataStore {
	private int totalCount = 0;
	private int total = 0;
	
	private List<Map<String, String>> records = null;
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.total = totalCount;
	}
	public List<Map<String, String>> getRecords() {
		return records;
	}
	public void setRecords(List<Map<String, String>> records) {
		this.records = records;
	}	   
}
