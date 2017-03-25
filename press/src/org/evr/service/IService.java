/** Service
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */

package org.evr.service;

import java.util.Collection;
import java.util.List;

import org.evr.util.DBOperation;

public abstract class IService {
	
	protected DBOperation operation; // 注入的操作类
	protected String pagestr = ""; // 页面分页信息
	protected int pageSize = 15; // 页面大小
	protected int currentPage = 1; // 当前面
	protected int pageCount = 1; // 当前面
	protected String sqlString = ""; // SQL语句
	protected String sortStr = ""; // 排序方式

	public List getAll(String sql){
		try {
			return operation.getAll(sql);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Collection getAll(String sql, int iPage){
		try {
			operation.setPageSize(pageSize);
			Collection list = operation.getAll(sql, iPage);
			setPagestr(operation.getPageStr());
			currentPage = iPage;
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Collection getSysAll(String sql, int iPage){
		try {
			operation.setPageSize(pageSize);
			Collection list = operation.getSysAll(sql, iPage);
			setPagestr(operation.getPageStr());
			setPageCount(operation.getPageCount());
			currentPage = iPage;
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Collection getByHql(String sql){
		try {
			return operation.getByHql(sql);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Collection getTop(String sql, int count){
		try {
			return operation.getTop(sql, count);
		} catch (Exception e) {
			return null;
		}
	}
	
	abstract public Object getInfo(String key) throws Exception;
	abstract public Object getInfo(Integer key) throws Exception;
	
	public boolean insert(Object object){
		try {
			operation.update(object);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Object object){
		try {
			operation.update(object);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	abstract public int delete(String keyID, Object[] objects) throws Exception;
	public boolean delete(Object object){
		try {
			operation.delete(object);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public Collection getBySql(String sql){
		try {
			return operation.getBySql(sql);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Collection getBySql(String sql, int count){
		try {
			return operation.getBySql(sql, count);
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean updateByHql(String hql){
		try {
			operation.updateByHql(hql);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean delBySql(String sql){
		try {
			operation.delBySql(sql);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public DBOperation getOperation() {
		return operation;
	}

	public void setOperation(DBOperation operation) {
		this.operation = operation;
	}

	public String getPagestr() {
		return pagestr;
	}

	public void setPagestr(String pagestr) {
		this.pagestr = pagestr;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.pageSize = this.pageSize == 0 ? 15 : this.pageSize;
		operation.setPageSize(this.pageSize);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {;
		this.currentPage = currentPage;
		this.currentPage = this.currentPage < 1 ? 1 : this.currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {;
		this.pageCount = pageCount;
		this.pageCount = this.pageCount < 1 ? 1 : this.pageCount;
	}
	
	public String getSqlString() {
		return sqlString;
	}

	public void setSqlString(String sqlString) {
		this.sqlString = sqlString;
		if (this.sqlString == null)
			this.sqlString = "";
		operation.setSqlString(this.sqlString);
	}

	public String getSortStr() {
		return sortStr;
	}

	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
		if (this.sortStr == null)
			this.sortStr = "";
		operation.setSortStr(this.sortStr);
	}
}
