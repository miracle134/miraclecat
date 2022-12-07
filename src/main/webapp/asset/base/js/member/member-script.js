member = {};
member.script = function () {
    return {

        /**
         * 회원가입 init
         */
        registerInit: () => {

            // 이메일 형식 확인
            $('#sEmail').on('blur', function () {
                if (!$.isblank($('#sEmail').val())) {
                    if (!$.checkEmail($('#sEmail').val())) {
                        $('#sEmail').next().show();
                    } else {
                        $('#sEmail').next().hide();
                    }
                } else {
                    $('#sEmail').next().hide();
                }
            });

            // 비밀번호 제약사항 확인
            $('#sPassword').on('input', function () {

                $('#sPassword').siblings('span').removeClass("text-secondary")
                $('#sPassword').siblings('span').removeClass("text-primary")
                $('#sPassword').siblings('span').removeClass("text-danger")

                if (!$.isblank($('#sPassword').val())) {
                    let check = $.checkPw($('#sPassword').val());

                    if ($.isblank(check)) return false;

                    if (check.t1) {
                        $('#sPassword').next().addClass("text-primary");
                    } else {
                        $('#sPassword').next().addClass("text-danger");
                    }

                    if (check.t2) {
                        $('#sPassword').siblings('span:eq(1)').addClass("text-primary");
                    } else {
                        $('#sPassword').siblings('span:eq(1)').addClass("text-danger");
                    }

                    if (check.t3) {
                        $('#sPassword').siblings('span:eq(2)').addClass("text-primary");
                    } else {
                        $('#sPassword').siblings('span:eq(2)').addClass("text-danger");
                    }

                } else {
                    $('#sPassword').next().addClass("text-secondary");
                    $('#sPassword').siblings('span:eq(1)').addClass("text-secondary");
                    $('#sPassword').siblings('span:eq(2)').addClass("text-secondary");
                }
            });

            // 비밀번호 확인
            $("#sPassword, #confirmPassword").on('input', () => {
                if (!$.isblank($('#sPassword').val()) && !$.isblank($('#confirmPassword').val())) {
                    if ($('#sPassword').val() == $('#confirmPassword').val()) {
                        $('#confirmPassword').next().removeClass('text-danger');
                        $('#confirmPassword').next().addClass("text-primary")
                        $('#confirmPassword').next().text("* 비밀번호가 일치합니다.");
                    } else {
                        $('#confirmPassword').next().removeClass('text-primary');
                        $('#confirmPassword').next().addClass("text-danger")
                        $('#confirmPassword').next().text("* 비밀번호가 일치하지 않습니다.");
                    }
                } else {
                    $('#confirmPassword').next().text("");
                }
            });

        },

        /**
         *  회원가입
         */
        register: () => {

        }
    }
}();
