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
<TITLE>高级搜索</TITLE>
<LINK href="/admincss/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/adminjs/dateTimePicker.js"></script>
<script type="text/javascript" src="/adminjs/form.js"></script>
<script type="text/javascript" src="/adminjs/childform.js"></script>
<script type="text/javascript" src="/js.datePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/adminjs/search.js"></script>
</HEAD>
<BODY onload="resizeFormStatus()">
<br>
<s:form action="StructureAction_getForSearch.aspx" method="post" name="frmOp"> 

<input type="hidden" name="random_token" id="random_token" value=""/>
<input type="hidden" name="fieldName" id="fieldName"/>
<input type="hidden" name="fieldType" id="fieldType"/>
<input type="hidden" name="conditions" id="conditions"/>
<table width="580" border="0" cellspacing="0" cellpadding="0" align="center" style="background:#ffffff">
  <tr>
    <td>
      <table width="580" border="0" cellspacing="0" cellpadding="0" align="center">     
        <tr> 
          <td width="220" valign="top" height="260">
            <div style="width:100%;height:100%;overflow:auto"> 
              <table width="100%" border="1" cellspacing="1" cellpadding="0" class="tableMainDetail">
                <tr> 
                  <td height="24" class="displayTitle">列名</td>
                  <td width="50" class="displayTitle">类型</td>
                </tr>
                <s:if test="#request.C_INFO_LIST"> <s:iterator value="#request.C_INFO_LIST" status="struts">
                <tr style="cursor:hand" ondblclick="changeSearch('<s:property value='fieldName'/>','<s:property value='cnName'/>','<s:property value='fieldType'/>')" onmouseover="this.style.background='#FDFAC5'" onmouseout="this.style.background=''" title='双击选择'> 
                  <td height="24"><s:property value='cnName'/></td>
                  <td><s:property value='fieldType'/></td>
                </tr>
                </s:iterator></s:if>
              </table>
            </div>
          </td>
          <td width="10">&nbsp;</td>
          <td valign="top" align="center"> 
            <div style="width:100%;height:100%;overflow:auto">
              <table width="100%" border="1" cellspacing="1" cellpadding="0" class="tableMainDetail" id="conditionTable">
                <tr> 
                  <td height="24" class="displayTitle">已选择条件</td>
                  <td width="40" class="displayTitle" align="center">删除</td>
                </tr>
              </table>
			</div>
          </td>
        </tr>         
      </table>
    </td>
  </tr>
  <tr> 
    <td>
      <hr size=1 color="#666666">
    </td>
  </tr>
  <tr> 
    <td height="30"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="185"> 
            <input type="text" name="selectRow" id="selectRow" readonly value="选择条件 &gt;&gt;&gt;" style="padding-top:1px;font-weight:bold;width:180px;height:22px;background:#CCCCCC">
          </td>
          <td width="65"> 
            <select name="conOpe" style="width:60px;">
            </select>
          </td>
          <td> 
            <input type="text" name="conStr" maxlength="30" id="conStr" style="padding-top:1px;COLOR:#034D72;font-weight:bold;width:275px;height:22px;background:#fff url(/css/magnifier.gif) no-repeat right">
          </td>
          <td width="50"> 
            <select name="conJoin" style="width:50px;">
              <option value="AND" selected>并且</option>
              <option value="OR">或者</option>
            </select>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr> 
    <td>
      <hr size=1 color="#666666">
    </td>
  </tr>
  <tr> 
    <td height="42"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><div id="_Message" style="font-weight:bold;color='#FF0000'">&nbsp;</div></td>
          <td width="90"> 
            <input type="button" name="btnAdd" value='添加条件' class="mybutton" title='添加条件' onClick="searchAdd()">
          </td>
          <td width="90"> 
            <input type="button" name="btnClear" value='清空条件' class="mybutton" title='清空条件' onClick="searchClear()">
          </td>
          <td align="right" width="110"> 
            <input type="button" name="btnSearch" value='开始搜索' class="mybutton" title='开始搜索' onClick="searchOK()">
          </td>
          <td align="right" width="90"> 
            <input type="button" name="btnClose" value='关闭窗口' class="mybutton" title='关闭窗口' onClick="window.parent.parent.clsForm()">
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</s:form>
</BODY>
</HTML>