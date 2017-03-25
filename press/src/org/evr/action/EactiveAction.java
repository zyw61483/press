/** Action for eactive
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.action;

import java.util.Collection;

import org.evr.obj.Eactive;
import org.evr.service.EactiveService;

@SuppressWarnings({ "serial", "unchecked" })
public class EactiveAction extends BaseAction {

	private Integer id;
	private String name;
	private String realname;
	private String address;
	private String code;
	private String time;
	private Integer[] ids;
	protected EactiveService eactiveService;

	public String getAll() {
		String hql = "from Eactive";
		saveParameter("id desc", eactiveService);
		eactiveService.setPageSize(50);
		Collection objects = eactiveService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = eactiveService.getPagestr();
		setRequestPageInfo();
		return "eactivelist";
	}

	public String eactivePreAdd() {
		return "eactiveadd";
	}


	public String eactiveAdd() {
		Eactive temp = new Eactive();
		temp.setId(id);
		temp.setAddress(address);
		temp.setCode(code);
		temp.setName(name);
		temp.setRealname(realname);
		temp.setTime(time);
		if (eactiveService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String eactivePreUpdate() {
		Eactive object = null;
		try {
			object = (Eactive) eactiveService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "eactiveupdate";
	}

	public String eactiveUpdate() {
		Eactive temp = null;
		try {
			temp = (Eactive) eactiveService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		temp.setAddress(address);
		temp.setCode(code);
		temp.setName(name);
		temp.setRealname(realname);
		temp.setTime(time);
		if (eactiveService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String eactiveDel() {
		if (eactiveService.delete("id", ids) > 0)
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}


	/***********************************************************************************************************************************/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public EactiveService getEactiveService() {
		return eactiveService;
	}

	public void setEactiveService(EactiveService eactiveService) {
		this.eactiveService = eactiveService;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
