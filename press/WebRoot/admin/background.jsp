<%@ page language="java" pageEncoding="UTF-8"%>
<%
request.setAttribute("decorator", "none");
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="evr" uri="/crmTag"%>
<html>
	<head>
		<title><s:text name="evr"/></title>
		<LINK href="/admincss/style.css" type="text/css" rel="stylesheet">
		<SCRIPT language="javascript" src="/adminjs/ajax_operation.js" type="text/javascript"></SCRIPT>
		<script language="JavaScript" src="/adminjs/action.js" type="text/javascript"></script>
		<script language="JavaScript" src="/adminjs/form.js" type="text/javascript"></script>
		<script language="JavaScript" src="/adminjs/childform.js" type="text/javascript"></script>
		<script language="JavaScript" src="/adminjs/outlookmenu.js" type="text/javascript"></script>
	</head>
<body onLoad='hideLoading()'>
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
	<tr>
		<td>
			<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
			  <tr>
			  	<td width="167" id="_left_menu">
			  		<table width="167" height="100%" border="0" cellspacing="0" cellpadding="0">
			          <tr> 
			            <td height="15"><img src="/adminimages/left_top.gif" width="167" height="15"></td>
			          </tr>
			          <tr> 
			            <td height="100%" background="/adminimages/left_mid.gif" align="center" valign="top">
			            	<s:include value="left.jsp"></s:include>
						</td>
			          </tr>
			          <tr> 
			            <td height="15"><img src="/adminimages/left_bottom.gif" width="167" height="15"></td>
			          </tr>
			        </table>
			  	</td>
			  	<td width="16">
			  		<table width="16" height="100%" border="0" cellspacing="0" cellpadding="0">
			          <tr height="15"> 
			            <td><img src="/adminimages/box_left_top.gif" width="16" height="15"></td>
			          </tr>
			          <tr> 
			            <td background="/adminimages/box_left_mid.gif" valign="middle"><img src="/adminimages/arrow_left.gif" width="7" height="100" title='<s:text name="SystemBarCtrl_hide"/>' id="_SystemBarCtrl" onClick="switchSysBarl()" style="cursor:hand"></td>
			          </tr>
			          <tr height="15"> 
			            <td><img src="/adminimages/box_left_bottom.gif" width="16" height="15"></td>
			          </tr>
			        </table>
			  	</td>
			  	<td>
			  		<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
			          <tr height="15"> 
			            <td><img src="/adminimages/box_mid_top.gif" width="100%" height="15"></td>
			          </tr>
			          <tr> 
			            <td bgcolor="#efefef" valign="top">
			            <form action="" method="post" name="frmOp" style="width:100%; height:100%">
						<s:hidden name="lastRequest" id="lastRequest" value=""></s:hidden> 
			            <div id="_Spacework" style="width:100%; height:100%"></div>
			            </form>
			            </td>
			          </tr>
			          <tr height="15"> 
			            <td><img src="/adminimages/box_mid_bottom.gif" width="100%" height="15"></td>
			          </tr>
			        </table>
			  	</td>
			  	<td width="12">
			  		<table width="12" height="100%" border="0" cellspacing="0" cellpadding="0">
			          <tr height="15"> 
			            <td><img src="/adminimages/box_right_top.gif" width="12" height="15"></td>
			          </tr>
			          <tr> 
			            <td><img src="/adminimages/box_right_mid.gif" width="12" height="100%"></td>
			          </tr>
			          <tr height="15"> 
			            <td><img src="/adminimages/box_right_bottom.gif" width="12" height="15"></td>
			          </tr>
			        </table>
			  	</td>
			  </tr>
			</table>
		</td>
	</tr>
</table>
<s:include value="form.jsp"></s:include>
</body>
</html>