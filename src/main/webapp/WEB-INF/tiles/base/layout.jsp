<%--
  Created by IntelliJ IDEA.
  User: MiracleCat
  Date: 2022-12-05
  Time: 오후 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title><tiles:getAsString name="title"/></title>
    <%@include file="/include/base/common/public_script.jsp"%>
</head>
<body>
    <div id="wrapper">

        <!-- header -->
        <tiles:insertAttribute name="header" />

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <div id="content">
                <!-- top -->
                <tiles:insertAttribute name="top" />
                <!-- body -->
                <tiles:insertAttribute name="body" />
            </div>
            <!-- footer -->
            <tiles:insertAttribute name="footer" />
        </div>

        <!-- Dialog -->
        <tiles:insertAttribute name="dialog" />

    </div>
</body>
</html>
