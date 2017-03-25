var httpReq = createAjaxObj();

function createAjaxObj(){
  var httprequest=false;
  if (window.XMLHttpRequest)
  { 
    httprequest=new XMLHttpRequest()
    if (httprequest.overrideMimeType)
      httprequest.overrideMimeType('text/xml')
   }
   else if (window.ActiveXObject)
   { 
     try {
       httprequest=new ActiveXObject("Msxml2.XMLHTTP");
     }
     catch (e){
       try{
          httprequest=new ActiveXObject("Microsoft.XMLHTTP");
       }
       catch (e){}
     }
   }
   return httprequest
}

function getDetail(url, type) {
	//将请求使用的URL暂时保留，刷新时使用	
	
	if(type == 0) {
		document.forms[0].lastRequest.value = url;
		//初始调用时动态加载JS的SRC
		//reloadJS(url);
	}	
	else{
		url = "" + document.forms[0].lastRequest.value;
		if(url.indexOf("?") < 0) url += "?";
		else url += "&";
		url += "id=" + document.forms[0].id.value;
		url += "&sqlString=" + encodeURI(document.forms[0].sqlString.value);
		url += "&sortStr=" + document.forms[0].sortStr.value;
	}
	searchServer(url, "_Spacework");
}

function searchServer(url, divName) {
	httpReq = createAjaxObj();
	showLoading();
	if(url.indexOf("?") < 0) url += "?";
	else url += "&";
	url += "random_token=" + Math.uuid();
	url = encodeURI(url);
	httpReq.open("GET", url, false);
	httpReq.onreadystatechange = function(){reqCallback(divName)}; 
	httpReq.send(null);
}

function reqCallback(divName) {
	if (httpReq.readyState < 4 ) {
		document.getElementById(divName).innerHTML = "数据载入中...";
	}else if (httpReq.readyState == 4) {	
		document.getElementById(divName).innerHTML = httpReq.responseText;
		hideLoading();
	}
}

function showLoading(){
	var bgDiv = window.parent.document.getElementById("Div_ChildForm_Bg");
	if (bgDiv != null) {
		if(bgDiv.style.width == "400px"){
			var bodySize = getBodySize();
			with (bgDiv.style) {
				width = bodySize[0];
				height = bodySize[1];
			}
		}
		bgDiv.style.display = "";
	} else {
		var bgDiv = window.parent.document.createElement("Div_ChildForm");
		bgDiv.id = "Div_ChildForm_Bg";
		window.parent.document.body.appendChild(bgDiv);
		var bodySize = getBodySize();
		with (bgDiv.style) {
			position = "absolute";
			top = "0px";
			left = "0px";
			width = bodySize[0];
			height = bodySize[1];
			background = "#871d2f";
			filter = "alpha(opacity=30);opacity:1.5";
			padding = "35%";
			bgDiv.innerHTML = "<font color='#034D72'><b>数据载入中，请稍候...</b></font>";
		}
	}
}

function hideLoading() {
	window.parent.document.getElementById("Div_ChildForm_Bg").style.display = "none";
}

Math.uuid = (function() {
  // Private array of chars to use
  var CHARS = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split(''); 

  return function (len, radix) {
    var chars = CHARS, uuid = [];
    radix = radix || chars.length;

    if (len) {
      // Compact form
      for (var i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
    } else {
      // rfc4122, version 4 form
      var r;

      // rfc4122 requires these characters
      uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
      uuid[14] = '4';

      // Fill in random data.  At i==19 set the high bits of clock sequence as
      // per rfc4122, sec. 4.1.5
      for (var i = 0; i < 36; i++) {
        if (!uuid[i]) {
          r = 0 | Math.random()*16;
          uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
        }
      }
    }

    return uuid.join('');
  };
})();

function clsForm() {
	window.parent.document.getElementById("Div_ChildForm").style.display = "none";
	window.parent.document.getElementById("Div_ChildForm_Bg").style.display = "none";
	window.parent.document.getElementById("Div_ChildForm").style.display = "none";
	window.parent.document.getElementById("Div_ChildForm_Bg").style.display = "none";
}

/* 更改排序方式  2011-08-01 Davis*/
function changeSort(val) {
	document.forms[0].sortStr.value = val;
	getDetail("", 1);
}

function gotoPage(val) {
	url = "" + document.forms[0].lastRequest.value;
	if(url.indexOf("?") < 0) url += "?";
	url += "&id=" + document.forms[0].id.value;
	url += "&sqlString=" + document.forms[0].sqlString.value;
	url += "&sortStr=" + document.forms[0].sortStr.value;
	url += "&currentPage=" + val;
	searchServer(url, "_Spacework");
}

/* 刷新当前页面信息  2011-08-01 Davi*/
function refreshCurr(){
	getDetail("", 1);
}
function getBodySize() {
	var xScroll, yScroll; 
    
    if (window.innerHeight && window.scrollMaxY) {    
        xScroll = document.body.scrollWidth; 
        yScroll = window.innerHeight + window.scrollMaxY; 
    } else if (document.body.scrollHeight > document.body.offsetHeight){ 
        xScroll = document.body.scrollWidth; 
        yScroll = document.body.scrollHeight; 
    } else { 
        xScroll = document.body.offsetWidth; 
        yScroll = document.body.offsetHeight; 
    } 
    
    var windowWidth, windowHeight; 
    if (self.innerHeight) {   
        windowWidth = self.innerWidth; 
        windowHeight = self.innerHeight; 
    } else if (document.documentElement && document.documentElement.clientHeight) { 
        windowWidth = document.documentElement.clientWidth; 
        windowHeight = document.documentElement.clientHeight; 
    } else if (document.body) { 
        windowWidth = document.body.clientWidth; 
        windowHeight = document.body.clientHeight; 
    }    
    
   
    if(yScroll < windowHeight){ 
        pageHeight = windowHeight; 
    } else {  
        pageHeight = yScroll; 
    } 
  
    if(xScroll < windowWidth){    
        pageWidth = windowWidth; 
    } else { 
        pageWidth = xScroll; 
    }
    
    var bodySize = new Array(pageWidth,pageHeight,windowWidth,windowHeight)  
	return bodySize;
}