/** Operation for DB
 *  Copyright (C) 2015 THU DAVIS
 *  @author Davis
 *  @version 1.0
 *  Created Time: 2015-04-16
 */
package org.evr.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DBOperation extends HibernateDaoSupport {

	private int pageSize; // 页面大小page size
	private int totalRec; // 总记录数 total record number
	private int pageCount; // 页数 page count
	private String pageStr; // 分页显示 page linker
	private String sqlString = "";
	private String sortStr = "";
	private static String fontHead = "<font color='#ff7103'><b>"; // display
	private static String fontTail = "</b></font>"; // display after the page
													// linker
	private static Logger log = Logger.getLogger(DBOperation.class.getName());
	/**
	 * Constructor, set default values for fields
	 */
	public DBOperation() {
		pageSize = 5;
		pageStr = "";
	}
	
	public List getAll(String sql) {
		List lists = null;
		//构造SQL查询语句
		if (sqlString.length() > 0){
			if(sql.indexOf("where")!=-1)
				sql += " and " + sqlString;
			else
				sql +=	" where " + sqlString;
		}
		if ((sortStr != null) && !sortStr.equals(""))
			sql += " order by " + sortStr;
		System.out.println("DYS Debug Info: " + sql);
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(sql);
		lists = query.list();
		session.close();
		return lists;
	}
	
	public Collection getAll(String sql, int iPage) {
		List lists = null;
		// 获取记录数
		if (sqlString.length() > 0){
			if(sql.indexOf("where")!=-1)
				sql += " and " + sqlString;
			else
				sql +=	" where " + sqlString;
		}
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		lists = session.createQuery("select count(*) " + sql).list();
		if(sql.indexOf("group by") < 0)
			totalRec = Integer.parseInt(lists.get(0).toString());
		else
			totalRec = lists.size();
		lists.clear();
		// 设置分页信息
		pageCount = totalRec / pageSize + ((totalRec % pageSize) > 0 ? 1 : 0);
		if(sortStr !=null && !sortStr.equals(""))
			sql += " order by " + sortStr;
		Query query = session.createQuery(sql);

		int limit = 0;
		if (iPage > 0)
			limit = pageSize * (iPage - 1);
		if (iPage > pageCount)
			limit = pageSize * (pageCount - 1);
		setPageStr(iPage);
		limit = limit < 0 ? 0 : limit;
		query.setFirstResult(limit);
		query.setMaxResults(pageSize);
		lists = query.list();
		session.close();
		return lists;
	}
	
	public Collection getSysAll(String sql, int iPage) {
		List lists = null;
		// 获取记录数
		if (sqlString.length() > 0){
			if(sql.indexOf("where")!=-1)
				sql += " and " + sqlString;
			else
				sql +=	" where " + sqlString;
		}
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		
		lists = session.createQuery("select count(*) " + sql).list();
		if(sql.indexOf("group by") < 0)
			totalRec = Integer.parseInt(lists.get(0).toString());
		else
			totalRec = lists.size();
		lists.clear();
		// 设置分页信息
		pageCount = totalRec / pageSize + ((totalRec % pageSize) > 0 ? 1 : 0);
		if(sortStr !=null && !sortStr.equals(""))
			sql += " order by " + sortStr;
		System.out.println("DYS DEBUG INFO:"+sql);
		Query query = session.createQuery(sql);

		int limit = 0;
		if (iPage > 0)
			limit = pageSize * (iPage - 1);
		if (iPage > pageCount)
			limit = pageSize * (pageCount - 1);
		setSysPageStr(iPage);
		setPageCount(pageCount);
		limit = limit < 0 ? 0 : limit;
		query.setFirstResult(limit);
		query.setMaxResults(pageSize);
		lists = query.list();
		session.close();
		return lists;
	}
	
	public List getTop(String sql, int count)
	{
		List lists = null;
		Query query = getSession().createQuery(sql);
		query.setMaxResults(count);
		lists = query.list();
		System.out.println("DYS Debug Info: " + sql);
		return lists;
	}
	
	public List getByHql(String sql)
	{
		List lists = null;
		Query query = getSession().createQuery(sql);
		lists = query.list();
		
		return lists;
	}
	
	public Object getInfo(Class objectClass, String key) {
		return getHibernateTemplate().get(objectClass, key);
	}
	
	public Object getInfo(Class objectClass, Integer key) {
		return getHibernateTemplate().get(objectClass, key);
	}
	
	public void update(Object object) throws Exception {
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void delete(Class objectClass, String key) {
		getHibernateTemplate().delete(
		getHibernateTemplate().get(objectClass, key));
	}
	
	public void delete(Object entity){
		getHibernateTemplate().delete(entity);
	}
	
	public int deleteAll(String tableName, String keyID, Object[] objects) {
		String hql = "delete from " + tableName + " where " + keyID
				+ " in (:objects)";
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		int returnCode = query.setParameterList("objects", objects).executeUpdate();
		session.close();
		return returnCode;
	}

	public List getBySql(String sql)
	{
		List lists = null;
		Query query = getSession().createSQLQuery(sql);
		lists = query.list();
		return lists;
	}
	
	public List getBySql(String sql, int count)
	{
		List lists = null;
		Query query = getSession().createSQLQuery(sql);
		if(count > 0)
			query.setMaxResults(count);
		lists = query.list();
		return lists;
	}
	
	public int updateByHql(String hql) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		int returnCode = query.executeUpdate();
		session.close();
		return returnCode;
	}
	
	public int delBySql(String sql) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(sql);
		int returnCode = query.executeUpdate();
		session.close();
		return returnCode;
	}

	public void setPageStr(int iPage) {
		if (iPage > pageCount)
			iPage = pageCount;
		iPage = iPage < 1 ? 1 : iPage;

		pageStr = "<b>" + getColorStr(totalRec) + "</b> datas";
		pageStr += "　<b>" + getColorStr(iPage) + "</b>/<b>" + pageCount
				+ "</b>　<b>" + getColorStr(pageSize) + "</b>/page";

		int iStart = iPage - 5, iEnd;
		iStart = (iStart < 1) ? 1 : iStart;
		iEnd = iStart + 9;
		iEnd = (iEnd > pageCount) ? pageCount : iEnd;
		iStart = iEnd - 9;
		iStart = (iStart < 1) ? 1 : iStart;

		if ((iEnd > 0) && (iPage > 1))
			pageStr += "　<span onclick='gotoPage(1)' title='First Page' class='page_menu' "
					+ "onmouseover='this.style.color=\"#ff7103\"' onmouseout='this.style.color=\"#333333\"'>◀</span>";
		else
			pageStr += "　◀";
		for (; iStart <= iEnd; iStart++) {
			if (iStart == iPage)
				pageStr += "　" + getColorStr(iStart);
			else
				pageStr += "　<span onclick='gotoPage(" + iStart
						+ ")' title='page" + iStart + "' class='page_menu' "
						+ "onmouseover='this.style.color=\"#ff7103\"' onmouseout='this.style.color=\"#333333\"'>" + iStart + "</span>";
		}
		if ((iEnd > 0) && (iPage < iEnd))
			pageStr += "　<span onclick='gotoPage(" + pageCount
					+ ")' title='Last Page' class='page_menu' "
					+"onmouseover='this.style.color=\"#ff7103\"' onmouseout='this.style.color=\"#333333\"'>▶</span>";
		else
			pageStr += "　▶";
	}
	
	public void setSysPageStr(int iPage) {
		if (iPage > pageCount)
			iPage = pageCount;
		iPage = iPage < 1 ? 1 : iPage;

		pageStr = "共有<b>" + getColorStr(totalRec) + "</b>条数据";
		pageStr += "　<b>" + getColorStr(iPage) + "</b>/<b>" + pageCount
				+ "</b>　<b>" + getColorStr(pageSize) + "</b>条/页";

		int iStart = iPage - 5, iEnd;
		iStart = (iStart < 1) ? 1 : iStart;
		iEnd = iStart + 9;
		iEnd = (iEnd > pageCount) ? pageCount : iEnd;
		iStart = iEnd - 9;
		iStart = (iStart < 1) ? 1 : iStart;

		if ((iEnd > 0) && (iPage > 1))
			pageStr += "　<span onclick='gotoPage(1)' title='首页' class='page_menu' "
					+ "onmouseover='this.style.color=\"#ff7103\"' onmouseout='this.style.color=\"#333333\"'>◀</span>";
		else
			pageStr += "　◀";
		for (; iStart <= iEnd; iStart++) {
			if (iStart == iPage)
				pageStr += "　" + getColorStr(iStart);
			else
				pageStr += "　<span onclick='gotoPage(" + iStart
						+ ")' title='第" + iStart + "页' class='page_menu' "
						+ "onmouseover='this.style.color=\"#ff7103\"' onmouseout='this.style.color=\"#333333\"'>" + iStart + "</span>";
		}
		if ((iEnd > 0) && (iPage < iEnd))
			pageStr += "　<span onclick='gotoPage(" + pageCount
					+ ")' title='末页' class='page_menu' "
					+"onmouseover='this.style.color=\"#ff7103\"' onmouseout='this.style.color=\"#333333\"'>▶</span>";
		else
			pageStr += "　▶";
	}
	
	// 增加删除流程模板deletePPAll和删除流程deleteProcess
	public int deletePPAll(String tableName, String fieldName, String name,
			String ccId) {
		String hql = "delete from " + tableName + " where " + fieldName + "='"
				+ name + "' and ccId='" + ccId + "'";
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		int returnCode = query.executeUpdate();
		session.close();
		return returnCode;
	}

	public int deleteProcess(String PIkey, String PIdArtNo, String ccId) {
		String hql = "delete from Process where PIkey='" + PIkey
				+ "' and PIdArtNo='" + PIdArtNo + "' and ccId='" + ccId + "'";
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		int returnCode = query.executeUpdate();
		session.close();
		return returnCode;
	}

	private String getColorStr(int inVal) {
		return fontHead + inVal + fontTail;
	}
	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1)
			this.pageSize = 20;
		else
			this.pageSize = pageSize;
	}

	public int getTotalRec() {
		return totalRec;
	}

	public void setTotalRec(int totalRec) {
		this.totalRec = totalRec;
	}

	public String getPageStr() {
		return pageStr;
	}

	public String getSqlString() {
		return sqlString;
	}

	public void setSqlString(String sqlString) {
		this.sqlString = sqlString;
	}

	public String getSortStr() {
		return sortStr;
	}

	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}

	public Object findList(Object obj){
		try {
			String hql = createHql(obj);
			List list = getHibernateTemplate().find(hql);
			if(list!=null){
				if(list.size()>0){
					return list;
				}else{
					return null;
				}
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Object findUnique(Object obj) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String hql = createHql(obj);
			Query query = session.createQuery(hql);
			List list = query.list();
			if(list!=null){
				if(list.size()>0){
					return list.get(0);
				}else{
					return null;
				}
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}

	private String createHql(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer hql = new StringBuffer("from ");
		Class<? extends Object> clazz = obj.getClass();
		hql.append(clazz.getName()+" e where e.");
		Field[] fields = clazz.getDeclaredFields();
		for (int i=0;i<fields.length;i++) {
			Object value = invokeMethod(obj, fields[i].getName(), null);
			if(value != null){
				if(i!=0 && !hql.toString().endsWith("e.")){
					hql.append(" and e.");
				}
				hql.append(fields[i].getName()+" = '"+value+"'");
			}
		}
		log.info("FindUnique>> "+hql.toString());
		return hql.toString();
	}

	private Object invokeMethod(Object owner, String methodName, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class ownerClass = owner.getClass();  
        methodName = methodName.substring(0, 1).toUpperCase()  
                + methodName.substring(1);  
        Method method = null;  
        try {  
            method = ownerClass.getMethod("get" + methodName);  
        } catch (SecurityException e) {  
        } catch (NoSuchMethodException e) {  
            return " can't find 'get" + methodName + "' method";  
        }  
        return method.invoke(owner);
	}
}