/**在窗口加载后调用此方法
修正时间 2009-11-18 避免窗口越变越大 Victor
*/

function alertForm()
{
	resizeFormStatus();
}

function confirmForm()
{
	resizeFormStatus();
}

function resizeFormStatus()
{
	var bodySize = getOwnBodySize();
	if(bodySize[1]>450) {
		bodySize[1] = 450;
		bodySize[0] = bodySize[0] + 20;
	}
	var random_token = frmOp.random_token;
	if(random_token == null) random_token = "0"; else random_token = random_token.value;
	if(random_token == "") random_token = "0";
	bodySize[0] = bodySize[0] + 6; bodySize[1] = bodySize[1] + 30;
	if(random_token == "0"){
		window.parent.document.getElementById("Div_ChildForm").style.height = bodySize[1]+26;
		window.parent.document.getElementById("Div_URL").style.height = bodySize[1];
		window.parent.document.getElementById("Div_ChildForm").style.width = bodySize[0];
		window.parent.document.getElementById("div_title").style.width = bodySize[0] - 24;
	}else if(random_token == "HasError0"){
		window.parent.document.getElementById("Div_ChildForm").style.height = bodySize[1]+26;			
		window.parent.document.getElementById("Div_URL").style.height = bodySize[1];
	}else if(random_token == "_ALERT"){//信息框固定大小
		window.parent.document.getElementById("Div_ChildForm").style.height = 111+26;
		window.parent.document.getElementById("Div_URL").style.height = 111+26;
		window.parent.document.getElementById("Div_ChildForm").style.width = 400;
		window.parent.document.getElementById("div_title").style.width = 400 - 24;
	}

	var child = window.parent.document.getElementById("Div_ChildForm");
	child.style.left = (window.parent.document.body.scrollLeft+(window.parent.document.body.clientWidth - (child.style.width).substring(0,(child.style.width).length - 2)) / 2) + "px";
	child.style.top = (window.parent.document.body.scrollTop-30+(window.parent.document.body.clientHeight - (child.style.height).substring(0,(child.style.height).length - 2)) / 2) + "px";
	
}
/**关闭窗口*/
function closeForm() {
	window.parent.document.getElementById("Div_ChildForm").style.width = "100px";
	window.parent.document.getElementById("Div_ChildForm").style.height = "100px";
	window.parent.document.getElementById("Div_ChildForm").style.display = "none";
	window.parent.document.getElementById("Div_ChildForm_Bg").style.display = "none";
}
/**
得到当前窗口的大小
*/
function getOwnBodySize() {
	var bodySize = new Array(document.body.scrollWidth, document.body.scrollHeight);
	return bodySize;
}
/*function getOwnBodySize() {
	var xScroll, yScroll;
	if (window.innerHeight && window.scrollMaxY) {
		xScroll = document.body.scrollWidth;
		yScroll = window.innerHeight + window.scrollMaxY;
	} else {
		if (document.body.scrollHeight > document.body.offsetHeight) {
			xScroll = document.body.scrollWidth;
			yScroll = document.body.scrollHeight;
		} else {
			xScroll = document.body.offsetWidth;
			yScroll = document.body.offsetHeight;
		}
	}
	var windowWidth, windowHeight;
	if (self.innerHeight) {
		windowWidth = self.innerWidth;
		windowHeight = self.innerHeight;
	} else {
		if (document.documentElement && document.documentElement.clientHeight) {
			windowWidth = document.documentElement.clientWidth;
			windowHeight = document.documentElement.clientHeight;
		} else {
			if (document.body) {
				windowWidth = document.body.clientWidth;
				windowHeight = document.body.clientHeight;
			}
		}
	}
	if (yScroll < windowHeight) {
		pageHeight = windowHeight;
	} else {
		pageHeight = yScroll;
	}
	if (xScroll < windowWidth) {
		pageWidth = windowWidth;
	} else {
		pageWidth = xScroll;
	}
	var bodySize = new Array(pageWidth, pageHeight);
	return bodySize;
}*/
