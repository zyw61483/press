<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
request.setAttribute("decorator", "none");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<html>
	<head>
	</head>
	<body onLoad="window.top.refreshCurr();window.top.clsForm();window.top.document.frames['_FSpacelogin'].searchServer('UserAction_login.aspx', '_Spacelogin');window.top.document.frames['_FSpacecart'].searchServer('CartAction_getCartCount.aspx', '_Spacecart');window.top.document.frmOp.target = '_top';">
	</body>
</html>
