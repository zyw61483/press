var winwidth = 0, winheight = 0;
var divwidth = 0, divheight = 0;
var clientwidth = 0, clientheight = 0;
var pagewidth = 0, pageheight = 0;
var index = 10;
var hover = "#8a1831";
var ismove = false;

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

function createDiv(tit, href) {
	var bodySize = getBodySize();
	pagewidth = bodySize[0];
	pageheight= bodySize[1];
	winwidth = bodySize[2];
	winheight= bodySize[3];
	var Div = window.parent.document.getElementById("Div_ChildForm");
	var bgDiv = window.parent.document.getElementById("Div_ChildForm_Bg");
	var title = window.parent.document.getElementById("div_title");
	var url = window.parent.document.getElementById("Div_URL");
	bgDiv.style.width = bodySize[0];
	bgDiv.style.height = bodySize[1];
	title.innerHTML = tit;
	url.src = href;
	bgDiv.style.display = "";
	Div.style.display = "";
}

function popChange(i) {
	var login = window.parent.document.getElementById("Div_ChildForm");
	login.style.left = (document.body.scrollLeft+(winwidth - i * i *(login.style.width).substring(0,(login.style.width).length - 2) / 100) / 2) + "px";
	login.style.top = (document.body.scrollTop-30+(winheight - i * i *(login.style.height).substring(0,(login.style.height).length - 2) / 100) / 2) + "px";
	if (i < 10) {
		i++;
		setTimeout("popChange(" + i + ")", 10);
	}
	if(i == 10 && (((login.style.left).substring(0,(login.style.left).length - 2)+(login.style.width).substring(0,(login.style.width).length - 2)) * 1 > winwidth || 
					((login.style.top).substring(0,(login.style.top).length - 2)+(login.style.height).substring(0,(login.style.height).length - 2)) * 1 > winheight))
		setTimeout("popChange(" + 10 + ")", 10);
}

function Divshadow() {
	var div = window.parent.document.getElementById("Div_DragForm");
	var win = div.parentNode;
	div.style.backgroundColor = hover;
	win.style.borderColor = hover;
	div.nextSibling.style.color = hover;
}

function bulid(id, left, top, zIndex, title, url) {
	var div = "" 
	+ "<div id=" 
	+ id + " " 
	+ "style='" 	
	+ "z-index:10;" 
	+ "width:100;" 
	+ "height:100;" 
	+ "left:" + left + ";" 
	+ "top:" + top + ";" 
	+ "color:#fcfcfc;" 
	+ "position:absolute;" 
	+ "cursor:default;" 
	+ "border:2px solid " + hover + ";" + "' " 
	+ "onmousedown='getFocus(this)'>" 
	
	+ "<table id='Div_DragForm'" 
	+ "style='" 
	+ "background:#8a1831;height:26;width:100%;' "
	+ "border='0' cellspacing='0' cellpadding='0'" + "><tr><td>" 
	+ "<span id='div_title' style='font-size:18px;font-weight:bold;padding-left:10px;color:#fcfcfc;width:100%;'>" + title + "</span>" 
	+ "</td><td align='center' width='20'>"
	+ "<span style='font-size:20px;width:12;color:white;border-width:0px;color:white;font-weight:bold;cursor:hand;' title='关闭' onclick='clsForm()'>×</span>"
	+ "</td></tr></table>"

	+ "<div id='Div_Content' style='" 
	+ "line-height:14px;" 
	+ "word-break:break-all;" 
	+ "'><iframe id='Div_URL' name='Div_URL' src='" + url 
	+ "' style='width:100%;height:100%' scrolling=auto FRAMEBORDER=0'></iframe></div>" 
	+ "</div>" 
	
	+ "</div>";
	window.parent.document.body.insertAdjacentHTML("beforeEnd", div);
	createDiv(title, url);
	Divshadow();
}

function getFocus(obj) {
	index = index + 2;
	var idx = index;
	obj.style.zIndex = idx;
}

function startDrag(obj) {
	obj.setCapture();
	var div = obj.parentNode;
	x0 = window.parent.event.clientX;
	y0 = window.parent.event.clientY;
	x1 = window.parent.parseInt(div.style.left);
	y1 = window.parent.parseInt(div.style.top);
	ismove = true;
}

function stopDrag(obj) {
	obj.releaseCapture();
	ismove = false;
}

function drag(obj) {
	var div = obj.parentNode;
	if (ismove) {
		div.style.left = x1 + window.parent.event.clientX - x0;
		div.style.top = y1 + window.parent.event.clientY - y0;
	}
}

//重新写alert信息   2011-08-01 Davis
//window.alert = myalert;
function myalert(msg){
	//createDiv("餐饮管理系统 - 系统提示", "alert.jsp?token=" + Math.uuid() + "&msg=" + msg);
	var url = encodeURI(encodeURI("BaseAction_alert.aspx?random_token=" + Math.uuid() + "&msg=" + msg));
	createDiv("系统提示", url);
}
//重新写conifrm信息 2011-08-01 Davis
window.confirm = myconfirm;
function myconfirm(msg, okscript){
	var url = encodeURI(encodeURI("BaseAction_confirm.aspx?okscript=" + okscript + "&random_token=" + Math.uuid() + "&msg=" + msg));
	createDiv("系统提示", url);
}