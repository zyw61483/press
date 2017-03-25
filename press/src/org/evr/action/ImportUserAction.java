package org.evr.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.evr.service.EuserService;

@SuppressWarnings({ "serial", "unchecked" })
public class ImportUserAction extends BaseAction {

	private File mobile;
	private String mobileFileName;
	private Integer count;
	private Integer month;
	protected EuserService euserService;

	public String initImportUser(){
		return "importUser";
	}
	
	public String importUser() {
		//euserService.importUsers(mobile,month,count);
		return "info_handle";
	}

	/***********************************************************************************************************************************/

	public File getMobile() {
		return mobile;
	}

	public void setMobile(File mobile) {
		this.mobile = mobile;
	}

	public String getMobileFileName() {
		return mobileFileName;
	}

	public void setMobileFileName(String mobileFileName) {
		this.mobileFileName = mobileFileName;
	}

	public EuserService getEuserService() {
		return euserService;
	}

	public void setEuserService(EuserService euserService) {
		this.euserService = euserService;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}

}
