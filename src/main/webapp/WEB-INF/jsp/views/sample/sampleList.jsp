<%--
 * @menu : 샘플 페이지
 * @since : 2022. 10. 14.
 * @author : MiracleCat (miraclecat.tistory.com)
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/base/common/public_script.jsp" %>
<%@ include file="/include/base/common/public_tag_lib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>샘플 페이지</title>

<script type="text/javascript" src="/js/sample/sample-script.js"></script>
<script type="text/javascript">

</script> 

</head>
<body>
<h1>아이티네스</h1>
<h4><spring:message code="site.title"></spring:message></h4>

<a href="javascript:sample.script.changeKor();">국가코드 변경(한글)</a><br />
<a href="javascript:sample.script.changeEng();">국가코드 변경(영어)</a><br />
<a href="javascript:sample.script.getListMybatis();">Mybatis DB1 조회</a><br />
<a href="javascript:sample.script.getListMybatis2();">Mybatis DB2 조회</a><br />
<a href="javascript:sample.script.getList();">JPA 조회</a><br />
<a href="javascript:sample.script.getDetail();">JPA 상세조회</a><br />
<a href="javascript:sample.script.save();">JPA 저장</a><br />
<a href="javascript:sample.script.update();">JPA 수정</a><br />
<a href="javascript:sample.script.del();">JPA 삭제</a><br /><br />

<form id="frm" name="frm">
	<input type="file" id="sampleFile" name="sampleFile" multiple="multiple"/><br />
	<a href="javascript:sample.script.saveSampleFile();">사진 첨부하기</a><br />
</form>

</body>
</html>