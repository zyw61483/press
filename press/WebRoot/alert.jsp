<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
request.setAttribute("decorator", "none");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<html>
	<head>
		<LINK href="/css/adminstyle.css" type="text/css" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script language="JavaScript" src="/adminjs/childform.js" type="text/javascript"></script>
	</head>
<body onLoad="alertForm()">
<s:form method="post" name="frmOp">
<input type="hidden" name="random_token" id="random_token" value="_ALERT"/>
<table width="392" border="1" cellspacing="0" cellpadding="0" align="center" style="BORDER-COLLAPSE: collapse;background: #ffffff" bordercolor="#D7E0E7">
  <tr>
    <td>
      <table width="392" border="0" cellspacing="2" cellpadding="2">
        <tr> 
          <td width="60" height="58" align="center"><img src="/adminimages/alert_info.gif" width="38" height="38"></td>
          <td width="332" style="font-weight:bold;">${request.msg}</td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td height="42" bgcolor="#EDF3FC"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td>&nbsp;</td>
          <td width="100" align="center"> 
            <input id="btnOK" type="button" name="btnOK" value='确定' class="mybutton" onclick="window.parent.parent.clsForm();">
          </td>
          <td>&nbsp;</td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</s:form>
</body>
</html>