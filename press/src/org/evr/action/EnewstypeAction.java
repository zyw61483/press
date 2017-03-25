/** Action for enewstype
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.action;

import java.util.Collection;

import org.evr.obj.Enewstype;
import org.evr.service.EnewstypeService;

@SuppressWarnings({ "serial", "unchecked" })
public class EnewstypeAction extends BaseAction {

	private Integer id;
	private String item;
	private Integer seq;
	private Integer[] ids;
	protected EnewstypeService enewstypeService;

	public String getAll() {
		String hql = "from Enewstype";
		saveParameter("id desc", enewstypeService);
		enewstypeService.setPageSize(50);
		Collection objects = enewstypeService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = enewstypeService.getPagestr();
		setRequestPageInfo();
		return "enewstypelist";
	}

	public String enewstypePreAdd() {
		return "enewstypeadd";
	}

	public String enewstypeAdd() {
		if (!isValidate(0)) {
			return "enewstypeadd";
		}
		Enewstype temp = new Enewstype();
		temp.setId(id);
		temp.setItem(item);
		temp.setSeq(seq);
		if (enewstypeService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String enewstypePreUpdate() {
		Enewstype object = null;
		try {
			object = (Enewstype) enewstypeService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "enewstypeupdate";
	}

	/**
	 * 修改书籍类别信息
	 * @return
	 */
	public String enewstypeUpdate() {
		if (!isValidate(0)) {
			return "enewstypeupdate";
		}
		Enewstype temp = null;
		try {
			temp = (Enewstype) enewstypeService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		temp.setItem(item);
		temp.setSeq(seq);
		if (enewstypeService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 删除书籍类别信息
	 * @return
	 */
	public String enewstypeDel() {
		if (enewstypeService.delete("id", ids) > 0)
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
		saveParameter("id asc", enewstypeService);
		 Collection objects = enewstypeService.getAll("from Enewstype where item='"+item+"' and id!="+id);
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

	public EnewstypeService getEnewstypeService() {
		return enewstypeService;
	}

	public void setEnewstypeService(EnewstypeService enewstypeService) {
		this.enewstypeService = enewstypeService;
	}

}
