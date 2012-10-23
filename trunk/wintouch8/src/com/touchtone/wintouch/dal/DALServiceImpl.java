package com.touchtone.wintouch.dal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.touchtone.wintouch.dal.dataDictionary.WTObject;
import com.touchtone.wintouch.dal.ddlManager.DDLManager;
import com.touchtone.wintouch.dal.entityManager.ActoinResult;
import com.touchtone.wintouch.dal.entityManager.EntityManager;
import com.touchtone.wintouch.dal.entityManager.PersistenceAction;
import com.touchtone.wintouch.dal.entityManager.PersistenceObject;

public class DALServiceImpl implements DALService {
	
	
    private final Log _logger = LogFactory.getLog(getClass());
	
	private Configuration conf;

	private DDLManager ddlManager;

	private EntityManager entityManager;

	public DALServiceImpl(Configuration configuration) {
		
		this.conf = configuration;
	}

	@Override
	public void init() {
		
		_logger.info("trying to initialize DAL Service");
		
		if(this.conf == null){
			throw new DALException("DAL Service initial faild: no valid configuration!");
		}
		
		if(!this.conf.isInitialized()){
			
			boolean result = this.conf.init();
			if(!result){
				
				throw new DALException("DAL Service initialize failed: no usable connection!");
			}
			
			this.ddlManager = new DDLManager(this.conf);
			this.entityManager = new EntityManager(this.conf,this.ddlManager);
			
			_logger.info("DAL Service initialized successfully!");
		}
	}

	
	public boolean createTable(String id) {
		
		boolean result = false;
		
		WTObject tempObj = getWTObjectById(id);
		result = this.createTable(tempObj);
		
		return result;
	}

	public boolean createTable(WTObject tempObj) {

		boolean result = false;
		
		if(!this.ddlManager.isPhysicalTableExists(tempObj)){
		
			result = this.ddlManager.createTable(tempObj);
		
		}else{
			_logger.info("Table is exist, please call alter table interface!");
		}
		
		return result;
	}

	
	public boolean dropTable(String id) {

		boolean result = false;
		
		WTObject tempObj = getWTObjectById(id);
		result = this.dropTable(tempObj);
		
		return result;
	}

	public boolean dropTable(WTObject tempObj) {
		
		boolean result = false;
		
		if(this.ddlManager.isPhysicalTableExists(tempObj)){
		
			result = this.ddlManager.dropTable(tempObj);
		
		}else{
			_logger.info("Table is not exist, can't drop anything : " + tempObj.getTableName());
		}
		
		return result;
	}

	
	public boolean alterTable(String id) {
		boolean result = false;
		
		WTObject tempObj = getWTObjectById(id);
		result = this.alterTable(tempObj);
		
		return result;
	}

	public boolean alterTable(WTObject tempObj) {

		boolean result = false;
		
		if(this.ddlManager.isPhysicalTableExists(tempObj)){
		
			result = this.ddlManager.modifyTable(tempObj);
		
		}else{
			_logger.info("Table is not exist, can't alter : " + tempObj.getTableName());
		}
		
		return result;
	}

	@Override
	public PersistenceObject insertData(PersistenceObject pObj) {

		PersistenceObject result = null;
		
		PersistenceAction pAction = PersistenceAction.getActionInst(PersistenceAction.ACTION_TYPE_INSERT);
		pAction.setPO(pObj);
		
		ActoinResult actionResult = this.entityManager.doPersistenceAction(pAction);
		
		if(actionResult != null && actionResult.isSuccessed()){
			
			result = actionResult.getPO();
		}
		
		return result;
	}

	@Override
	public boolean deleteData(PersistenceObject pObj) {

		boolean result = false;
		
		PersistenceAction pAction = PersistenceAction.getActionInst(PersistenceAction.ACTION_TYPE_DELETE);
		pAction.setPO(pObj);
		
		ActoinResult actionResult = this.entityManager.doPersistenceAction(pAction);
		
		if(actionResult != null ){
			
			result = actionResult.isSuccessed();
		}
		
		return result;
	}

	@Override
	public PersistenceObject updateData(PersistenceObject pObj) {

		PersistenceObject result = null;
		
		PersistenceAction pAction = PersistenceAction.getActionInst(PersistenceAction.ACTION_TYPE_UPDATE);
		pAction.setPO(pObj);
		
		ActoinResult actionResult = this.entityManager.doPersistenceAction(pAction);
		
		if(actionResult != null && actionResult.isSuccessed()){
			
			result = actionResult.getPO();
		}
		
		return result;
	}

	@Override
	public PersistenceObject loadData(PersistenceObject pObj) {

		PersistenceObject result = null;
		
		PersistenceAction pAction = PersistenceAction.getActionInst(PersistenceAction.ACTION_TYPE_LOAD);
		pAction.setPO(pObj);
		
		ActoinResult actionResult = this.entityManager.doPersistenceAction(pAction);
		
		if(actionResult != null && actionResult.isSuccessed()){
			
			result = actionResult.getPO();
		}
		
		return result;
	}

	@Override
	public PersistenceObject loadData(String id,WTObject wtObj) {
		
		PersistenceObject po = this.ddlManager.createPersistenceObject(wtObj);
		po.setId(id);
		
		return this.loadData(po);
	}



	
	public List<DynaBean> QueryData(String sql, List params) {

		List<DynaBean> result = new ArrayList<DynaBean>();
		
		Iterator it = this.ddlManager.executQuery(sql, params);
		
		while (it.hasNext()) {
			
			DynaBean tempBean = (DynaBean) it.next();
			result.add(tempBean);
		}	
		
		return result;
	}

//	private PersistenceObject createPO(DynaBean tempBean) {
//		
//		PersistenceObject po = new PersistenceObject();
//		
//		return null;
//	}

	@Override
	public List<WTObject> getDictionaryMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WTObject getWTObjectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WTObject getWTObjectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistenceObject getPersistenceObjectInst(WTObject wtObj) {
		
		PersistenceObject po = this.ddlManager.createPersistenceObject(wtObj);
		return po;
	}

}
