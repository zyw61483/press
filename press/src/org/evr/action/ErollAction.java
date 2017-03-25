
package org.evr.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.evr.obj.Ebook;
import org.evr.obj.Eroll;
import org.evr.obj.Erolltype;
import org.evr.obj.Select;
import org.evr.service.ErollService;
import org.evr.service.ErolltypeService;
import org.evr.util.FileUtil;

@SuppressWarnings({ "serial", "unchecked" })
public class ErollAction extends BaseAction {

	private Integer id;
	private String title;
	private File image;
	private String imageFileName;
	private String link;
	private String type;
	private String time;
	private Integer flag;
	private Integer browse;
	private Integer[] ids;
	protected ErollService erollService;
	protected ErolltypeService erolltypeService;
	
	public void rollDetail()
	{
		Eroll object = null;
		try {
			object = (Eroll) erollService.getInfo(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("info", object);
		client(map);
	}
	
	public String getInfo()	{
		Object object = null;
		try {
			object = erollService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "erollinfo";
	}
	
	public String getAll() {
		String hql = "from Eroll";
		saveParameter("id desc", erollService);
		erollService.setPageSize(50);
		Collection objects = erollService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = erollService.getPagestr();
		setRequestPageInfo();
		return "erolllist";
	}

	public String erollPreAdd() {
		initErollSelect();
		return "erolladd";
	}

	private void initErollSelect() {
		List<Select> selecttype = new ArrayList();
		List<Erolltype> tempList = (List<Erolltype>) erolltypeService.getAll("from Erolltype");
		if(tempList!=null && tempList.size()>0){
			for (Erolltype temp : tempList) {
				Select select = new Select();
				select.setValue(temp.getItem());
				select.setName(temp.getItem());
				selecttype.add(select);
			}
		}
		request.setAttribute("C_SELECT_TYPE", selecttype);
	}

	public String erollAdd() {
		if (!isValidate(0)) {
			initErollSelect();
			return "erolladd";
		}
		Map<String, Object> map = FileUtil.saveImg(image,imageFileName,"erolls");
		if(!(Boolean) map.get("flag")){
			addFieldErrorInfo("image", (String) map.get("errorMsg"));
			initErollSelect();
			return "erolladd";
		}
		Eroll temp = new Eroll();
		temp.setId(id);
		temp.setTitle(title);
		temp.setLink(link);
		temp.setType(type);
		temp.setName((String)request.getSession().getAttribute("name"));
		temp.setTime(time);
		temp.setFlag(flag);
		temp.setBrowse(browse);
		temp.setImage("/admin/ifiles/erolls/"+map.get("imgName"));
		if (erollService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String erollPreUpdate() {
		initErollSelect();
		Eroll object = null;
		try {
			object = (Eroll) erollService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "erollupdate";
	}
	public String erollUpdate() {
		if (!isValidate(0)) {
			initErollSelect();
			return "erollupdate";
		}
		Eroll temp = (Eroll) erollService.getInfo(id);
		if(image!=null){
			//保存新缩略图
			Map<String, Object> map = FileUtil.saveImg(image,imageFileName,"erolls");
			if(!(Boolean) map.get("flag")){
				addFieldErrorInfo("image", (String) map.get("errorMsg"));
				initErollSelect();
				return "erollupdate";
			}
			//删除原来的缩略图
			FileUtil.delFile(temp.getImage());
			temp.setImage("/admin/ifiles/erolls/"+map.get("imgName"));
		}
		temp.setId(id);
		temp.setTitle(title);
		temp.setLink(link);
		temp.setType(type);
		temp.setName((String)request.getSession().getAttribute("name"));
		temp.setTime(time);
		temp.setFlag(flag);
		temp.setBrowse(browse);
		if (erollService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String erollDel() {
		//删除缩略图
		for (Integer id : ids) {
			Eroll temp  = (Eroll) erollService.getInfo(id);
			FileUtil.delFile(temp.getImage());
		}
		//删除新闻信息
		if (erollService.delete("id", ids) > 0)
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
		if (title.trim().equals("")) {
			returnCode = addFieldErrorInfo("title", "请输入标题！");
		}
		saveParameter("id asc", erollService);
		 Collection objects =
		 erollService.getAll("from Eroll where title='"+title+"' and id!="+id);
		 if(objects.size() > 0)
		 {
		 returnCode = addFieldErrorInfo("name", "该标题已经存在！");
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

	public ErollService getErollService() {
		return erollService;
	}

	public void setErollService(ErollService erollService) {
		this.erollService = erollService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getBrowse() {
		return browse;
	}

	public void setBrowse(Integer browse) {
		this.browse = browse;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public ErolltypeService getErolltypeService() {
		return erolltypeService;
	}

	public void setErolltypeService(ErolltypeService erolltypeService) {
		this.erolltypeService = erolltypeService;
	}

}
