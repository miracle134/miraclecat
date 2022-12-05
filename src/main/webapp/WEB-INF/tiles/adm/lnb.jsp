<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function(){
	
	var lnbLocation = $(location).prop("pathname").split("/");
	
	$(".depth1").removeClass("active");
	$("."+lnbLocation[1]).addClass("active");
	
});
</script>
<div class="col-sm-3 col-md-2 sidebar" id="navbar">
    <ul class="nav nav-sidebar lnb">    	
    	<li class="depth1  hisManage"><a href="/hisManage/hisManageList">이력관리</a></li>
    	<c:if test="${sessionScope.userInfo.grade eq 0}">
			<li class="depth1  customerManage"><a href="/customerManage/customerManageList">고객관리</a></li>
			<li class="depth1  admManage"><a href="/admManage/admManageList">관리자관리</a></li>
			<li class="depth1  configManage"><a href="/configManage/configManageList">설정</a></li>
		</c:if>
    </ul>
</div>
