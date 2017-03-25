function $(id) { return document.getElementById(id); }
function moveElement(elementID,final_x,final_y,interval) {
	if (!document.getElementById) return false;
	if (!document.getElementById(elementID)) return false;
	var elem = document.getElementById(elementID);
	if (elem.movement) {
		clearTimeout(elem.movement);
	}
	if (!elem.style.left) {
    	elem.style.left = "0px";
	}
	if (!elem.style.top) {
    	elem.style.top = "0px";
	}
	var xpos = parseInt(elem.style.left);
	var ypos = parseInt(elem.style.top);
	if (xpos == final_x && ypos == final_y) {
		return true;
  	}
	if (xpos < final_x) {
		var dist = Math.ceil((final_x - xpos)/10);
    	xpos = xpos + dist;
  	}
  	if (xpos > final_x) {
    	var dist = Math.ceil((xpos - final_x)/10);
    	xpos = xpos - dist;
  	}
  	if (ypos < final_y) {
    	var dist = Math.ceil((final_y - ypos)/10);
    	ypos = ypos + dist;
  	}
  	if (ypos > final_y) {
    	var dist = Math.ceil((ypos - final_y)/10);
    	ypos = ypos - dist;
  	}
  	elem.style.left = xpos + "px";
  	elem.style.top = ypos + "px";
  	var repeat = "moveElement('"+elementID+"',"+final_x+","+final_y+","+interval+")";
  	elem.movement = setTimeout(repeat,interval);
}
function classNormal(iFocusBtnID,opacity){
	var iFocusBtns= $(iFocusBtnID).getElementsByTagName('td');
 	for(var i=0; i<iFocusBtns.length; i++) {
  		iFocusBtns[i].style.filter="alpha(opacity="+opacity+")";
 	}
}
function classCurrent(iFocusBtnID,n){
 	var iFocusBtns= $(iFocusBtnID).getElementsByTagName('td');
 	iFocusBtns[n].style.filter="alpha(opacity=100)";
}
var atuokey = false;
function autoiFocus() {
 	if(!$('ifocus')) return false;
 	if(atuokey) return false;
 	var focusBtnList = $('ifocus_btn').getElementsByTagName('td');
 	if(focusBtnList != null)
 	{
		var listLength = focusBtnList.length;
	 	for(var i=0; i<listLength; i++) {
	  		if (focusBtnList[i].style.filter == "alpha(opacity=100)") 
	  		{
	  	 		if (i!=listLength-1){
		  			moveElement('ifocus_piclist',0,(-1)*(i+1)*300,7);
		  			classNormal('ifocus_btn',30);
		 			classCurrent('ifocus_btn',i+1);
		 		}else{
		 			moveElement('ifocus_piclist',0,0,7);
					classNormal('ifocus_btn',30);
					classCurrent('ifocus_btn',0);
				}
				break;
			}
	 	}
	}
}
function autoiList() {
 	if(!$('ilist')) return false;
 	var focusBtnList = $('ilist_btn').getElementsByTagName('td');
 	if(focusBtnList != null)
 	{
		var listLength = focusBtnList.length;
	 	for(var i=0; i<listLength; i++) {
	  		if (focusBtnList[i].style.filter == "alpha(opacity=100)") 
	  		{
	  	 		if (i!=listLength-1){
		  			moveElement('ilist_piclist',(-1)*(i+1)*640,0,7);
		  			classNormal('ilist_btn',70);
		 			classCurrent('ilist_btn',i+1);
		 		}else{
		 			moveElement('ilist_piclist',0,0,7);
					classNormal('ilist_btn',70);
					classCurrent('ilist_btn',0);
				}
				break;
			}
	 	}
	}
}
function autoiCredit() {
 	if(!$('icredit')) return false;
 	var focusBtnList = $('icredit_btn').getElementsByTagName('td');
 	if(focusBtnList != null)
 	{
		var listLength = focusBtnList.length;
	 	for(var i=0; i<listLength; i++) {
	  		if (focusBtnList[i].style.filter == "alpha(opacity=100)") 
	  		{
	  	 		if (i!=listLength-1){
		  			moveElement('icredit_piclist',(-1)*(i+1)*640,0,7);
		  			classNormal('icredit_btn',70);
		 			classCurrent('icredit_btn',i+1);
		 		}else{
		 			moveElement('icredit_piclist',0,0,7);
					classNormal('icredit_btn',70);
					classCurrent('icredit_btn',0);
				}
				break;
			}
	 	}
	}
}