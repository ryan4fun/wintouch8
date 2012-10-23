import java.sql.SQLException;
import java.sql.Types;

import org.apache.ddlutils.DatabaseOperationException;
import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.PlatformInfo;
import org.apache.ddlutils.model.Column;
import org.apache.ddlutils.model.Database;
import org.apache.ddlutils.model.Table;
import org.apache.ddlutils.platform.db2.Db2Platform;

import com.touchtone.wintouch.dal.Configuration;
import com.touchtone.wintouch.dal.DALService;
import com.touchtone.wintouch.dal.dataDictionary.WTAttribute;
import com.touchtone.wintouch.dal.dataDictionary.WTObject;
import com.touchtone.wintouch.dal.entityManager.PersistenceObject;


public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Configuration conf = new Configuration();
		
//		conf.setDBType(dbType);
//		conf.setJdbcDriver(jdbcDriver);
//		conf.setJdbcUrl(jdbcUrl);
		
		boolean result = conf.init();
		
		System.out.println("Connected to database : " + result);
		
		if(conf.isInitialized()){
			DALService dalService = conf.getDALService();
			
			WTObject tempTable = new WTObject();
			tempTable.setName("Test");
			tempTable.setTableName("test_table");
			tempTable.setDescription("this is a test");
			
			WTAttribute att1 = new WTAttribute();
			att1.setName("col1");
			att1.setColumnName("col1");
			att1.setDataType(WTAttribute.DATA_TYPE_INT);
			
			tempTable.addAttribute(att1);
			
			dalService.createTable(tempTable);
		}
		
		
//		Database db = new Database();
//
//		
//		Table tempTable = new Table();
//		tempTable.setName("TestTable");
//		
//		Column tempCol = new Column();
//		tempCol.setName("Col1");
//		tempCol.setTypeCode(Types.INTEGER);
//		tempCol.setDefaultValue("0");
//		tempCol.setRequired(false);
//		
//		tempTable.addColumn(tempCol);
//		db.addTable(tempTable);
//		
//		Platform platform = PlatformFactory.createNewPlatformInstance(Db2Platform.DATABASENAME);
//		PlatformInfo info = platform.getPlatformInfo();
//		System.out.println("***" + info.getSqlCommandDelimiter());
//		
//		try {
//			platform.createTables(conf.getConnection(),db,null, false, false);
//		} catch (DatabaseOperationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			
//		
//			e.printStackTrace();
//		}
		
		
		
	}
	
	
	public void testInsertData(){
		
		
		Configuration conf = new Configuration();
		
		boolean result = conf.init();
		
		if(conf.isInitialized()){
			DALService dalService = conf.getDALService();
			
			WTObject wtObj = dalService.getWTObjectByName("Test");
			
			PersistenceObject po = dalService.getPersistenceObjectInst(wtObj);
			
			po.set("col1", 22);
			po.set("col2", "Tanrui");
			
			dalService.insertData(po);
		}
		
	}

}
