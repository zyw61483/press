<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script language="JavaScript">

var tmpOutlookbar;

tmpOutlookbar=outlookbar.addtitle(getMenuHead('资源管理','PRODUCT MANAGE','menu_data'))
outlookbar.additem(getMenuItem('用户参加活动记录','getDetail("EactiveAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('资源管理','getDetail("EbookAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('资源系列管理','getDetail("EbooksetsAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('游戏管理','getDetail("EgameAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('说明文档管理','getDetail("EhelpAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('文章管理','getDetail("EnewsAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('轮播管理','getDetail("ErollAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('用户表管理','getDetail("EuserAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')

tmpOutlookbar=outlookbar.addtitle(getMenuHead('信息管理','SERVICE MANAGE','menu_foru'))
outlookbar.additem(getMenuItem('资源类型管理','getDetail("EbooktypeAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('说明文档类型管理','getDetail("EhelptypeAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('文章类型管理','getDetail("EnewstypeAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('轮播类型管理','getDetail("ErolltypeAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')


tmpOutlookbar=outlookbar.addtitle(getMenuHead('系统设置','SYSTEM SETTING','menu_sett'))
outlookbar.additem(getMenuItem('系统用户管理','getDetail("EsysuserAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('高级搜索设置','getDetail("StructureAction_getAll.aspx", 0)'),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('-',''),tmpOutlookbar,'')
outlookbar.additem(getMenuItem('退出登录','location="/admin"'),tmpOutlookbar,'')

locatefold("");
var initbodysize=getBodySize();
var inittopexist=1;
outlookbar.show();
</script>