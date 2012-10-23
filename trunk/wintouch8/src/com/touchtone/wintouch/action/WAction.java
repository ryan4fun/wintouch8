package com.touchtone.wintouch.action;

import com.touchtone.wintouch.WintouchConfiguration;
import com.touchtone.wintouch.dal.DALService;

/**
 * 
 * @author xingwei.wu
 *
 */
public abstract class WAction {
	private final DALService dalService;
	
	/**
	 * 
	 */
	WAction(){
		this.dalService = WintouchConfiguration.getDALService();
	}
	
	/**
	 * 
	 * @return
	 */
	DALService getDalService(){
		return this.dalService;
	}
}
