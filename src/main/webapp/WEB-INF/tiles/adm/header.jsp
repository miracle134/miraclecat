<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
</script>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
        	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">           	 	
	                <span class="sr-only">Toggle navigation</span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
	                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand bx_type_logo" href="/hisManage/hisManageList">SMART EMS</a>
        </div>
        <div  class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><span class="gnb_cont">${sessionScope.userInfo.uid}</span></li>
                <li><a href="javascript:common.script.logoutScript();">로그아웃</a></li>
            </ul>
        </div>
    </div>
</nav>