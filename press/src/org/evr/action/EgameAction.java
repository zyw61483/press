/** Action for Egame
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.action;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import org.evr.obj.Ebook;
import org.evr.obj.Egame;
import org.evr.service.EgameService;
import org.evr.util.FileUtil;

@SuppressWarnings({ "serial", "unchecked" })
public class EgameAction extends BaseAction {

	private Integer id;
	private String name;
	private String time;
	private Integer score;
	private Integer duration;
	private Integer[] ids;
	protected EgameService egameService;

	/**
	 * 数据初始化
	 * @return
	 */
	public String getAll() {
		String hql = "from Egame";
		saveParameter("id desc", egameService);
		egameService.setPageSize(50);
		Collection objects = egameService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = egameService.getPagestr();
		setRequestPageInfo();
		return "egamelist";
	}

	/**
	 * 跳转新增页面
	 * @return
	 */
	public String egamePreAdd() {
		return "egameadd";
	}

	public String egameAdd() {
		if (!isValidate(0)) {
			return "egameadd";
		}
		Egame temp = new Egame();
		temp.setId(id);
		temp.setName(name);
		temp.setTime(time);
		temp.setScore(score);
		temp.setDuration(duration);
		if (egameService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String egamePreUpdate() {
		Egame object = null;
		try {
			object = (Egame) egameService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "egameupdate";
	}

	public String egameUpdate() {
		if (!isValidate(0)) {
			return "egameupdate";
		}
		Egame temp = (Egame) egameService.getInfo(id);
		temp.setId(id);
		temp.setName(name);
		temp.setTime(time);
		temp.setScore(score);
		temp.setDuration(duration);
		if (egameService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String egameDel() {
		if (egameService.delete("id", ids) > 0)
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public boolean isValidate(int ctype) {
		boolean returnCode = true;
		return returnCode;
	}

	/***********************************************************************************************************************************/
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
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

	public EgameService getEgameService() {
		return egameService;
	}

	public void setEgameService(EgameService egameService) {
		this.egameService = egameService;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer[] getIds() {
		return ids;
	}

}
