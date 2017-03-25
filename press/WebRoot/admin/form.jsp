<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="Div_ChildForm" style="z-index:9999;width:100;height:100;left:450;top:200;color:#871d2f;position:absolute;cursor:default;border:1px solid #871d2f;display:none" onmousedown="getFocus(this)">
	<table id="Div_DragForm" style="background:#871d2f;height:26;width:100%;" border="0" cellspacing="0" cellpadding="0">
		<tr>
		  <td><span id="div_title" style="font-size:18px;font-weight:bold;padding-left:10px;color:#fcfcfc;width:100%;"></span></td>
		  <td align="center" width="25"><span style="font-size:20px;width:12;color:white;border-width:0px;color:white;font-weight:bold;cursor:hand;" title='Close' onclick="clsForm()">×</span></td>
		</tr>
	</table>
	<div id="Div_Content" style="line-height:14px;word-break:break-all;">
		<iframe id="Div_URL" name="Div_URL" src="#" style="width:100%;height:100%;scrolling:auto;FRAMEBORDER:no;border:0;marginheight:0"></iframe>
	</div>	
</div>
<div id="Div_ChildForm_Bg" style="width:100%;height:100%;left:0;top:0;position:absolute;background:#666666;opacity:0.5;*filter:'alpha(opacity=50);';">
<table border="0" cellspacing="0" cellpadding="0" width="100%" height="100%">
	<tr>
		<td height="400" align="center" valign="middle">数据载入中...</td>
	</tr>
	<tr>
		<td align="center" valign="middle">&nbsp;</td>
	</tr>
</table>
</div>