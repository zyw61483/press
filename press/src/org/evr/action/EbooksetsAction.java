package org.evr.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.evr.obj.Ebooksets;
import org.evr.obj.Ebooktype;
import org.evr.obj.Select;
import org.evr.service.EbooksetsService;
import org.evr.service.EbooktypeService;

@SuppressWarnings({ "serial", "unchecked" })
public class EbooksetsAction extends BaseAction {

	private Integer id;
	private String item;
	private String type;
	private Integer seq;
	private Integer[] ids;
	protected EbooksetsService ebooksetsService;
	protected EbooktypeService ebooktypeService;
	private Map<String,Object> map = new HashMap<String, Object>();

	private void initEbookTypeSelect() {
		List<Select> selecttype = new ArrayList();
		List<Ebooktype> tempList = (List<Ebooktype>) ebooktypeService.getAll("from Ebooktype");
		if(tempList!=null && tempList.size()>0){
			for (Ebooktype temp : tempList) {
				Select select = new Select();
				select.setValue(temp.getId().toString());
				select.setName(temp.getItem());
				selecttype.add(select);
			}
		}
		
		request.setAttribute("C_SELECT_TYPE", selecttype);
	}
	
	public String getAll() {
		String hql = "from Ebooksets";
		saveParameter("id desc", ebooksetsService);
		ebooksetsService.setPageSize(50);
		Collection objects = ebooksetsService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = ebooksetsService.getPagestr();
		setRequestPageInfo();
		return "ebooksetslist";
	}

	public String ebooksetsPreAdd() {
		initEbookTypeSelect();
		return "ebooksetsadd";
	}

	public String ebooksetsAdd() throws NumberFormatException, Exception {
		if (!isValidate(0)) {
			initEbookTypeSelect();
			return "ebooksetsadd";
		}
		Ebooksets temp = new Ebooksets();
		temp.setId(id);
		temp.setItem(item);
		if(map.get(type)==null){
			Ebooktype info = (Ebooktype)ebooktypeService.getInfo(Integer.parseInt(type));
			temp.setType(info.getItem());
		}else{
			temp.setType((String)map.get(type));
		}
		temp.setSeq(seq);
		if (ebooksetsService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String ebooksetsPreUpdate() {
		initEbookTypeSelect();
		Ebooksets object = null;
		try {
			object = (Ebooksets) ebooksetsService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "ebooksetsupdate";
	}

	/**
	 * 修改书籍类别信息
	 * @return
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public String ebooksetsUpdate() throws NumberFormatException, Exception {
		if (!isValidate(0)) {
			initEbookTypeSelect();
			return "ebooksetsupdate";
		}
		Ebooksets temp = null;
		try {
			temp = (Ebooksets) ebooksetsService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		temp.setItem(item);
		temp.setSeq(seq);
		if(map.get(type)==null){
			Ebooktype info = (Ebooktype)ebooktypeService.getInfo(Integer.parseInt(type));
			temp.setType(info.getItem());
		}else{
			temp.setType((String)map.get(type));
		}
		if (ebooksetsService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 删除书籍类别信息
	 * @return
	 */
	public String ebooksetsDel() {
		if (ebooksetsService.delete("id", ids) > 0)
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
		saveParameter("id asc", ebooksetsService);
		 Collection objects =
		 ebooksetsService.getAll("from Ebooksets where item='"+item+"' and id!="+id);
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

	public EbooksetsService getEbooksetsService() {
		return ebooksetsService;
	}

	public void setEbooksetsService(EbooksetsService ebooksetsService) {
		this.ebooksetsService = ebooksetsService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public EbooktypeService getEbooktypeService() {
		return ebooktypeService;
	}

	public void setEbooktypeService(EbooktypeService ebooktypeService) {
		this.ebooktypeService = ebooktypeService;
	}

}
