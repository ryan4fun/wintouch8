package com.wintouch.dal.entityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.ddlutils.DatabaseOperationException;
import org.apache.ddlutils.model.Database;

public class InsertAction extends PersistenceAction{

	@Override
	public ActoinResult execute(EntityManager entityManager) {
		
		ActoinResult result = new ActoinResult();
		
		Database db = entityManager.getDdlMgr().getDatabase();
		
		DynaBean tempBean = db.createDynaBeanFor(this.po.getMetadata().getTableName(), false);
		try {
			BeanUtils.copyProperties(tempBean, this.po);
			entityManager.getPlatform().insert(entityManager.getConf().getConnection(), db, tempBean);
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	

}
