<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	</head>
<body>
<s:if test="#request.C_OBJECT_INFO">
<s:iterator value="#request.C_OBJECT_INFO" status="struts"></s:iterator>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="info_list"><s:property value="detail" escape="false"/>&nbsp;</td>
	</tr>
</table>
</s:if>
</body>
</html>