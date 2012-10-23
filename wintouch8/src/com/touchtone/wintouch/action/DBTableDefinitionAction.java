package com.touchtone.wintouch.action;

import java.util.ArrayList;
import java.util.List;

import com.touchtone.wintouch.dal.dataDictionary.WTAttribute;
import com.touchtone.wintouch.dal.dataDictionary.WTObject;
import com.touchtone.wintouch.dal.dataDictionary.WTRelationship;
import com.touchtone.wintouch.model.MDBColumnDefinition;
import com.touchtone.wintouch.model.MDBTableDefinition;

/**
 * Action to handle DB table
 * @author xingwei.wu
 *
 */
public class DBTableDefinitionAction extends WAction{
	
	/**
	 * 
	 * @return
	 */
	public List<String> getDBTables(){
		
		List<WTObject> wtObjects = super.getDalService().getDictionaryMetadata();
		
		List<String> ret = new ArrayList<String>(wtObjects.size());
		
		for(WTObject o:wtObjects){
			ret.add(o.getName());
		}
		return ret;
	}
	
	/**
	 * 
	 */
	public boolean createDBTable(String name,String description){
		WTObject dbtable = new WTObject();
		dbtable.setName(name);
		dbtable.setDescription(description);
		return super.getDalService().createTable(dbtable);
	}
	
	/**
	 * 
	 * @param name
	 */
	public MDBTableDefinition getDBTable(String name){
		WTObject wtObject = super.getDalService().getWTObjectByName(name);
		
		MDBTableDefinition ret = null;
		
		if(wtObject!=null){
			ret = new MDBTableDefinition(wtObject.getName(),wtObject.getDescription());
			List<WTAttribute> as = wtObject.getAttributeList();
			
			for(WTAttribute att:as){
				MDBColumnDefinition column = new MDBColumnDefinition(att.getColumnName(),att.getDescription(),att.getDataType());
				ret.addColumn(column);
			}
		}
		return ret;
	}
	
	/**
	 * 
	 * @param name
	 * @param description
	 * @return
	 */
	public boolean editDBTable(String name, String newDescription){
		WTObject wtObject = super.getDalService().getWTObjectByName(name);
		if(wtObject!=null){
			wtObject.setDescription(newDescription);
			return super.getDalService().alterTable(wtObject);
		}
		return false;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean deleteDBTable(String name){
		WTObject wtObject = super.getDalService().getWTObjectByName(name);
		
		if(wtObject!=null){
			return super.getDalService().dropTable(wtObject);
		}
		return true;
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean createDBTableRelationship(String srcTableName,String destTableName,String name,String description,int relationshipType){
		WTObject scrWTTable = super.getDalService().getWTObjectByName(srcTableName);
		WTObject destWTTable = super.getDalService().getWTObjectByName(destTableName);
		
		if(scrWTTable!=null&&destWTTable!=null){
			WTRelationship relationship = new WTRelationship();	
			relationship.setName(name);
			relationship.setDescription(description);
			relationship.setRelationshipType(relationshipType);
			relationship.setDestObject(destWTTable);
			scrWTTable.addRelationship(relationship);
			return super.getDalService().alterTable(scrWTTable);
		}
		return false;
	}
	
	/**
	 * 
	 * @param scrTable
	 * @param name
	 * @param description
	 * @param relationshipType
	 * @return
	 */
	public boolean editDBTableRelationship(String scrTableName,String name,String description,int relationshipType){
		WTObject scrWTTable = super.getDalService().getWTObjectByName(scrTableName);
		if(scrWTTable!=null){
			WTRelationship relationship = findRelationship(scrWTTable,name);
			if(relationship!=null){
				relationship.setDescription(description);
				relationship.setRelationshipType(relationshipType);
				return super.getDalService().alterTable(scrWTTable);
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param scrTableName
	 * @param name
	 * @return
	 */
	public boolean deleteDBTableRelationship(String scrTableName,String name){
		WTObject scrWTTable = super.getDalService().getWTObjectByName(scrTableName);
		if(scrWTTable!=null){
			WTRelationship relationship = findRelationship(scrWTTable,name);
			if(relationship!=null){
				scrWTTable.removeRelationship(relationship);
				return super.getDalService().alterTable(scrWTTable);
			}
		}
		return false;
	}
	
	//-----------------
	/**
	 * 
	 * @param wtObject
	 * @param relationshipName
	 * @return
	 */
	private WTRelationship findRelationship(WTObject wtObject,String relationshipName){
		List<WTRelationship> relationships = wtObject.getRelationshipList();
		
		for(WTRelationship relation:relationships){
			if(relation.getName().equals(relationshipName)){
				return relation;
			}
		}
		return null;
	}
}
