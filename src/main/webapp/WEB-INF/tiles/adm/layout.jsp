<%--
 * @menu : 관리자 레이아웃
 * @since : 2021. 2. 18.
 * @author : MiracleCat (miraclecat@itnes.co.kr)
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title><tiles:getAsString name="title"/></title>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="container-fluid">
	    <div class="row">
			<tiles:insertAttribute name="lnb" />
			<div id="container"> 
				<tiles:insertAttribute name="body" /> 
			</div>
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	<tiles:insertAttribute name="pop" />
</body>
</html>
