package org.evr.obj;

/**
 * Esysuser entity. @author MyEclipse Persistence Tools
 */

public class Esysuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private String type;

	// Constructors

	/** default constructor */
	public Esysuser() {
	}

	/** minimal constructor */
	public Esysuser(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Esysuser(Integer id, String name, String password, String type) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}