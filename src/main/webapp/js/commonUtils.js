let commonUtils = {
    /**
     *  用户信息
     */
    authInfo: {},
    /**
     * http get
     * @param url
     * @param successCallBackH
     * @param errCallBack
     */
    httpGet: function(url, successCallBack, errorCallBack) {
        commonUtils.showContainerMask(true);
        axios
            .get(url)
            .then(function(response) {
                commonUtils.showContainerMask(false);
                if (response.data.success) {
                    successCallBack(response.data.data);
                }
            })
            .catch(function(error) {
                console.log(error);
                commonUtils.showContainerMask(false);
                if (errorCallBack) {
                    errorCallBack();
                }
            });
    },
    /**
     * http post
     * @param url
     * @param data
     * @param successCallBack
     * @param errorCallBack
     */
    httpPost: function(url, data, successCallBack, errorCallBack) {
        if (url.indexOf('ConditionCounts') == -1) {
            commonUtils.showContainerMask(true);
        }
        var params = {};
        params.time = new Date().getTime();
        params.data = data;
        axios
            .post(url, params)
            .then(function(response) {
                if (url.indexOf('ConditionCounts') == -1) {
                    commonUtils.showContainerMask(false);
                }
                if (response.data.success) {
                    successCallBack(response.data.data);
                }
            })
            .catch(function(error) {
                commonUtils.showContainerMask(false);
                console.log(error);
                if (errorCallBack) {
                    errorCallBack();
                }
            });
    },
    /**
     * 用于验证value, 返回有值或者''
     * @param value
     */
    validateValue(value) {
        if (value && typeof value !== 'undefined') {
            return value;
        }
        return '';
    },
    /**
     *计算界面.g-bd的高度
     */
    setGbdHeight() {
        const containerHeight =
            $(window).height() - $('.g-hd').height() - $('.g-ft').height();
        const contentHeight = $('.g-bd>div').height();
        const minHeight=768-$('.g-hd').height() - $('.g-ft').height();
        if ($(window).height() < 768) {
            $('.g-bd').height(minHeight + 'px');
        }
        if (contentHeight < containerHeight) {
            $('.g-bd').height(containerHeight + 'px');
        } else {
            $('.g-bd').height(contentHeight + 'px');
        }
    },
    /**
     *获取当前日期
     */
    getCurrentDate: function(_gap) {
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var day = date.getDate();
        if (_gap) {
            return year + _gap + month + _gap + day;
        }
        return year + '年' + month + '月' + day + '日';
    },
    /**
     *设置SessionAttr
     */
    setSessionAttr: function(_key, _value) {
        sessionStorage.setItem(_key, _value);
    },
    /**
     *获取SessionAttr
     */
    getSessionAttr: function(_key) {
        sessionStorage.getItem(_key);
    },
    /**
     *移除SessionAttr
     */
    removeSessionAttr: function(_key) {
        sessionStorage.removeItem(_key);
    },
    /**
     *清空SessionAtrr
     */
    clearSessionAttr: function() {
        sessionStorage.clear();
    }
};
/**
 * 时间json转规范格式
 * @param fmt
 * @returns {*}
 */
Date.prototype.format = function(format) {
    var date = {
        'M+': this.getMonth() + 1,
        'd+': this.getDate(),
        'h+': this.getHours(),
        'm+': this.getMinutes(),
        's+': this.getSeconds(),
        'q+': Math.floor((this.getMonth() + 3) / 3),
        'S+': this.getMilliseconds()
    };
    if (/(y+)/i.test(format)) {
        format = format.replace(
            RegExp.$1,
            (this.getFullYear() + '').substr(4 - RegExp.$1.length)
        );
    }
    for (var k in date) {
        if (new RegExp('(' + k + ')').test(format)) {
            format = format.replace(
                RegExp.$1,
                RegExp.$1.length === 1
                    ? date[k]
                    : ('00' + date[k]).substr(('' + date[k]).length)
            );
        }
    }
    return format;
};
/**
 * 监听屏幕大小
 */
$(window).resize(function() {
    commonUtils.setGbdHeight();
});
