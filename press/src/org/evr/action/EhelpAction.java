/** Action for ehelp
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.evr.obj.Ehelp;
import org.evr.obj.Ehelptype;
import org.evr.obj.Select;
import org.evr.service.EhelpService;
import org.evr.service.EhelptypeService;

@SuppressWarnings({ "serial", "unchecked" })
public class EhelpAction extends BaseAction {

	private Integer id;
	private String title;
	private String detail;
	private String type;
	private String name;
	private String time;
	private Integer[] ids;
	protected EhelpService ehelpService;
	protected EhelptypeService ehelptypeService;

	private void initSelect() {
		List<Select> selecttype = new ArrayList();
		List<Ehelptype> tempList = (List<Ehelptype>) ehelptypeService.getAll("from Ehelptype");
		if(tempList!=null && tempList.size()>0){
			for (Ehelptype temp : tempList) {
				Select select = new Select();
				select.setValue(temp.getItem());
				select.setName(temp.getItem());
				selecttype.add(select);
			}
		}
		request.setAttribute("C_SELECT_TYPE", selecttype);
	}
	
	public String getInfo()
	{
		Object object = null;
		try {
			object = ehelpService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "ehelpinfo";
	}
	
	public String getAll() {
		String hql = "from Ehelp";
		saveParameter("id desc", ehelpService);
		ehelpService.setPageSize(50);
		Collection objects = ehelpService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = ehelpService.getPagestr();
		setRequestPageInfo();
		return "ehelplist";
	}

	public String ehelpPreAdd() {
		initSelect();
		return "ehelpadd";
	}

	public String ehelpAdd() {
		if (!isValidate(0)) {
			initSelect();
			return "ehelpadd";
		}
		Ehelp temp = new Ehelp();
		temp.setId(id);
		temp.setDetail(detail);
		temp.setName((String)request.getSession().getAttribute("name"));
		temp.setTime(time);
		temp.setTitle(title);
		temp.setType(type);
		if (ehelpService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String ehelpPreUpdate() {
		initSelect();
		Ehelp object = null;
		try {
			object = (Ehelp) ehelpService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "ehelpupdate";
	}

	/**
	 * 修改书籍类别信息
	 * @return
	 */
	public String ehelpUpdate() {
		if (!isValidate(0)) {
			initSelect();
			return "ehelpupdate";
		}
		Ehelp temp = null;
		try {
			temp = (Ehelp) ehelpService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		temp.setDetail(detail);
		temp.setName((String)request.getSession().getAttribute("name"));
		temp.setTime(time);
		temp.setTitle(title);
		temp.setType(type);
		
		if (ehelpService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 删除书籍类别信息
	 * @return
	 */
	public String ehelpDel() {
		if (ehelpService.delete("id", ids) > 0)
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
		saveParameter("id asc", ehelpService);
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

	public EhelpService getEhelpService() {
		return ehelpService;
	}

	public void setEhelpService(EhelpService ehelpService) {
		this.ehelpService = ehelpService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public EhelptypeService getEhelptypeService() {
		return ehelptypeService;
	}

	public void setEhelptypeService(EhelptypeService ehelptypeService) {
		this.ehelptypeService = ehelptypeService;
	}

}
