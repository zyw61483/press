/** Action for euser
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.evr.obj.Euser;
import org.evr.obj.Select;
import org.evr.service.EuserService;
import org.evr.util.md5;

@SuppressWarnings({ "serial", "unchecked" })
public class EuserAction extends BaseAction {

	private Integer id;
	private String name;
	private String password;
	private String realname;
	private Integer acount;
	private Integer[] ids;
	private static Logger log = Logger.getLogger(EuserAction.class.getName());
	private EuserService euserService;
	private static final int BUFFER_SIZE = 16 * 1024 ;
	
	/**
	 * 数据初始化
	 * @return
	 */
	public String getAll() {
		String hql = "from Euser";
		saveParameter("id desc", euserService);
		euserService.setPageSize(50);
		Collection objects = euserService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = euserService.getPagestr();
		setRequestPageInfo();
		return "euserlist";
	}

	/**
	 * 跳转新增页面
	 * @return
	 */
	public String euserPreAdd() {
		initEuserSelect();
		return "euseradd";
	}

	/**
	 * 初始化下拉框数据
	 */
	private void initEuserSelect() {
		Select select;
		List<Select> selecttype = new ArrayList();
		select = new Select();
		select.setValue("男");
		select.setName("男");
		selecttype.add(select);
		select = new Select();
		select.setValue("女");
		select.setName("女");
		selecttype.add(select);
		request.setAttribute("C_SELECT_TYPE", selecttype);
	}

	/**
	 * 新增用户表管理信息
	 * @return
	 */
	public String euserAdd() {
		if (!isValidate(0)) {
			initEuserSelect();
			return "euseradd";
		}
		Euser temp = new Euser();
//		temp.setId(id);
		temp.setName(name);
		md5 md51 = new md5();
		md51.md5s(password);
		password = md51.str;
		temp.setPassword(password);
		temp.setRealname(realname);
		temp.setAcount(acount);
		if (euserService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 跳转修改页面
	 * @return
	 */
	public String euserPreUpdate() {
		initEuserSelect();
		Euser object = null;
		try {
			object = (Euser) euserService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "euserupdate";
	}

	/**
	 * 修改用户表管理信息
	 * @return
	 */
	public String euserUpdate() {
		if (!isValidate(0)) {
			initEuserSelect();
			return "euserupdate";
		}
		Euser temp = (Euser) euserService.getInfo(id);
		//更新用户信息
//		temp.setId(id);
		temp.setName(name);
		md5 md51 = new md5();
		md51.md5s(password);
		password = md51.str;
		temp.setPassword(password);
		temp.setRealname(realname);
		temp.setAcount(acount);
		if (euserService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 删除关于我们信息
	 * @return
	 */
	public String euserDel() {
		//删除用户信息
		if (euserService.delete("id", ids) > 0)
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 数据校验
	 * @param ctype
	 * @return
	 */
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
		saveParameter("id asc", euserService);
		 Collection objects =
		 euserService.getAll("from Euser where name='"+name+"' and id!="+id);
		 if(objects.size() > 0)
		 {
		 returnCode = addFieldErrorInfo("name", "该用户名已经存在！");
		 }
		// 保存数据以用于子页面是否需要调整宽度和高度
		setRequestTokenInfo(returnCode);
		return returnCode;
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

	public EuserService getEuserService() {
		return euserService;
	}

	public void setEuserService(EuserService euserService) {
		this.euserService = euserService;
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
