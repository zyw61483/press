<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="evr" uri="/crmTag"%>
<html>
	<head>
	</head>
<body>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="32" valign="top">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="11" background="/adminimages/m_box_t_l.gif"><img src="/adminimages/m_box_t_l.gif" width="11" height="32"></td>
					<td valign="bottom" background="/adminimages/main_title_bag.gif" class="main_title">用户表</td>
					<td valign="bottom" background="/adminimages/m_box_t_b.gif">&nbsp;</td>
					<td width="11" background="/adminimages/m_box_t_r.gif"><img src="/adminimages/m_box_t_r.gif" width="11" height="32"></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
	    <td height="30" background="/adminimages/m_box_title.gif" class="main_box_opt">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td style="font-weight:bold;font-size:16px;padding:0px 0px 0px 20px">&nbsp;</td>
					<td class="icon_add"><a href="javascript:euserNew()" class="menu">添加</a></td>
					<td class="icon_del"><a href="javascript:euserDelete(document.forms[0],'ids')" class="menu">删除</a></td>
					<td class="icon_sea"><a href="javascript:euserSearch()" class="menu">高级搜索</a></td>
					<td class="icon_fre"><a href="javascript:refreshCurr()" class="menu">刷新</a></td>
					<td width="10px">&nbsp;</td>
				</tr>
    		</table>
		</td>
  	</tr>
  	<tr>
    	<td class="main_box" align="center" valign="top" style="padding: 4px 4px 4px 4px">
	    	<div style="width:100%;height:100%;overflow:auto">
	    	<table border="1" width="100%" cellpadding="2" cellspacing="0" class="tableMainDetail">
	    		<tr>
	    			<td width="30" align="center" onclick="this.children[0].checked= !this.children[0].checked; selectAll(document.forms[0],'ids'); "><input type="checkbox" id="idall" name="idall" class="mycheckbox" onclick="this.checked= !this.checked "></td>
			        <td width="30" class="table_title" align="center">序号</td>
			        <td class="table_title" align="center"><evr:sort_title cnName="手机号" sortStr="${request.C_PAGE_SORT}" fieldName="name"/></td>
			        <td class="table_title"><evr:sort_title cnName="密码" sortStr="${request.C_PAGE_SORT}" fieldName="password"/></td>
			        <td class="table_title" ><evr:sort_title cnName="姓名" sortStr="${request.C_PAGE_SORT}" fieldName="realname"/></td>
			        <td class="table_title" ><evr:sort_title cnName="账户" sortStr="${request.C_PAGE_SORT}" fieldName="acount"/></td>
			        				        <td width="60" class="table_title" align="center">编辑</td>
		    	</tr>
		      	<s:if test="#request.C_INFO_LIST">
				<s:iterator value="#request.C_INFO_LIST" status="struts">
				<tr onmouseover="this.style.background='#FDFAC5'" onmouseout="this.style.background=''">
		      		<td align="center" onclick="this.children[0].checked= !this.children[0].checked "><input type="checkbox" name="ids" value="<s:property value='id'/>" class="mycheckbox" onclick="this.checked= !this.checked "></td>
		      		<td class="table_list" align="center"><s:property value="#struts.index + 1"/></td>
		      		<td class="table_list"><s:property value="name"/></td>
		      		<td class="table_list"><s:property value="password"/></td>
			        <td class="table_list"><s:property value="realname"/></td>
			        <td class="table_list"><s:property value="acount"/></td>
			        <td class="table_list" align="center" onclick="euserUpdate('<s:property value="id"/>')"><img src="/adminimages/icon_modify.gif" style="cursor:hand"></td>
			    </tr>
		      	</s:iterator>
				</s:if>
	    	</table>
	    	</div>
    	</td>
  	</tr>
  	<tr>
		<td class="main_box_detail_pages" style="padding: 4px 4px 4px 4px">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  		<tr>
		  			<td width="22" height="22" align="left"><img src='/adminimages/more_detail.gif' width="22" height="22"></td>
		    		<td class="pages_list" align="right"><s:property value="#request.C_PAGE_INFO" escape="false" /></td>
		  		</tr>
			</table>
		</td>
    </tr>
</table>
<input type="hidden" name="sqlString" id="sqlString" value="<s:property value="#request.C_PAGE_SQL"/>"/>
<input type="hidden" name="sortStr" id="sortStr" value="<s:property value="#request.C_PAGE_SORT"/>"/>
<input type="hidden" name="id" id="id" />
</body>
</html>