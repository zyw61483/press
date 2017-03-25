package org.evr.obj;

/**
 * Euser entity. @author MyEclipse Persistence Tools
 */

public class Euser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private String realname;
	private Integer acount;

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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getAcount() {
		return acount;
	}

	public void setAcount(Integer acount) {
		this.acount = acount;
	}

}