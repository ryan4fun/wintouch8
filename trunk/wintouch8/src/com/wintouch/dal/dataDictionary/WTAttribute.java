package com.wintouch.dal.dataDictionary;

public class WTAttribute {

	
	public static final String DATA_TYPE_TEXT = "text";
	public static final String DATA_TYPE_INT = "int";
	public static final String DATA_TYPE_DATE = "Date";
	public static final String DATA_TYPE_TIME = "Time";
	public static final String DATA_TYPE_DATETIME = "DateTime";
	
	
	private long id;
	private String name;
	private String columnName;
	private String description;
	private boolean identity;
	private boolean nullable;
	private boolean autoIncrease;
	private String dataType;
	private int length;
	private int scale;
	private String defaultValue;
	private boolean searchEnabled;
	private boolean unique;
	
	
	public WTAttribute(){
		
	}
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isIdentity() {
		return identity;
	}
	public void setIdentity(boolean identity) {
		this.identity = identity;
	}
	public boolean isNullable() {
		return nullable;
	}
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}
	public boolean isAutoIncrease() {
		return autoIncrease;
	}
	public void setAutoIncrease(boolean autoIncrease) {
		this.autoIncrease = autoIncrease;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public boolean isSearchEnabled() {
		return searchEnabled;
	}
	public void setSearchEnabled(boolean searchEnabled) {
		this.searchEnabled = searchEnabled;
	}
	public boolean isUnique() {
		return unique;
	}
	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	
	
}
