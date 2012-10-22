package com.wintouch.dal.entityManager;

import org.apache.commons.beanutils.DynaClass;
import org.apache.ddlutils.dynabean.SqlDynaBean;

import com.wintouch.dal.dataDictionary.WTObject;

public class PersistenceObject extends SqlDynaBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8030740415671868821L;

	private WTObject wtObj;
	
	public final static String SYS_PROPERTY_NAME_ID = "WTID";

	public PersistenceObject(WTObject wtObj, DynaClass classObj) {
		
		super(classObj);
		this.wtObj = wtObj;

	}


	public WTObject getMetadata() {
		
		return this.wtObj;
	}

	public void setId(String id) {
		
		if(id != null);
		this.set(SYS_PROPERTY_NAME_ID, Integer.parseInt(id));
		
	}
	
}
