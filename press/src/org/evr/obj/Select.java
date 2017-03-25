package org.evr.obj;

/**
 * Select entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Select {

	// Fields

	private String value;
	private String name;


	// Constructors

	/** default constructor */
	public Select() {
	}

	/** minimal constructor */
	public Select(String value) {
		this.value = value;
	}

	/** full constructor */
	public Select(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Property accessors



}