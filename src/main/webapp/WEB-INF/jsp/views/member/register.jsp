<%--
  Created by IntelliJ IDEA.
  User: MiracleCat
  Date: 2022-12-07
  Time: 오후 2:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Register</title>

    <!-- Custom fonts for this template-->
    <link href="/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                        </div>
                        <form class="user" id="registerFrm">
                            <div class="form-group">
                                <input type="email" class="form-control form-control-user" id="sEmail" name="sName"
                                       placeholder="Email Address" maxlength="50">
                                <span class="small text-danger" style="display: none;font-size: 50%;margin-left: 15px;">이메일 형식이 아닙니다.</span>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user" id="sName" name="sName"
                                       placeholder="Name" maxlength="10">
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="password" class="form-control form-control-user"
                                           id="sPassword" name="sPassword" placeholder="Password">
                                    <span class="text-secondary" style="font-size: 50%;margin-left: 15px;">* 8~16자의 영문,숫자,특수문자를 입력해주세요.</span><br>
                                    <span class="text-secondary" style="font-size: 50%;margin-left: 15px;">* 특수문자는 !@#$%^&*()[]+= 만 사용 가능합니다.</span><br>
                                    <span class="text-secondary" style="font-size: 50%;margin-left: 15px;">* 동일한 문구 3자리 이상은 입력이 불가합니다.</span>
                                </div>
                                <div class="col-sm-6">
                                    <input type="password" class="form-control form-control-user"
                                           id="confirmPassword" placeholder="Repeat Password">
                                    <span class="small" style="font-size: 50%;margin-left: 15px;"></span>
                                </div>
                            </div>
                            <a href="javascript:member.script.register();" class="btn btn-primary btn-user btn-block">
                                Register Account
                            </a>
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="/member/forgot-password">Forgot Password?</a>
                        </div>
                        <div class="text-center">
                            <a class="small" href="/member/login">Already have an account? Login!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<%@ include file="/include/base/common/public_script.jsp"%>
<%@ include file="/include/base/common/public_tag_lib.jsp" %>
<%@ include file="/include/base/common/public_static.jsp" %>

<!-- Member Script -->
<script src="/js/member/member-script.js?t=${cacheNum}"></script>
<script>
    $(function() {

        member.script.registerInit();

    });
</script>

</body>

</html>