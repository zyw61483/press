package org.evr.obj;

/**
 * Ebook entity. @author MyEclipse Persistence Tools
 */

public class Ebook implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String detail;
	private String resfile;
	private String author;
	private String publisher;
	private String publishtime;
	private String sets;
	private String type;
	private String name;
	private String time;
	private String flag;
	private Integer browse;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getResfile() {
		return resfile;
	}

	public void setResfile(String resfile) {
		this.resfile = resfile;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBrowse() {
		return browse;
	}

	public void setBrowse(Integer browse) {
		this.browse = browse;
	}

	public String getSets() {
		return sets;
	}

	public void setSets(String sets) {
		this.sets = sets;
	}

}