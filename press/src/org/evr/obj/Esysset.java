package org.evr.obj;

/**
 * Esysset entity. @author MyEclipse Persistence Tools
 */

public class Esysset implements java.io.Serializable {

	// Fields

	private Integer id;
	private String item;
	private Integer factor;

	// Constructors

	/** default constructor */
	public Esysset() {
	}

	/** minimal constructor */
	public Esysset(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Esysset(Integer id, String item, Integer factor) {
		this.id = id;
		this.item = item;
		this.factor = factor;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getFactor() {
		return this.factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}

}