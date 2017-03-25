package org.evr.obj;

/**
 * Ecode entity. @author MyEclipse Persistence Tools
 */

public class Egame implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String time;
	private Integer score;
	private Integer duration;
	// Constructors

	/** default constructor */
	public Egame() {
	}

	/** minimal constructor */
	public Egame(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}