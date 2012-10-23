package com.touchtone.wintouch.dal.ddlManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ddlutils.DatabaseOperationException;
import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.model.Column;
import org.apache.ddlutils.model.Database;
import org.apache.ddlutils.model.Table;

import com.touchtone.wintouch.dal.Configuration;
import com.touchtone.wintouch.dal.DALException;
import com.touchtone.wintouch.dal.dataDictionary.WTAttribute;
import com.touchtone.wintouch.dal.dataDictionary.WTObject;
import com.touchtone.wintouch.dal.entityManager.PersistenceObject;

public class DDLManager {

    private final Log _logger = LogFactory.getLog(getClass());
    
	Platform plateformInst = null;
	Configuration conf = null;
	Database db = null;
	
	public DDLManager(Configuration conf){
		
		this.conf = conf;

		init();
	
	}
	
	
	private void init() {
		
		this.plateformInst = PlatformFactory.createNewPlatformInstance(conf.getDBType());
		
		try {
			
			this.db = this.plateformInst.readModelFromDatabase(this.conf.getConnection(), null);
		} catch (DatabaseOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public boolean createTable(WTObject tableObj){
		
		boolean result = false;
		
		Database dbModel = buildDBModel(tableObj);
		
		try {
			this.plateformInst.createTables(conf.getConnection(),dbModel,null, false, false);
			result = true;
			
		} catch (DatabaseOperationException e) {
			
			// mostly because table already exist
			_logger.info("Exception occured when create table " + e.getMessage() );
			return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Connection Error when create table ", e);

		} 
		
		return result;
	}


	public boolean modifyTable(WTObject tableObj){
		
		boolean result = false;
		
		Database dbModel = buildDBModel(tableObj);
		
		try {
			this.plateformInst.alterTables(conf.getConnection(),dbModel,null, false);
			result = true;
			
		} catch (DatabaseOperationException e) {
			
			// mostly because table already exist
			_logger.info("Exception occured when create table " + e.getMessage() );
			return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Connection Error when create table ", e);

		} 
		
		return result;
	}
	
	public boolean dropTable(WTObject tableObj){
		
		boolean result = false;
		
		Database dbModel = buildDBModel(tableObj);
		
		try {
			this.plateformInst.dropTables(conf.getConnection(),dbModel, false);
			result = true;
			
		} catch (DatabaseOperationException e) {
			
			// mostly because table already exist
			_logger.info("Exception occured when create table " + e.getMessage() );
			return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Connection Error when create table ", e);

		} 
		return result;
	}
	
	
	
	private Database buildDBModel(WTObject tableObj) {
		
		Database tempDB = new Database();

		
		Table tempTable = new Table();
		
		tempTable.setName(tableObj.getTableName());
		tempTable.setDescription(tableObj.getDescription());
		
		List<Column> columnList = buildColumnList(tableObj);
		
		tempTable.addColumns(columnList);
		
		tempDB.addTable(tempTable);
		
		return tempDB;
	}


	private List<Column> buildColumnList(WTObject tableObj) {
		
		List<Column> colList = new ArrayList<Column>();
		
		
		for(WTAttribute att:tableObj.getAttributeList()){
			
			Column tempCol = new Column();
				
			try {
				BeanUtils.copyProperties(att,tempCol);
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
				throw new DALException("Bean property copy error !",e);
				
			} catch (InvocationTargetException e) {
				_logger.error("Copy value error : source:" + describeObject(att));
				_logger.error("Copy value error : destination:" + describeObject(tempCol));
				e.printStackTrace();
				throw new DALException("Bean property copy error !",e);
			}
			
			colList.add(tempCol);
		}
		
		return colList;
	}


	private String describeObject(Object obj) {
		
		String result = "";
		
		try {
			
			Map propertyMap = BeanUtils.describe(obj);
			if(propertyMap != null){
				result = propertyMap.toString();
			}
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


	public Database getDatabase() {
		return this.db;
	}
	
	
	public Platform getPlatformInstance(){
		
		return this.plateformInst;
	}


	public boolean isPhysicalTableExists(WTObject tempObj) {
		
		boolean result = false;
		
		if(tempObj != null){
			
			String checkSql = "Select * from " + tempObj.getTableName();
			
			try {
				
				Connection conn = this.conf.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(checkSql);
				
				if(rs != null ){
					
					result = true;
					rs.close();
					st.close();
				}
				
			} catch (SQLException e) {
				_logger.info("Table doesn't exist !", e);
				result = false;
			}
			
		}
		
		return result;
	}
	
	public PersistenceObject createPersistenceObject(WTObject wtObj){
		
		DynaClass classObj = this.db.getDynaClassFor(wtObj.getTableName());
		PersistenceObject pObj = new PersistenceObject(wtObj,classObj);
		return pObj;
	}


	public Iterator executQuery(String sql, List params) {
		// TODO Auto-generated method stub
		return null;
	}
}
