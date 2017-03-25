package org.evr.obj;

/**
 * Etype entity. @author MyEclipse Persistence Tools
 */

public class Ebooksets implements java.io.Serializable {


	private Integer id;
	private String type;
	private String item;
	private Integer seq;

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

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}