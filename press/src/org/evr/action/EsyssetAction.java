/** Action for esysset
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.evr.obj.Esysset;
import org.evr.obj.Select;
import org.evr.service.EsyssetService;

@SuppressWarnings({ "serial", "unchecked" })
public class EsyssetAction extends BaseAction {

	private Integer id;
	private String item;
	private Integer factor;
	private Integer[] ids;
	protected EsyssetService esyssetService;

	/**
	 * 数据初始化
	 * @return
	 */
	public String getAll() {
		String hql = "from Esysset";
		saveParameter("id desc", esyssetService);
		esyssetService.setPageSize(50);
		Collection objects = esyssetService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = esyssetService.getPagestr();
		setRequestPageInfo();
		return "esyssetlist";
	}

	/**
	 * 跳转新增页面
	 * @return
	 */
	public String esyssetPreAdd() {
		initEsyssetSelect();
		return "esyssetadd";
	}

	/**
	 * 初始化下拉框数据
	 */
	private void initEsyssetSelect() {
		Select select;
		List<Select> selecttype = new ArrayList();
		select = new Select();
		select.setValue("系数");
		select.setName("系数");
		selecttype.add(select);
		select = new Select();
		select.setValue("加入我们");
		select.setName("加入我们");
		selecttype.add(select);
		select = new Select();
		select.setValue("联系我们");
		select.setName("联系我们");
		selecttype.add(select);
		request.setAttribute("C_SELECT_TYPE", selecttype);
	}

	/**
	 * 新增系数信息
	 * @return
	 */
	public String esyssetAdd() {
		if (!isValidate(0)) {
			initEsyssetSelect();
			return "esyssetadd";
		}
		Esysset temp = new Esysset();
		temp.setId(id);
		temp.setItem(item);
		temp.setFactor(factor);
		if (esyssetService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 跳转修改页面
	 * @return
	 */
	public String esyssetPreUpdate() {
		initEsyssetSelect();
		Esysset object = null;
		try {
			object = (Esysset) esyssetService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "esyssetupdate";
	}

	/**
	 * 修改系数信息
	 * @return
	 */
	public String esyssetUpdate() {
		if (!isValidate(0)) {
			initEsyssetSelect();
			return "esyssetupdate";
		}
		Esysset temp = null;
		try {
			temp = (Esysset) esyssetService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		temp.setItem(item);
		temp.setFactor(factor);
		if (esyssetService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 删除系数信息
	 * @return
	 */
	public String esyssetDel() {
		if (esyssetService.delete("id", ids) > 0)
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
			returnCode = addFieldErrorInfo("title", "请输入标题！");
		}
		saveParameter("id asc", esyssetService);
		 Collection objects =
		 esyssetService.getAll("from Esysset where item='"+item+"' and id!="+id);
		 if(objects.size() > 0)
		 {
		 returnCode = addFieldErrorInfo("item", "该系数已经存在！");
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

	public Integer getFactor() {
		return factor;
	}

	public void setFactor(Integer factor) {
		this.factor = factor;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public EsyssetService getEsyssetService() {
		return esyssetService;
	}

	public void setEsyssetService(EsyssetService esyssetService) {
		this.esyssetService = esyssetService;
	}

}
