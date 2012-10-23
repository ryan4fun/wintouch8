package com.touchtone.wintouch.action;

import java.util.List;

import com.touchtone.wintouch.dal.dataDictionary.WTAttribute;
import com.touchtone.wintouch.dal.dataDictionary.WTObject;

/**
 * 
 * @author xingwei.wu
 *
 */
public class DBColumnDefinitionAction extends WAction{
	/**
	 * 
	 * @param name
	 * @param description
	 * @param dbtype
	 */
	public boolean createDBColumn(String tableName,String name, String description, String dbtype){
		WTObject wttable = super.getDalService().getWTObjectByName(name);
		if(wttable!=null){
			WTAttribute att = new WTAttribute();
			att.setName(name);
			att.setDescription(description);
			att.setDataType(dbtype);
			wttable.addAttribute(att);
			return super.getDalService().alterTable(wttable);
		}
		return false;
	}
	
	/**
	 * 
	 * @param tableName
	 * @param columnName
	 * @param newDescription
	 * @param newDbtype
	 * @return
	 */
	public boolean editDBColumn(String tableName,String columnName,String newDescription, String newDbtype){
		WTObject wttable = super.getDalService().getWTObjectByName(tableName);
		if(wttable!=null){
			WTAttribute att = findColumn(wttable,columnName);
			
			if(att!=null){
				att.setDescription(newDescription);
				att.setDataType(newDbtype);
			}
			return super.getDalService().alterTable(wttable);
		}
		return false;
	}
	
	/**
	 * 
	 * @param tableName
	 * @param columnName
	 * @return
	 */
	public boolean deleteDBColumn(String tableName,String columnName){
		WTObject wttable = super.getDalService().getWTObjectByName(tableName);
		if(wttable!=null){
			WTAttribute att = findColumn(wttable,columnName);
			
			if(att!=null){
				wttable.removeAttribute(att);
			}
			return super.getDalService().alterTable(wttable);
		}
		return false;
	}
	
	/**
	 * 
	 * @param wtObject
	 * @param columnName
	 * @return
	 */
	private WTAttribute findColumn(WTObject wtObject,String columnName){
		List<WTAttribute> wtas = wtObject.getAttributeList();
		
		for(WTAttribute att:wtas){
			if(att.getColumnName().equals(columnName)){
				return att;
			}
		}
		return null;
	}
}
