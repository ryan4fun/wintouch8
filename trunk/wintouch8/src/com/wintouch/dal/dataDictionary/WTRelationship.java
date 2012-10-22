package com.wintouch.dal.dataDictionary;

public class WTRelationship {

	private long id;
	private String name;
	private String description;
	private WTObject srcObject;
	private WTObject destObject;
	private int srcMultiplicity;
	private int destMultiplicity;
	
	public WTRelationship(){
		
	}
	
	
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public WTObject getSrcObject() {
		return srcObject;
	}
	
	public void setSrcObject(WTObject srcObject) {
		this.srcObject = srcObject;
	}
	
	public WTObject getDestObject() {
		return destObject;
	}
	
	public void setDestObject(WTObject destObject) {
		this.destObject = destObject;
	}
	
	public int getSrcMultiplicity() {
		return srcMultiplicity;
	}
	
	public void setSrcMultiplicity(int srcMultiplicity) {
		this.srcMultiplicity = srcMultiplicity;
	}
	
	public int getDestMultiplicity() {
		return destMultiplicity;
	}
	
	public void setDestMultiplicity(int destMultiplicity) {
		this.destMultiplicity = destMultiplicity;
	}
	
	
}
