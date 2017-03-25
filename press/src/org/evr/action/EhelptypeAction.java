/** Action for ehelptype
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.evr.obj.Ehelptype;
import org.evr.obj.Select;
import org.evr.service.EhelptypeService;

@SuppressWarnings({ "serial", "unchecked" })
public class EhelptypeAction extends BaseAction {

	private Integer id;
	private String item;
	private Integer seq;
	private Integer[] ids;
	protected EhelptypeService ehelptypeService;

	public String getAll() {
		String hql = "from Ehelptype";
		saveParameter("id desc", ehelptypeService);
		ehelptypeService.setPageSize(50);
		Collection objects = ehelptypeService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = ehelptypeService.getPagestr();
		setRequestPageInfo();
		return "ehelptypelist";
	}

	public String ehelptypePreAdd() {
		return "ehelptypeadd";
	}

	public String ehelptypeAdd() {
		if (!isValidate(0)) {
			return "ehelptypeadd";
		}
		Ehelptype temp = new Ehelptype();
		temp.setId(id);
		temp.setItem(item);
		temp.setSeq(seq);
		if (ehelptypeService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String ehelptypePreUpdate() {
		Ehelptype object = null;
		try {
			object = (Ehelptype) ehelptypeService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "ehelptypeupdate";
	}

	/**
	 * 修改书籍类别信息
	 * @return
	 */
	public String ehelptypeUpdate() {
		if (!isValidate(0)) {
			return "ehelptypeupdate";
		}
		Ehelptype temp = null;
		try {
			temp = (Ehelptype) ehelptypeService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		temp.setItem(item);
		temp.setSeq(seq);
		if (ehelptypeService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 删除书籍类别信息
	 * @return
	 */
	public String ehelptypeDel() {
		if (ehelptypeService.delete("id", ids) > 0)
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
		if (item.trim().equals("")) {
			returnCode = addFieldErrorInfo("item", "请输入类别名！");
		}
		saveParameter("id asc", ehelptypeService);
		 Collection objects =
		 ehelptypeService.getAll("from Ehelptype where item='"+item+"' and id!="+id);
		 if(objects.size() > 0)
		 {
		 returnCode = addFieldErrorInfo("item", "该类别已经存在！");
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public EhelptypeService getEhelptypeService() {
		return ehelptypeService;
	}

	public void setEhelptypeService(EhelptypeService ehelptypeService) {
		this.ehelptypeService = ehelptypeService;
	}

}
