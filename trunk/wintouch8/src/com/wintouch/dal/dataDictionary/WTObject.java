package com.wintouch.dal.dataDictionary;

import java.util.ArrayList;
import java.util.List;

public class WTObject {
	
	private long id;
	private String name;
	private String tableName;
	private String description;
	private List<WTAttribute> attList = new ArrayList<WTAttribute>();
	private List<WTRelationship> relationList = new ArrayList<WTRelationship>();
	
	public WTObject(){
		
	}
	
	public void addAttribute(WTAttribute att){
		
		if(att != null){
			this.attList.add(att);
		}
	}
	
	public List<WTAttribute> getAttributeList(){
		
		return this.attList;
	}
	
	public void removeAttribute(WTAttribute att){
	
		if(att != null) {
			int index = findAttById(att.getId());
			if(index >= 0){
				this.attList.remove(index);
			}
		}
	}
	
	private int findAttById(long id) {
		
		WTAttribute tempAtt = null;
		for(int i = 0; i<this.attList.size();i++ ){
			
			tempAtt = this.attList.get(i);
			if(tempAtt.getId() == id){
				
				return i;
			}
		}
		
		return -1;
	}

	public void addRelationship(WTRelationship relation){
		
		if(relation != null){
			this.relationList.add(relation);
		}
	}
	
	public List<WTRelationship> getRelationshipList(){
		
		return this.relationList;
	}
	
	public void removeAttribute(WTRelationship relation){
	
		if(relation != null) {
			int index = findRelationshipById(relation.getId());
			if(index >= 0){
				this.relationList.remove(index);
			}
		}
	}

	
	private int findRelationshipById(long id) {
		
		WTRelationship tempRelation = null;
		for(int i = 0; i<this.relationList.size();i++ ){
			
			tempRelation = this.relationList.get(i);
			if(tempRelation.getId() == id){			
				return i;
			}
		}
		
		return -1;
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
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	
	
	
	

}
