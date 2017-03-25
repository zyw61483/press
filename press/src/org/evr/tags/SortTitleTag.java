package org.evr.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

public class SortTitleTag extends AbstractUITag {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SortTitleTag() {
		super();
	}
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		return new SortTtitle(stack, request,response);
	}
	private String cnName;
	private String fieldName;
	private String sortStr;
	
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	@Override
	protected void populateParams() {
		super.populateParams();
		SortTtitle sortTitle = (SortTtitle)component;
		/**
		 * 开始数据处理
		 */
		sortStr = sortStr.toLowerCase();
		fieldName = fieldName.toLowerCase();
		if(sortStr.indexOf(fieldName) >= 0)
		{
			if(sortStr.endsWith("asc")) { sortStr = fieldName + " desc"; fieldName = "▲";}
			else { sortStr = fieldName + " asc"; fieldName = "▼"; }
		}
		else
		{
			sortStr = fieldName + " asc";
		}
		sortTitle.setCnName(cnName);
		sortTitle.setSortStr(sortStr);
		if(fieldName.length() == 1)	sortTitle.setFieldName(fieldName);
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
