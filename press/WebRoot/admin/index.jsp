<%@ page language="java" pageEncoding="UTF-8"%>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title><s:text name="evr"/></title>
		<LINK href="/css/adminstyle.css" type="text/css" rel="stylesheet">
		<SCRIPT language="javascript" src="/adminjs/ajax_operation.js" type="text/javascript"></SCRIPT>
		<script language="JavaScript" src="/adminjs/action.js" type="text/javascript"></script>
	</head>
<body bgcolor="#eeeeee" onselectstart="return false" oncontextmenu="return false">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr> 
    <td align="center" valign="middle">
    <s:form method="post" name="frmOp">
      <table width="627" border="0" cellspacing="0" cellpadding="0" background="/adminimages/login_bag.gif" height="460">
        <tr>
          <td valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td height="48" valign="bottom">
                  <table width="627" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td width="67" height="41">&nbsp;</td>
                      <td class="user_login">用户登录</td>
                      <td width="98">&nbsp;</td>
                    </tr>
                  </table>
                </td>
              </tr>
              <tr> 
                <td height="140" align="center">&nbsp;</td>
              </tr>
              <tr> 
                <td height="30" align="center"><s:fielderror><s:param>cexist</s:param></s:fielderror>&nbsp;</td>
              </tr>
              <tr> 
                <td> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td width="110" height="60">&nbsp;</td>
                      <td width="80" class="login_intro" align="center">用户名</td>
                      <td><s:textfield id="name" name="name" cssStyle="width:250px;height:22px;" onkeydown="onLogin(event)" autocapitalize="off"></s:textfield></td>
                      <td>&nbsp;</td>
                    </tr>
                  </table>
                </td>
              </tr>
              <tr> 
                <td> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="110" height="60">&nbsp;</td>
                      <td width="80" class="login_intro" align="center">密　码</td>
                      <td><s:password id="password" name="password" cssStyle="width:250px;height:22px;" onkeydown="onLogin(event)"></s:password></td>
                      <td>&nbsp;</td>
                    </tr>
                  </table>
                </td>
              </tr>
              <tr> 
                <td height="80" valign="middle"> 
                  <table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="190"></td>
                      <td width="77" height="27" onclick="onLoginSub()" background="/adminimages/logon.gif" class="bt_icon_logon">&nbsp;&nbsp;登 录</td>
                      <td width="10">&nbsp;</td>
                      <td width="77" height="27" onclick="window.close()" background="/adminimages/logout.gif" class="bt_icon_logon">&nbsp;&nbsp;退 出</td>
                      <td width="10">&nbsp;</td>
                      <td width="77" height="27" >&nbsp;</td>
                      <td>&nbsp;</td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      </s:form>
    </td>
  </tr>
</table>
</body>
</html>