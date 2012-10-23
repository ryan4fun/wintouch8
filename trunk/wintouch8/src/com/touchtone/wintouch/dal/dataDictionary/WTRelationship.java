package com.touchtone.wintouch.dal.dataDictionary;

public class WTRelationship {

	
	public final static int RELATION_TYPE_ONE_TO_MANY = 1;
	public final static int RELATION_TYPE_ONE_TO_ONE = 2;
	public final static int RELATION_TYPE_MANY_TO_ONE = 4;
	public final static int RELATION_TYPE_MANY_TO_MANY = 8;
	
	private long id;
	private String name;
	private String description;
	private WTObject srcObject;
	private WTObject destObject;
//	private int srcMultiplicity;
//	private int destMultiplicity;
	private int relationshipType;
	
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
	
//	public int getSrcMultiplicity() {
//		return srcMultiplicity;
//	}
//	
//	public void setSrcMultiplicity(int srcMultiplicity) {
//		this.srcMultiplicity = srcMultiplicity;
//	}
//	
//	public int getDestMultiplicity() {
//		return destMultiplicity;
//	}
//	
//	public void setDestMultiplicity(int destMultiplicity) {
//		this.destMultiplicity = destMultiplicity;
//	}
	
	public void setRelationshipType(int type){
		
		this.relationshipType = type;
	}
	
	public int getRelationshipType(){
		
		return relationshipType;
	}
	
}
