package org.evr.obj;

/**
 * Structure entity. @author MyEclipse Persistence Tools
 */

public class Structure implements java.io.Serializable {

	// Fields

	private Integer id;
	private String tableName;
	private String fieldName;
	private String cnName;
	private String fieldType;
	private Integer isValid;

	// Constructors

	/** default constructor */
	public Structure() {
	}

	/** minimal constructor */
	public Structure(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Structure(Integer id, String tableName, String fieldName,
			String cnName, String fieldType, Integer isValid) {
		this.id = id;
		this.tableName = tableName;
		this.fieldName = fieldName;
		this.cnName = cnName;
		this.fieldType = fieldType;
		this.isValid = isValid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getCnName() {
		return this.cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Integer getIsValid() {
		return this.isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

}