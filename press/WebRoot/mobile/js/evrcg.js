$(function(){
	/**
	 * 书籍详情页面
	 */
	//绑定查看更多事件
	$("#checkmore").click(function(){
		$("#bookindex").css("-webkit-line-clamp","100");
		$("#bookindex").css("overflow","visible");
		$("#bookindex").css("height","100px");
		$("#bookindex").removeClass("ellipsis");
		$("#checkmore").hide();
		$("#checkinit").show();
	});
	//绑定收起事件
	$("#checkinit").click(function(){
		$("#bookindex").css("-webkit-line-clamp","3");
		$("#bookindex").css("overflow","hidden");
		$("#bookindex").css("height","60px");
		$("#bookindex").addClass("ellipsis");
		$("#checkmore").show();
		$("#checkinit").hide();
	});
	
	/**
	 * 我的页面 
	 */
	//我的资料
	$("#myself").click(function(){
		location.href="../evr/myself.html";
	});
	//我的订阅
	$("#myorder").click(function(){
		location.href="../evr/myorder.html";
	});
	//建议反馈
	$("#feedback").click(function(){
		location.href="../evr/suggest.html";
	});
	//常见问题
	$("#faq").click(function(){
		location.href="../evr/faq.html";
	});
	//应用设置
	$("#set").click(function(){
		location.href="../evr/set.html";
	});
	//关于我们
	$("#aboutus").click(function(){
		location.href="../evr/aboutus.html";
	});
	//给我好评
	$("#judge").click(function(){
		alert("好评++");
	});
	//退出登录
	$("#logout").click(function(){
		alert("退出");
	});
});