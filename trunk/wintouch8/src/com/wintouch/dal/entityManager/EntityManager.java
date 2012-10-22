package com.wintouch.dal.entityManager;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ddlutils.Platform;

import com.wintouch.dal.Configuration;
import com.wintouch.dal.ddlManager.DDLManager;

public class EntityManager {
	
	private Configuration conf;
	private DDLManager ddlMgr;
	private Platform platform;

	public EntityManager(Configuration conf,DDLManager ddlMgr){
		
		this.conf = conf;
		this.ddlMgr = ddlMgr;
		this.setPlatform(ddlMgr.getPlatformInstance());
	}
	
    private final Log _logger = LogFactory.getLog(getClass());
	
	private List<EntityFilter> beforeFilters = new ArrayList<EntityFilter>();
	private List<EntityFilter> afterFilters = new ArrayList<EntityFilter>();
	
	public ActoinResult doPersistenceAction(PersistenceAction pAction){
		
		ActoinResult result = null;
		
		_logger.debug("Executing Before filter");
		doBeforeFilter(pAction,pAction.getPO());
		_logger.debug("Executing Persistence Action");
		result = pAction.execute(this); 
		_logger.debug("Executing After filter");
		doAfterFilter(result,pAction,pAction.getPO());
		
		return result;
		
	}

	private void doAfterFilter(ActoinResult result, PersistenceAction pAction,
			PersistenceObject po) {
		
		for(EntityFilter filter : this.afterFilters){
			
			result = filter.doFilte(result,pAction.getActionType(), po);
		}
		
	}

	private void doBeforeFilter(PersistenceAction pAction, PersistenceObject po) {
		
		for(EntityFilter filter : this.beforeFilters){
			
			filter.doFilte(null,pAction.getActionType(), po);
		}
		
	}

	public Configuration getConf() {
		return conf;
	}

	public void setConf(Configuration conf) {
		this.conf = conf;
	}

	public DDLManager getDdlMgr() {
		return ddlMgr;
	}

	public void setDdlMgr(DDLManager ddlMgr) {
		this.ddlMgr = ddlMgr;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

}
