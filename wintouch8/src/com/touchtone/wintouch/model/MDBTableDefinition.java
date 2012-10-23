package com.touchtone.wintouch.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xingwei.wu
 *
 */
public class MDBTableDefinition {
	/**
	 * 
	 */
	private final List<MDBColumnDefinition> columns;
	
	/**
	 * 
	 */
	private final String name;
	
	/**
	 * 
	 */
	private final String description;
	
	/**
	 * 
	 */
	public MDBTableDefinition(String name,String description){
		this.columns = new ArrayList<MDBColumnDefinition>();
		this.name = name;
		this.description = description;
	}
	
	/**
	 * 
	 * @param columnName
	 */
	public void addColumn(MDBColumnDefinition column){
		this.columns.add(column);
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return
	 */
	public int getColumnNumber(){
		return this.columns.size();
	}
	
	/**
	 * 
	 * @param columnIndex
	 * @return
	 */
	public MDBColumnDefinition getColumn(int columnIndex){
		return this.columns.get(columnIndex);
	}
}
