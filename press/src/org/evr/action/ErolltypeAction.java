
package org.evr.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.evr.obj.Enewstype;
import org.evr.obj.Erolltype;
import org.evr.obj.Select;
import org.evr.service.ErolltypeService;

@SuppressWarnings({ "serial", "unchecked" })
public class ErolltypeAction extends BaseAction {

	private Integer id;
	private String item;
	private Integer seq;
	private Integer[] ids;
	protected ErolltypeService erolltypeService;
	
	public String getAll() {
		String hql = "from Erolltype";
		saveParameter("id desc", erolltypeService);
		erolltypeService.setPageSize(50);
		Collection objects = erolltypeService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = erolltypeService.getPagestr();
		setRequestPageInfo();
		return "erolltypelist";
	}

	public String erolltypePreAdd() {
		
		return "erolltypeadd";
	}

	public String erolltypeAdd() {
		if (!isValidate(0)) {
			
			return "erolltypeadd";
		}
		Erolltype temp = new Erolltype();
		temp.setId(id);
		temp.setItem(item);
		temp.setSeq(seq);
		if (erolltypeService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String erolltypePreUpdate() {
		
		Erolltype object = null;
		try {
			object = (Erolltype) erolltypeService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "erolltypeupdate";
	}

	public String erolltypeUpdate() {
		if (!isValidate(0)) {
			
			return "erolltypeupdate";
		}
		Erolltype temp = null;
		try {
			temp = (Erolltype) erolltypeService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		temp.setItem(item);
		temp.setSeq(seq);
		if (erolltypeService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}
	public String erolltypeDel() {
		if (erolltypeService.delete("id", ids) > 0)
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

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
		saveParameter("id asc", erolltypeService);
		 Collection objects =
		 erolltypeService.getAll("from Erolltype where item='"+item+"' and id!="+id);
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

	public ErolltypeService getErolltypeService() {
		return erolltypeService;
	}

	public void setErolltypeService(ErolltypeService erolltypeService) {
		this.erolltypeService = erolltypeService;
	}

}
