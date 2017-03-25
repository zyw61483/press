package org.evr.action;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.evr.obj.Select;
import org.evr.obj.Structure;
import org.evr.service.StructureService;

public class StructureAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String tableName;
	private String fieldName;
	private String cnName;
	private String fieldType;
	private Integer isValid;
	private Integer[] ids;
	protected StructureService structureService;

	public StructureService getStructureService() {
		return structureService;
	}

	public void setStructureService(StructureService structureService) {
		this.structureService = structureService;
	}
	/**
	 * 获取指定表名的所有结构信息, 用于搜索使用
	 * @return
	 */
	public String getForSearch()
	{
		sortStr = "isValid asc";
		sqlString = "tableName='" + tableName + "' and isValid>0";
		saveParameter("isValid asc", structureService);
		Collection objects = structureService.getAll("from Structure");
		request.setAttribute("C_INFO_LIST", objects);
		setRequestPageInfo();
		setRequestTokenInfo(false);
		return "search";
	}
	/**********************************************************************************************/
	/**
	 * 数据初始化
	 * @return
	 */
	public String getAll() {
		String hql = "from Structure";
		saveParameter("id desc", structureService);
		structureService.setPageSize(50);
		Collection objects = structureService.getSysAll(hql, currentPage);
		request.setAttribute("C_INFO_LIST", objects);
		pageStr = structureService.getPagestr();
		setRequestPageInfo();
		return "structurelist";
	}

	/**
	 * 跳转新增页面
	 * @return
	 */
	public String structurePreAdd() {
		initstructureSelect();
		return "structureadd";
	}

	/**
	 * 初始化下拉框数据
	 */
	private void initstructureSelect() {
		Select select;
		List<Select> selecttype = new ArrayList();
		select = new Select();
		select.setValue("文本");
		select.setName("文本");
		selecttype.add(select);
		select = new Select();
		select.setValue("长文本");
		select.setName("长文本");
		selecttype.add(select);
		select = new Select();
		select.setValue("数字");
		select.setName("数字");
		selecttype.add(select);
		select = new Select();
		select.setValue("日期");
		select.setName("日期");
		selecttype.add(select);
		select = new Select();
		select.setValue("时间");
		select.setName("时间");
		selecttype.add(select);
		request.setAttribute("C_SELECT_FIELDTYPE", selecttype);
		List<Select> selectIsValid = new ArrayList();
		select = new Select();
		select.setValue("1");
		select.setName("1");
		selectIsValid.add(select);
		select = new Select();
		select.setValue("0");
		select.setName("0");
		selectIsValid.add(select);
		request.setAttribute("C_SELECT_ISVALID", selectIsValid);
	}

	/**
	 * 新增高级搜索信息
	 * @return
	 */
	public String structureAdd() {
		if (!isValidate(0)) {
			initstructureSelect();
			return "structureadd";
		}
		Structure temp = new Structure();
		temp.setId(id);
		temp.setTableName(tableName);
		temp.setFieldName(fieldName);
		temp.setCnName(cnName);
		temp.setFieldType(fieldType);
		temp.setIsValid(isValid);
		if (structureService.insert(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 跳转修改页面
	 * @return
	 */
	public String structurePreUpdate() {
		initstructureSelect();
		Structure object = null;
		try {
			object = (Structure) structureService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("C_OBJECT_INFO", object);
		return "structureupdate";
	}

	/**
	 * 修改高级搜索信息
	 * @return
	 */
	public String structureUpdate() {
		if (!isValidate(0)) {
			initstructureSelect();
			return "structureupdate";
		}
		Structure temp = null;
		try {
			temp = (Structure) structureService.getInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		temp.setTableName(tableName);
		temp.setFieldName(fieldName);
		temp.setCnName(cnName);
		temp.setFieldType(fieldType);
		temp.setIsValid(isValid);
		if (structureService.update(temp))
			random_token = "1";
		else
			random_token = "0";
		return "info_handle";
	}

	/**
	 * 删除高级搜索信息
	 * @return
	 */
	public String structureDel() {
		if (structureService.delete("id", ids) > 0)
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
		if (tableName.trim().equals("")) {
			returnCode = addFieldErrorInfo("tableName", "请输入表名！");
		}
		if (fieldName.trim().equals("")) {
			returnCode = addFieldErrorInfo("tableName", "请输入字段名！");
		}
		saveParameter("id asc", structureService);
		 Collection objects =
		 structureService.getAll("from Structure where tableName='"+tableName+"' and fieldName='"+fieldName+"' and id!="+id);
		 if(objects.size() > 0)
		 {
		 returnCode = addFieldErrorInfo("tableName", "该字段已经存在！");
		 }
		// 保存数据以用于子页面是否需要调整宽度和高度
		setRequestTokenInfo(returnCode);
		return returnCode;
	}
	/**********************************************************************************************/


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	
	// Property accessors

}
