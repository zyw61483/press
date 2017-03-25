<%@ page language="java" pageEncoding="UTF-8"%>
<%
request.setAttribute("decorator", "none");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="dys" uri="/crmTag"%>
<html>
<head>
<title>My97DatePicker</title>
<script type="text/javascript" src="config.js"></script>
<script>
if(parent==window)
	location.href = 'http://www.my97.net';
var $d, $dp, $pdp = parent.$dp, $dt, $tdt, $sdt, $IE=$pdp.ie, $FF = $pdp.ff,$OPERA=$pdp.opera, $ny, $cMark = false;
if ($pdp.eCont) {
	$dp = {};
	for (var p in $pdp) {
		$dp[p] = $pdp[p];
	}
}
else
	$dp = $pdp;
	
$dp.getLangIndex = function(name){
	var arr = langList;
	for (var i = 0; i < arr.length; i++) {
		if (arr[i].name == name) {
			return i;
		}
	}
	return -1;
}

$dp.getLang = function(name){
	var index = $dp.getLangIndex(name);
	if (index == -1) {
		index = 0;
	}
	return langList[index];
}
$dp.realLang = $dp.getLang('<s:property value="#session.WW_TRANS_I18N_LOCALE"/>');
document.write("<script src='lang/" + $dp.realLang.name + ".js' charset='" + $dp.realLang.charset + "'><\/script>");

for (var i = 0; i < skinList.length; i++) {
    document.write('<link rel="stylesheet" type="text/css" href="skin/' + skinList[i].name + '/datepicker.css" title="' + skinList[i].name + '" charset="' + skinList[i].charset + '" disabled="true"/>');
}
</script>
<script type="text/javascript" src="calendar.js"></script>
</head>
<body leftmargin="0" topmargin="0" onload="$c.autoSize()" tabindex=0>
</body>
</html>
<script>new My97DP();</script>