/**
 * Created by imant on 2016/12/13.
 */
var passportJs = $.extend({}, passportJs);

// 登录
passportJs.login = function() {
    if (!$('#username').val()) {
        alert('用户名不能为空');
        return;
    }
    if (!$('#password').val()) {
        alert('密码不能为空');
        return;
    }

    $.ajax({
        url : baseJs.url('/passport/loginSubmit'),
        type : 'POST',
        data : {
            username : $('#username').val(),
            password : $('#password').val()
        },
        dataType : 'JSON',
        beforeSend : function() {
            $('#error').hide();
            $('#error').text('');
        },
        success : function(data) {
            if (data.code === '200') {
                window.location.href = baseJs.url('/user/index');
            } else {
                $('#error').text(data.message);
                $('#error').show();
                $('#password').val('');
            }
        }
    });
}

// 注册
passportJs.register = function() {
    if (!$('#username').val()) {
        alert('用户名不能为空');
        return;
    }
    if (!$('#password').val()) {
        alert('密码不能为空');
        return;
    }
    if (!$('#repassword').val()) {
        alert('密码不能为空');
        return;
    }
    if ($('#repassword').val() != $('#repassword').val()) {
        alert('两次密码不一致');
        return;
    }

    $.ajax({
        url: baseJs.url('/passport/registerSubmit'),
        type: 'POST',
        data: {
            username: $('#username').val(),
            password: $('#password').val(),
            repassword: $('#repassword').val()
        },
        dataType: 'JSON',
        beforeSend: function () {
            $('#error').hide();
            $('#error').text('');
        },
        success: function (data) {
            if (data.code === '200') {
                window.location.href = baseJs.url('/passport/login');
            } else {
                $('#error').text(data.message);
                $('#error').show();
                $('#password').val('');
            }
        }
    });
}