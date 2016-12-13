/**
 * Created by imant on 2016/12/13.
 */
var baseJs = $.extend({}, baseJs);

baseJs.contextPath = '';

baseJs.url = function(url) {
    if (url.startsWith('/')) {
        return baseJs.contextPath + url;
    }
    return baseJs.contextPath + '/' + url;
}