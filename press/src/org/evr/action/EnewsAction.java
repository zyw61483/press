/** Action for enews
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.evr.obj.Enews;
import org.evr.obj.Enewstype;
import org.evr.obj.Select;
import org.evr.service.EnewsService;
import org.evr.service.EnewstypeService;
import org.evr.util.FileUtil;

@SuppressWarnings({ "serial", "unchecked" })
public class EnewsAction extends BaseAction {

	private Integer id;
	private String title;
	private File image;
	private String imageFileName;
	private String detail;
	private String type;
	private String time;
	private Integer flag;
	private Integer browse;
	private Integer[] ids;
	protected EnewsService enewsService;
	protected EnewstypeService enewstypeService;

	public void newsDetail()
	{
		Enews object = null;
		try {
			object = (Enews) enewsService.getInfo(id);
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
			object = enewsService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "enewsinfo";
	}
	
	/**
	 * 数据初始化
	 * @return
	 */
	public String getAll() {
		String hql = "from Enews";
		saveParameter("id desc", enewsService);
		enewsService.setPageSize(50);
		Collection objects = enewsService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = enewsService.getPagestr();
		setRequestPageInfo();
		return "enewslist";
	}

	/**
	 * 跳转新增页面
	 * @return
	 */
	public String enewsPreAdd() {
		initSelect();
		return "enewsadd";
	}

	private void initSelect() {
		List<Select> selecttype = new ArrayList();
		List<Enewstype> tempList = (List<Enewstype>) enewstypeService.getAll("from Enewstype");
		if(tempList!=null && tempList.size()>0){
			for (Enewstype temp : tempList) {
				Select select = new Select();
				select.setValue(temp.getItem());
				select.setName(temp.getItem());
				selecttype.add(select);
			}
		}
		request.setAttribute("C_SELECT_TYPE", selecttype);
	}

	/**
	 * 新增新闻管理信息
	 * @return
	 */
	public String enewsAdd() {
		if (!isValidate(0)) {
			initSelect();
			return "enewsadd";
		}
		Map<String, Object> map = FileUtil.saveImg(image,imageFileName,"enewss");
		if(!(Boolean) map.get("flag")){
			addFieldErrorInfo("image", (String) map.get("errorMsg"));
			initSelect();
			return "enewsadd";
		}
		Enews temp = new Enews();
		temp.setId(id);
		temp.setTitle(title);
		temp.setDetail(detail);
		temp.setType(type);
		temp.setTime(time);
		temp.setFlag(flag);
		temp.setBrowse(browse);
		temp.setImage("/admin/ifiles/enewss/"+map.get("imgName"));
		if (enewsService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 跳转修改页面
	 * @return
	 */
	public String enewsPreUpdate() {
		initSelect();
		Enews object = null;
		try {
			object = (Enews) enewsService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "enewsupdate";
	}

	/**
	 * 修改新闻管理信息
	 * @return
	 */
	public String enewsUpdate() {
		if (!isValidate(0)) {
			initSelect();
			return "enewsupdate";
		}
		Enews temp = (Enews) enewsService.getInfo(id);
		if(image!=null){
			//保存新缩略图
			Map<String, Object> map = FileUtil.saveImg(image,imageFileName,"enewss");
			if(!(Boolean) map.get("flag")){
				addFieldErrorInfo("image", (String) map.get("errorMsg"));
				initSelect();
				return "enewsupdate";
			}
			//删除原来的缩略图
			FileUtil.delFile(temp.getImage());
			temp.setImage("/admin/ifiles/enewss/"+map.get("imgName"));
		}
		//更新新闻信息
		temp.setId(id);
		temp.setTitle(title);
		temp.setDetail(detail);
		temp.setType(type);
		temp.setTime(time);
		temp.setFlag(flag);
		temp.setBrowse(browse);
		if (enewsService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 删除新闻管理信息
	 * @return
	 */
	public String enewsDel() {
		//删除缩略图
		for (Integer id : ids) {
			Enews temp  = (Enews) enewsService.getInfo(id);
			FileUtil.delFile(temp.getImage());
		}
		//删除新闻信息
		if (enewsService.delete("id", ids) > 0)
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
		if (title.trim().equals("")) {
			returnCode = addFieldErrorInfo("title", "请输入标题！");
		}
		saveParameter("id asc", enewsService);
		 Collection objects =
		 enewsService.getAll("from Enews where title='"+title+"' and id!="+id);
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

	public EnewsService getEnewsService() {
		return enewsService;
	}

	public void setEnewsService(EnewsService enewsService) {
		this.enewsService = enewsService;
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

	public EnewstypeService getEnewstypeService() {
		return enewstypeService;
	}

	public void setEnewstypeService(EnewstypeService enewstypeService) {
		this.enewstypeService = enewstypeService;
	}

}
