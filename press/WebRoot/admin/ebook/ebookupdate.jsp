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
		<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
		<script type="text/javascript" src="/ckfinder/ckfinder.js"></script>
		<script language="JavaScript" src="/adminjs/loadck.js" type="text/javascript"></script>
		<script language="JavaScript" src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				 getSets();
				 $("#type").change(function() {
					 getSets();
				 }); 
			})
			
			function getSets(){
				$("#sets").empty();
				$.ajax({ 
					url: "EbookAction_getSetsByType.aspx?", 
					contentType:"application/x-www-form-urlencoded; charset=UTF-8",
					datatype:"json",
					data:{type:$("#type").find("option:selected").val()},
					success: function(data){
						var dataObj=eval("("+data+")");
						if(dataObj.flag){
							for(var i=0;i<dataObj.list.length;i++){
				        		$("#sets").append("<option value="+dataObj.list[i].name+">"+dataObj.list[i].name+"</option>"); 
							}
						}
			    }});
			}
		</script>
</HEAD>
<body onload="resizeFormStatus()">
<s:form action="EbookAction_ebookUpdate.aspx" method="post" name="frmOp" enctype="multipart/form-data">
<input type="hidden" name="random_token" id="random_token" value='<s:property value="#request.C_PAGE_TOKEN"/>'/>
<s:if test="#request.C_OBJECT_INFO">
<s:iterator value="#request.C_OBJECT_INFO" status="struts"></s:iterator>
</s:if>
<s:hidden name="id"></s:hidden>
<s:hidden name="resource"></s:hidden>
<table width="900" border="0" cellspacing="0" cellpadding="0" align="center" id="outerTable" style="background:#ffffff">
  <tr>
    <td>
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="divFrame">
       		 <tr>
				<td align="right" class="divLine" height="40">标题</td>
				<td>
				<s:textfield id="title" name="title" cssStyle="width:800px;font-size:16px;"></s:textfield>
				<s:fielderror><s:param>title</s:param></s:fielderror>
				</td>
			  </tr>
			  <tr>
				<td align="right" class="divLine" height="40">资源文件</td>
				<td>
				<s:file id="resfile" name="resfile" cssStyle="width:800px;font-size:16px;" contenteditable="false"></s:file>
	            <s:fielderror><s:param>resfile</s:param></s:fielderror>
				</td>
			  </tr>
			  <tr>
				<td align="right" class="divLine" height="40">作者</td>
				<td>
				<s:textfield id="author" name="author" cssStyle="width:800px;font-size:16px;"></s:textfield>
				<s:fielderror><s:param>author</s:param></s:fielderror>
				</td>
			  </tr>		  
              <tr>
				<td align="right" class="divLine" height="40">出版社</td>
				<td>
				<s:textfield id="publisher" name="publisher" cssStyle="width:800px;font-size:16px;"></s:textfield>
				<s:fielderror><s:param>publisher</s:param></s:fielderror>
				</td>
			  </tr>
              <tr>
				<td align="right" class="divLine" height="40">出版时间</td>
				<td>
				<s:textfield id="publishtime" name="publishtime" cssStyle="width:800px;font-size:16px;"></s:textfield>
				<s:fielderror><s:param>publishtime</s:param></s:fielderror>
				</td>
			  </tr>
			  <tr>
				<td align="right" class="divLine" height="40">类别</td>
				<td>
				<s:select id="type" name="type" list="#request.C_SELECT_TYPE" listKey="value" listValue="name" cssStyle="font-size:16px"></s:select>
                <s:fielderror><s:param>type</s:param></s:fielderror>
				</td>
			  </tr>
			   <tr>
				<td align="right" class="divLine" height="40">系列</td>
				<td>
				<select id="sets" name="sets" Style="font-size:16px"></select>
                <%-- <s:fielderror><s:param>type</s:param></s:fielderror> --%>
				</td>
			  </tr>
			  <%-- <tr>
				<td align="right" class="divLine" height="40">发布者</td>
				<td>
				<s:textfield id="name" name="name" cssStyle="width:800px;font-size:16px;"></s:textfield>
                <s:fielderror><s:param>name</s:param></s:fielderror>
				</td>
			  </tr> --%>
			  <tr>
				<td align="right" class="divLine" height="40">置顶</td>
				<td>
				<s:textfield id="flag" name="flag" cssStyle="width:800px;font-size:16px;"></s:textfield>
				<s:fielderror><s:param>flag</s:param></s:fielderror>
				</td>
			  </tr>
			  <tr>
			    <td align="right" class="divLine" height="40">简介</td>
				<td>
				<s:textarea id="detail" name="detail" cssStyle="width:800px;height:300px;font-size:16px;"></s:textarea>
		        <s:fielderror><s:param>detail</s:param></s:fielderror>
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