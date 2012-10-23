package com.touchtone.wintouch;

import com.touchtone.wintouch.dal.Configuration;
import com.touchtone.wintouch.dal.DALService;

/**
 * 
 * @author xingwei.wu
 *
 */
public class WintouchConfiguration {
	private static Configuration DBConfiguration;
	
	/**
	 * 
	 */
	public synchronized static boolean initDBConfiguration(String jdbcUrl,String userName,String password){
		Configuration configuration = new Configuration();
		configuration.setJdbcUrl(jdbcUrl);
		configuration.setUserName(userName);
		configuration.setPassword(password);
		boolean ret = DBConfiguration.init();
		if(ret&&DBConfiguration.isInitialized()){
			DBConfiguration = configuration;
		}
		return ret;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public synchronized static Configuration getDBConfiguration(){
		if(DBConfiguration==null){
			throw new RuntimeException("DB configuration is not initiated");
		}
		return DBConfiguration;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public synchronized static DALService getDALService(){
		return getDBConfiguration().getDALService();
	}
}
