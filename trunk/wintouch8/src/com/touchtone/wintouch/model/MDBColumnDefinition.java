package com.touchtone.wintouch.model;

/**
 * 
 * @author xingwei.wu
 *
 */
public class MDBColumnDefinition {
	private final String name;
	private final String type;
	private final String description;
	
	/**
	 * 
	 * @param name
	 * @param type
	 */
	public MDBColumnDefinition(String name,String description,String type){
		this.name = name;
		this.description = description;
		this.type = type;
	}

	public String getName() {
		return name;
	}
	
	

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}
	
	
}
