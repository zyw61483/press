/* 公用函数  2011-08-01 Davis*/
var numDot = false;
var int = 0;
function getNum(num)
{
	for(var i=0; i<num.length; i++)
	{
		if(num.charAt(i)<'0'||num.charAt(i)>'9')
			num = getNum(num.substring(0,i) + num.substring(i+1,num.length));
	}
	return num;
}

function getFloat(num)
{
	for(var i=0; i<num.length; i++)
	{
		if(num.charAt(i)=='.'&&i!=0&&!numDot)
		{
			numDot=true;
			continue;
		}
		if(num.charAt(i)<'0'||num.charAt(i)>'9')
			num = getFloat(num.substring(0,i) + num.substring(i+1,num.length));
	}
	numDot=false;
	return num;
}

function selectAll(inForm, keyName)
{
	if(inForm.idall.checked)
	{
		for (var i = 0; i < inForm.elements.length; i++) {
			var e = inForm.elements[i];
			if ((e.type == "checkbox") && (e.name == keyName)) {
				e.checked = true;
			}
		}
	}
	else
	{
		for (var i = 0; i < inForm.elements.length; i++) {
			var e = inForm.elements[i];
			if ((e.type == "checkbox") && (e.name == keyName)) {
				e.checked = false;
			}
		}
	}
}
//高级搜索设置 start
function structureNew()
{
	createDiv("添加信息", "StructureAction_structurePreAdd.aspx");
}

function structureUpdate(id)
{
	createDiv("修改信息", "StructureAction_structurePreUpdate.aspx?id=" + id);
}

function structureDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "StructureAction_structureDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function structureSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=structure");
}
//高级搜索设置 end

//系数设置 start
function esyssetNew()
{
	createDiv("添加信息", "EsyssetAction_esyssetPreAdd.aspx");
}

function esyssetUpdate(id)
{
	createDiv("修改信息", "EsyssetAction_esyssetPreUpdate.aspx?id=" + id);
}

function esyssetDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "EsyssetAction_esyssetDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function esyssetSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Esysset");
}
//系数设置 end


function onLogin(e){
	if(e.keyCode == 13)
	{
		frmOp.target = "_top";
		frmOp.action="EsysuserAction_login.aspx";
		frmOp.submit();
	}
	else
		return;
}

function onLoginSub(){
	frmOp.target = "_top";
	frmOp.action="EsysuserAction_login.aspx";
	frmOp.submit();
}

function esysuserNew()
{
	createDiv("添加用户信息", "EsysuserAction_esysuserPreAdd.aspx");
}

function esysuserModpw(id)
{
	createDiv("修改用户密码", "EsysuserAction_esysuserPreModpw.aspx?id=" + id);
}

function esysuserUpdate(id)
{
	createDiv("修改用户信息", "EsysuserAction_esysuserPreUpdate.aspx?id=" + id);
}

function esysuserDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的用户,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "EsysuserAction_esysuserDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的用户么?","document.frmOp.submit()");
	}
}

function esysuserSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Esysuser");
}
function eactiveNew()
{
	createDiv("添加信息", "EactiveAction_eactivePreAdd.aspx");
}

function eactiveUpdate(id)
{
	createDiv("修改信息", "EactiveAction_eactivePreUpdate.aspx?id=" + id);
}

function eactiveDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "EactiveAction_eactiveDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function eactiveSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Eactive");
}

//信息管理 start
function ebookNew()
{
	createDiv("添加信息", "EbookAction_ebookPreAdd.aspx");
}

function ebookUpdate(id)
{
	createDiv("修改信息", "EbookAction_ebookPreUpdate.aspx?id=" + id);
}

function ebookDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "EbookAction_ebookDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function ebookSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Ebook");
}

function ebooksetsNew()
{
	createDiv("添加信息", "EbooksetsAction_ebooksetsPreAdd.aspx");
}

function ebooksetsUpdate(id)
{
	createDiv("修改信息", "EbooksetsAction_ebooksetsPreUpdate.aspx?id=" + id);
}

function ebooksetsDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "EbooksetsAction_ebooksetsDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function ebooktypeNew()
{
	createDiv("添加信息", "EbooktypeAction_ebooktypePreAdd.aspx");
}

function ebooktypeUpdate(id)
{
	createDiv("修改信息", "EbooktypeAction_ebooktypePreUpdate.aspx?id=" + id);
}

function ebooktypeDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "EbooktypeAction_ebooktypeDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function ebooktypeSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Ebooktype");
}

function egameNew()
{
	createDiv("添加信息", "EgameAction_egamePreAdd.aspx");
}

function egameUpdate(id)
{
	createDiv("修改信息", "EgameAction_egamePreUpdate.aspx?id=" + id);
}

function egameDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "EgameAction_egameDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的么?","document.frmOp.submit()");
	}
}

function egameSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Egame");
}

//start
function ehelpNew()
{
	createDiv("添加信息", "EhelpAction_ehelpPreAdd.aspx");
}

function ehelpUpdate(id)
{
	createDiv("修改信息", "EhelpAction_ehelpPreUpdate.aspx?id=" + id);
}

function ehelpDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "EhelpAction_ehelpDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function ehelpSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Ehelp");
}

function ehelptypeNew()
{
	createDiv("添加信息", "EhelptypeAction_ehelptypePreAdd.aspx");
}

function ehelptypeUpdate(id)
{
	createDiv("修改信息", "EhelptypeAction_ehelptypePreUpdate.aspx?id=" + id);
}

function ehelptypeDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "EhelptypeAction_ehelptypeDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function ehelptypeSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Ehelptype");
}
//end

//start
function enewsNew()
{
	createDiv("添加信息", "EnewsAction_enewsPreAdd.aspx");
}

function enewsUpdate(id)
{
	createDiv("修改信息", "EnewsAction_enewsPreUpdate.aspx?id=" + id);
}

function enewsDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "EnewsAction_enewsDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function enewsSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Enews");
}

function enewstypeNew()
{
	createDiv("添加信息", "EnewstypeAction_enewstypePreAdd.aspx");
}

function enewstypeUpdate(id)
{
	createDiv("修改信息", "EnewstypeAction_enewstypePreUpdate.aspx?id=" + id);
}

function enewstypeDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "EnewstypeAction_enewstypeDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function enewstypeSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Enewstype");
}
//end

//start
function erollNew()
{
	createDiv("添加信息", "ErollAction_erollPreAdd.aspx");
}

function erollUpdate(id)
{
	createDiv("修改信息", "ErollAction_erollPreUpdate.aspx?id=" + id);
}

function erollDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "ErollAction_erollDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function erollSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Eroll");
}

function erolltypeNew()
{
	createDiv("添加信息", "ErolltypeAction_erolltypePreAdd.aspx");
}

function erolltypeUpdate(id)
{
	createDiv("修改信息", "ErolltypeAction_erolltypePreUpdate.aspx?id=" + id);
}

function erolltypeDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "ErolltypeAction_erolltypeDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function erolltypeSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Erolltype");
}
//end

//用户管理表 start
function euserNew()
{
	createDiv("添加信息", "EuserAction_euserPreAdd.aspx");
}

function euserUpdate(id)
{
	createDiv("修改信息", "EuserAction_euserPreUpdate.aspx?id=" + id);
}

function euserDelete(inForm, keyName)
{
	isSelect = false;
	for (var i = 0; i < inForm.elements.length; i++) {
		var e = inForm.elements[i];
		if ((e.type == "checkbox") && (e.name == keyName) && e.checked) {
			isSelect = true;
			break;
		}
	}
	if (!isSelect) {
		alert("没有选择要删除的信息,请返回重新选择");
		return;
	} 
	else
	{
		document.frmOp.action = "EuserAction_euserDel.aspx";
		document.frmOp.target = "Div_URL";
		confirm("确定删除选中的信息么?","document.frmOp.submit()");
	}
}

function euserSearch()
{
	createDiv("高级搜索", "StructureAction_getForSearch.aspx?tableName=Euser");
}
//用户管理表 end
