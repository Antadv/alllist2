/**
 * Created by imant on 2017/1/10.
 */

var indexJs = $.extend({}, indexJs);

indexJs.login = function() {
    window.location.href = baseJs.url('/passport/login');
};

indexJs.register = function() {
    window.location.href = baseJs.url('/passport/register');
};

indexJs.restGet = function() {
    if ($('#userId').val()) {
        window.location.href = baseJs.url('/rest/') + $('#userId').val();
    } else {
        window.location.href = baseJs.url('/passport/login');
    }
};

indexJs.restDel = function() {
    if ($('#userId').val()) {
        $.ajax({
            url     : baseJs.url('/rest/') + $('#userId').val(),
            type    : 'DELETE',
            dataType: 'JSON',
            success : function(res) {
                if (res.code === '200') {
                    indexJs.login();
                } else {
                    alert(res.message);
                }
            }
        });
    } else {
        indexJs.login();
    }
};
