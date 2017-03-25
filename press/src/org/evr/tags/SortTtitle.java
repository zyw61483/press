package org.evr.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;

import com.opensymphony.xwork2.util.ValueStack;

public class SortTtitle extends UIBean {

	public SortTtitle(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	@Override
	protected String getDefaultTemplate() {
		return "sort_title";
	}
	
	/*要显示的中文名*/
	private String cnName;
	private String fieldName;
	private String sortStr;

	@Override
	public void evaluateParams() {
		super.evaluateParams();
		if (cnName != null) addParameter("cnName", findString(cnName));
		if (fieldName != null) addParameter("fieldName", findString(fieldName));
		if (sortStr != null) addParameter("sortStr", findString(sortStr));
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getSortStr() {
		return sortStr;
	}

	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}

}
