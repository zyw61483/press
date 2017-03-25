package org.evr.obj;

/**
 * Enews entity. @author MyEclipse Persistence Tools
 */

public class Eroll implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String image;
	private String link;
	private String type;
	private String name;
	private String time;
	private Integer flag;
	private Integer browse;

	// Constructors

	/** default constructor */
	public Eroll() {
	}

	/** minimal constructor */
	public Eroll(Integer id) {
		this.id = id;
	}

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

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getBrowse() {
		return browse;
	}

	public void setBrowse(Integer browse) {
		this.browse = browse;
	}

}