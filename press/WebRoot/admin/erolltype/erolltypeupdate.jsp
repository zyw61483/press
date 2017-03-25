<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
request.setAttribute("decorator", "none");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<HTML>
<HEAD>
<title><s:text name="evr"/></title>
<LINK href="/css/adminstyle.css" type="text/css" rel="stylesheet">
		<SCRIPT language="javascript" src="/adminjs/ajax_operation.js" type="text/javascript"></SCRIPT>
		<script language="JavaScript" src="/adminjs/action.js" type="text/javascript"></script>
		<script language="JavaScript" src="/adminjs/form.js" type="text/javascript"></script>
		<script language="JavaScript" src="/adminjs/childform.js" type="text/javascript"></script>
		<script language="JavaScript" src="/js.datePicker/WdatePicker.js" type="text/javascript"></script>
</HEAD>
<body onload="resizeFormStatus()">
<s:form action="ErolltypeAction_erolltypeUpdate.aspx" method="post" name="frmOp" enctype="multipart/form-data">
<input type="hidden" name="random_token" id="random_token" value='<s:property value="#request.C_PAGE_TOKEN"/>'/>
<s:if test="#request.C_OBJECT_INFO">
<s:iterator value="#request.C_OBJECT_INFO" status="struts"></s:iterator>
</s:if>
<s:hidden name="id"></s:hidden>
<s:hidden name="image"></s:hidden>
<s:hidden name="resource"></s:hidden>
<table width="900" border="0" cellspacing="0" cellpadding="0" align="center" id="outerTable" style="background:#ffffff">
  <tr>
    <td>
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="divFrame">
        <tr> 
          <td align="center"><s:fielderror><s:param>cexist</s:param></s:fielderror> 
            <table width="100%" border="0" cellspacing="2" cellpadding="2">
              <tr>
				<td align="right" class="divLine" height="40">轮播分类名</td>
				<td>
				<s:textfield id="item" name="item" cssStyle="width:800px;font-size:16px;"></s:textfield>
				<s:fielderror><s:param>item</s:param></s:fielderror>
				</td>
			  </tr>
              <tr>
				<td align="right" class="divLine" height="40">排序号</td>
				<td>
				<s:textfield id="seq" name="seq" cssStyle="width:800px;font-size:16px;" onkeyup="this.value=getNum(this.value)"></s:textfield>
				<s:fielderror><s:param>seq</s:param></s:fielderror>
				</td>
			  </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td height="50">
	    <table width="100%" border="0" cellspacing="0" cellpadding="0">
	    	<tr> 
	     		<td>&nbsp;</td>
	        	<td width="100" > 
	            <input type="button" value='保存数据' class="mybutton" title='保存数据' onClick="document.getElementById('Div_Loading_Bg').style.display='';frmOp.submit();">
	        	</td>
	        	<td width="100" align="center"> 
	            <input type="button" value='关闭窗口' class="mybutton" title='关闭窗口' onClick="closeForm()">
	        	</td>
	        	<td>&nbsp;</td>
	     	</tr>
	   	</table>
    </td>
  </tr>
</table>
<div id="Div_Loading_Bg" style="width:100%;height:100%;left:0;top:0;position:absolute;background:#eeeeee;filter:'alpha(opacity=30);opacity:0.3;-moz-opacity:0.10;';display:none;">
<table border="0" cellspacing="0" cellpadding="0" width="100%" height="100%">
	<tr>
		<td align="center" valign="middle">数据保存中...</td>
	</tr>
</table>
</div>
</s:form>
</body>
</html>