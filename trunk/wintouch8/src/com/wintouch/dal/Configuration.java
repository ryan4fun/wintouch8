package com.wintouch.dal;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

public class Configuration  implements DataSource{
	
	public final static String DB_TYPE_DB2 = "DB2";
	public final static String DB_TYPE_DB2V8 = "DB2v8";
	
	public final static int TIMEOUT = 100;
	
	private String jdbcUrl = "jdbc:as400://wintouch.touchtonecorp.com/WT8TEST";
	private String jdbcDriver = "com.ibm.as400.access.AS400JDBCDriver";
	private String userName = "raymond";
	private String password = "raymond12";
	private String testQueryString = "values 1";
	private String DBType = "DB2";
	
	private Connection connection;
	private DALService dalService;
	private boolean initialized;
	
	
	public boolean init(){
		boolean result = false;
		
		
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);
		
		try {
			if(this.jdbcDriver != null)
			Class.forName(this.jdbcDriver);
			   
		}catch(ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class! " + this.jdbcDriver);
			throw new DALException("Error: unable to load driver class! " + this.jdbcDriver,ex);
		}
		
		    
		try {
			conn = DriverManager.getConnection(this.jdbcUrl,connectionProps);
			
			if(conn != null && isConnectionValide(conn)){
				
				result = true;
				this.connection = conn;
				this.initialized = true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DALException("Can't connect to database! ",e);
		}
		
		
		return result;
		
	}
	
	private boolean isConnectionValide(Connection conn) {
		boolean result = false;
		
		try {
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(this.testQueryString);
			
			if(rs != null ){
				
				result = true;
				rs.close();
				st.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return result;
	}

	public boolean init(Properties p){
		boolean result = false;
		
		if(p != null && !p.isEmpty()){
			
			if(p.get("jdbcUrl") != null){
				
				this.setJdbcUrl((String) p.get("jdbcUrl"));
			}
			
			if(p.get("jdbcDriver") != null){
				
				this.setJdbcDriver((String) p.get("jdbcDriver"));
			}
			
			if(p.get("userName") != null){
				
				this.setUserName((String) p.get("userName"));
			}
			
			if(p.get("password") != null){
				
				this.setPassword((String) p.get("password"));
			}
			
			result = this.init();
		}
		
		return result;
	}
	
	/**
	 * judge if the configuration is valide and connected to database.
	 * @return
	 */
	public boolean isConnected(){
		
		boolean result = false;
		
		if (null != this.connection && isConnectionValide(this.connection)){
				
			result = true;
		}

		
		return result;
	}
	
	

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public String getTestQueryString() {
		return testQueryString;
	}

	public void setTestQueryString(String testQueryString) {
		this.testQueryString = testQueryString;
	}

	
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		
		return this.connection;
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		
		return this.connection;
	}


	public String getDBType() {
		return DBType;
	}

	public void setDBType(String dbType) {
		this.DBType = dbType;
	}
	
	public DALService getDALService(){
		
		if(this.dalService == null) {
			
			this.dalService = new DALServiceImpl(this);
		}
		return this.dalService;
	}

	public boolean isInitialized() {
		return this.initialized;
	}

}
