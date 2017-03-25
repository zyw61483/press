/** Action for esysuser
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.evr.obj.Esysuser;
import org.evr.obj.Select;
import org.evr.service.EsysuserService;
import org.evr.util.md5;

@SuppressWarnings({ "serial", "unchecked" })
public class EsysuserAction extends BaseAction {

	private Integer id;
	private String name;
	private String password;
	private String type;
	private Integer[] ids;
	protected EsysuserService esysuserService;
	private static final int BUFFER_SIZE = 16 * 1024;

	public String getAll() {
		String hql = "from Esysuser";
		saveParameter("id desc", esysuserService);
		esysuserService.setPageSize(50);
		Collection objects = esysuserService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = esysuserService.getPagestr();
		setRequestPageInfo();
		return "esysuserlist";
	}

	public String esysuserPreAdd() {
		initEsysuserSelect();
		return "esysuseradd";
	}

	private void initEsysuserSelect() {
		Select select;
		List<Select> selecttype = new ArrayList();
		select = new Select();
		select.setValue("资源管理员");
		select.setName("资源管理员");
		selecttype.add(select);
		select = new Select();
		select.setValue("系统管理员");
		select.setName("系统管理员");
		selecttype.add(select);
		select = new Select();
		select.setValue("信息管理员");
		select.setName("信息管理员");
		selecttype.add(select);
		request.setAttribute("C_SELECT_TYPE", selecttype);
	}

	public String esysuserAdd() {
		if (!isValidate(0)) {
			initEsysuserSelect();
			return "esysuseradd";
		}
		Esysuser object = new Esysuser();
		object.setId(id);
		object.setName(name);
		md5 md51 = new md5();
		md51.md5s(name);
		password = md51.str;
		object.setPassword(password);
		object.setType(type);
		if (esysuserService.insert(object))
			random_token = "1";
		else
			random_token = "0";
		// 系统日志 增加公告记录
		return "info_handle";
	}

	public String esysuserPreModpw() {
		Esysuser object = null;
		try {
			object = (Esysuser) esysuserService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "esysusermodpw";
	}

	public String esysuserModpw() {
		Esysuser object = null;
		try {
			object = (Esysuser) esysuserService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		md5 md51 = new md5();
		md51.md5s(password);
		password = md51.str;
		object.setPassword(password);
		if (esysuserService.update(object))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String esysuserPreUpdate() {
		initEsysuserSelect();
		Esysuser object = null;
		try {
			object = (Esysuser) esysuserService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "esysuserupdate";
	}

	public String esysuserUpdate() {
		if (!isValidate(0)) {
			initEsysuserSelect();
			return "esysuserupdate";
		}
		Esysuser object = null;
		try {
			object = (Esysuser) esysuserService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		object.setName(name);
		object.setType(type);
		if (esysuserService.update(object))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String esysuserDel() {
		if (esysuserService.delete("id", ids) > 0)
			random_token = "1";
		else
			random_token = "0";
		// setRequestPageInfo();
		return "info_handle";
	}

	public String login() {
		saveParameter("id asc", esysuserService);
		md5 md51 = new md5();
		md51.md5s(password);
		password = md51.str;
		List objects = esysuserService
				.getAll("from Esysuser where name='" + name
						+ "' and password='" + password + "' and type='系统管理员'");
		if (objects!=null && objects.size() > 0) {
			Esysuser sysuser = (Esysuser) objects.get(0);
			HttpSession session = request.getSession();
			session.setAttribute("id", sysuser.getId());
			session.setAttribute("name", sysuser.getName());
			return "loginOk";
		} else {
			addFieldErrorInfo("cexist", "用户名密码错误");
			return "loginError";
		}
	}

	public boolean isValidate(int ctype) {
		boolean returnCode = true;
		if (ctype == 1) {
			if (id.equals("")) {
				returnCode = addFieldErrorInfo("dataerror", "数据错误，请重新输入！");
			}
		}
		if (name.trim().equals("")) {
			returnCode = addFieldErrorInfo("name", "请输入用户名！");
		}
		saveParameter("id asc", esysuserService);
		Collection objects = esysuserService
				.getAll("from Esysuser where name='" + name + "' and id!=" + id);
		if (objects.size() > 0) {
			returnCode = addFieldErrorInfo("name", "该用户名已经存在！");
		}
		// 保存数据以用于子页面是否需要调整宽度和高度
		setRequestTokenInfo(returnCode);
		return returnCode;
	}

	public Integer getId() {
		return id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public EsysuserService getEsysuserService() {
		return esysuserService;
	}

	public void setEsysuserService(EsysuserService esysuserService) {
		this.esysuserService = esysuserService;
	}

}
