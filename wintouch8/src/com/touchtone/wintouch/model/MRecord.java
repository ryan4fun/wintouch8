package com.touchtone.wintouch.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xingwei.wu
 *
 */
public class MRecord {
	private final List<String> values;
	
	/**
	 * 
	 */
	public MRecord(){
		this.values = new ArrayList<String>();
	}
	
	/**
	 * 
	 * @param value
	 */
	public void addValue(String value){
		this.values.add(value);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getValues(){
		return this.values;
	}
}
