package org.evr.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.evr.obj.Ebook;
import org.evr.obj.Ebooktype;
import org.evr.obj.Select;
import org.evr.service.EbookService;
import org.evr.service.EbooksetsService;
import org.evr.service.EbooktypeService;
import org.evr.util.FileUtil;
import org.json.JSONObject;

import com.google.gson.JsonObject;

@SuppressWarnings({ "serial", "unchecked" })
public class EbookAction extends BaseAction {

	private Integer id;
	private String title;
	private String detail;
	private File resfile;
	private String resfileFileName;
	private String author;
	private String publisher;
	private String publishtime;
	private String sets;
	private String type;
	private String name;
	private String time;
	private String flag;
	private Integer browse;
	private Integer[] ids;
	protected EbookService ebookService;
	protected EbooktypeService ebooktypeService;
	protected EbooksetsService ebooksetsService;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	public String getInfo()
	{
		Object object = null;
		try {
			object = ebookService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "ebookinfo";
	}
	
	public void getSetsByType() throws IOException{
		try {
			if(map.get(type)==null){
				Ebooktype info = (Ebooktype)ebooktypeService.getInfo(Integer.parseInt(type));
				type = info.getItem();
			}else{
				type = (String) map.get(type);
			}
			response.getOutputStream().write(ebooksetsService.getSetsByType(type));
		} catch (Exception e) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("flag", false);
			map.put("msg", "查找类型失败");
			JSONObject jsonObject = new JSONObject(map);
			response.getOutputStream().write(jsonObject.toString().getBytes());
			e.printStackTrace();
		}
	}
	
	public String getAll() {
		String hql = "from Ebook";
		pageSize = 50;
		saveParameter("id desc", ebookService);
		ebookService.setPageSize(pageSize);
		Collection objects = ebookService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = ebookService.getPagestr();
		setRequestPageInfo();
		return "ebooklist";
	}

	public String ebookPreAdd() {
		initEbookSelect();
		return "ebookadd";
	}

	private void initEbookSelect() {
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
//		List<Select> selectsets = new ArrayList();
//		List<Ebooksets> setsList = (List<Ebooksets>) ebooksetsService.getAll("from Ebooksets");
//		if(tempList!=null && tempList.size()>0){
//			for (Ebooktype temp : tempList) {
//				Select select = new Select();
//				select.setValue(temp.getItem());
//				select.setName(temp.getItem());
//				selectsets.add(select);
//			}
//		}
		
		request.setAttribute("C_SELECT_TYPE", selecttype);
//		request.setAttribute("C_SELECT_SETS", selectsets);
	}

	public String ebookAdd() {
		if (!isValidate(0)) {
			initEbookSelect();
			return "ebookadd";
		}
//		String filename = flag+pathFileName.substring(pathFileName.indexOf("."));
//		String filename = FileUtil.yms.format(new Date())+resfileFileName.substring(resfileFileName.indexOf("."));
		Map<String, Object> map2 = null;
		if("音频".equals(type)||"视频".equals(type)){
			map2 = FileUtil.saveFile(resfile, resfileFileName, "ebooks","config");
		}else{
			map2 = FileUtil.saveImg(resfile, resfileFileName, "ebooks");
		}
		if(!(Boolean) map2.get("flag")){
			addFieldErrorInfo("path", (String) map2.get("errorMsg"));
			initEbookSelect();
			return "ebookadd";
		}
		HttpSession session = request.getSession();
		Ebook temp = new Ebook();
		temp.setId(id);
		temp.setTitle(title);
		temp.setFlag(flag);
		temp.setSets(sets);
		temp.setAuthor(author);
		temp.setDetail(detail);
		if(map.get(type)==null){
			Ebooktype info = (Ebooktype)ebooktypeService.getInfo(Integer.parseInt(type));
			temp.setType(info.getItem());
		}else{
			temp.setType((String)map.get(type));
		}
		temp.setResfile("/admin/ifiles/ebooks/"+resfileFileName);
		temp.setPublisher(publisher);
		temp.setPublishtime(publishtime);
		temp.setName((String)session.getAttribute("name"));
		temp.setBrowse(browse);
		if(time==null||"".equals(time))
			temp.setTime(FileUtil.ymd.format(new Date()));
		else
			temp.setTime(time);
		if (ebookService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String ebookPreUpdate() {
		initEbookSelect();
		Ebook object = null;
		try {
			object = (Ebook) ebookService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "ebookupdate";
	}

	public String ebookUpdate() {
		//数据校验
		if (!isValidate(0)) {
			initEbookSelect();
			return "ebookupdate";
		}
		Ebook temp = (Ebook) ebookService.getInfo(id);
		if(resfile!=null){
			Map map2 = null;
			if("音频".equals(type)||"视频".equals(type)){
				map2 = FileUtil.saveFile(resfile, resfileFileName, "ebooks","config");
			}else{
				map2 = FileUtil.saveImg(resfile, resfileFileName, "ebooks");
			}
			FileUtil.delFile(temp.getResfile());
			temp.setResfile("/admin/ifiles/ebooks/"+resfileFileName);
		}
		//更新书籍信息
		temp.setId(id);
		temp.setTitle(title);
		temp.setFlag(flag);
		temp.setAuthor(author);
		temp.setDetail(detail);
		if(map.get(type)==null){
			Ebooktype info = (Ebooktype)ebooktypeService.getInfo(Integer.parseInt(type));
			temp.setType(info.getItem());
		}else{
			temp.setType((String)map.get(type));
		}
		temp.setSets(sets);
		temp.setPublisher(publisher);
		temp.setPublishtime(publishtime);
		temp.setName((String)request.getSession().getAttribute("name"));
		temp.setBrowse(browse);
		if(time==null||"".equals(time))
			temp.setTime(FileUtil.ymd.format(new Date()));
		else
			temp.setTime(time);
		if (ebookService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	public String ebookDel() {
		for (Integer id : ids) {
			Ebook temp  = (Ebook) ebookService.getInfo(id);
			//删除封面图片
			FileUtil.delFile(temp.getResfile());
		}
		//删除书籍信息
		if (ebookService.delete("id", ids) > 0)
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
		saveParameter("id asc", ebookService);
		 Collection objects =
		 ebookService.getAll("from Ebook where flag='"+flag+"' and id!="+id);
		 if(objects.size() > 0)
		 {
		 returnCode = addFieldErrorInfo("flag", "该标识已经存在！");
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

	public EbookService getEbookService() {
		return ebookService;
	}

	public void setEbookService(EbookService ebookService) {
		this.ebookService = ebookService;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public EbooktypeService getEbooktypeService() {
		return ebooktypeService;
	}

	public void setEbooktypeService(EbooktypeService ebooktypeService) {
		this.ebooktypeService = ebooktypeService;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getResfile() {
		return resfile;
	}

	public void setResfile(File resfile) {
		this.resfile = resfile;
	}

	public String getResfileFileName() {
		return resfileFileName;
	}

	public void setResfileFileName(String resfileFileName) {
		this.resfileFileName = resfileFileName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public Integer getBrowse() {
		return browse;
	}

	public void setBrowse(Integer browse) {
		this.browse = browse;
	}

	public String getName() {
		return name;
	}

	public String getSets() {
		return sets;
	}

	public void setSets(String sets) {
		this.sets = sets;
	}

	public EbooksetsService getEbooksetsService() {
		return ebooksetsService;
	}

	public void setEbooksetsService(EbooksetsService ebooksetsService) {
		this.ebooksetsService = ebooksetsService;
	}

}
