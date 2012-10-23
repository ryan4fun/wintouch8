package com.touchtone.wintouch.dal;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.touchtone.wintouch.dal.dataDictionary.WTObject;
import com.touchtone.wintouch.dal.entityManager.PersistenceObject;

public interface DALService {

	public void init();
	
	public boolean createTable(WTObject wtObj);
	public boolean dropTable(WTObject wtObj);
	public boolean alterTable(WTObject wtObj);
	
	public PersistenceObject insertData(PersistenceObject pObj);
	public boolean deleteData(PersistenceObject pObj);
	public PersistenceObject updateData(PersistenceObject pObj);
	public PersistenceObject loadData(PersistenceObject pObj);
	public PersistenceObject loadData(String id,WTObject wtObj);
	public PersistenceObject getPersistenceObjectInst(WTObject wtObj);
	
	public List<DynaBean> QueryData(String Sql,List params);
	
	public List<WTObject> getDictionaryMetadata();
	public WTObject getWTObjectById(String id);
	public WTObject getWTObjectByName(String name);
	
}
