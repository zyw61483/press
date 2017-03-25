<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
request.setAttribute("decorator", "none");
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<html>
	<head>
	
	</head>
	<body onLoad="window.parent.parent.refreshCurr();window.parent.parent.clsForm();">
	</body>
</html>
