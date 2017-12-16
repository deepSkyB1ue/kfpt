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
    httpGet: function (url, successCallBack, failureCallBack) {
        axios
            .get(url)
            .then(function(response) {
                if (response.data.success) {
                    successCallBack(response.data.data);
                } else {
                    if (failureCallBack) {
                        if (
                            '' !== commonUtils.validateValue(response.data.msg)
                        ) {
                            failureCallBack(response.data.msg);
                        }
                    }
                }
            })
            .catch(function(error) {
                console.log(error);
            });
    },
    /**
     * http post
     * @param url
     * @param data
     * @param successCallBack
     * @param errorCallBack
     */
    httpPost: function (url, data, successCallBack, failureCallBack) {
        var params = {};
        params.time = new Date().getTime();
        params.data = data;
        axios
            .post(url, params)
            .then(function(response) {
                if (response.data.success) {
                    successCallBack(response.data.data);
                } else {
                    if (failureCallBack) {
                        if (
                            '' !== commonUtils.validateValue(response.data.msg)
                        ) {
                            failureCallBack(response.data.msg);
                        }
                    }
                }
            })
            .catch(function(error) {
                console.log(error);
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
        const minHeight = 768 - $('.g-hd').height() - $('.g-ft').height();
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
     *读取html文件
     */
    loadHtml(url, callback) {
        GL.Http({
            url: url,
            method: 'get',
            params: null,
            responseType: 'text'
        })
            .then(function (response) {
                callback(response.data);
            })
            .catch(function (error) {
                console.log('error' + error);
            });
    },
    /**
     * 检测session是否存在
     */
    sessionExist(name) {
        if ('' !== this.validateValue(sessionStorage.getItem(name))) {
            return true;
        }
        return false;
    },
    /**
     * 获取session对象
     */
    getSessionObj(name) {
        if (this.sessionExist(name)) {
            return JSON.parse(sessionStorage.getItem(name));
        }
        return {};
    },
    /**
     * 清空对象内部所有value
     */
    clearObjValues(obj) {
        if (obj) {
            for (var key in obj) {
                if (typeof obj[key] !== 'function') {
                    obj[key] = '';
                }
            }
        }
    },
    modal(vueObj = vm, title = '提示', content = '无法获取对话框信息', onokfunc = function () {
    }, oncancelfunc = function () {
    }) {
        const modalConfig = {
            title: title,
            content: content,
            okText: '确定',
            cancelText: '取消',
            loading: false,
            onOk: onokfunc,
            onCancel: oncancelfunc
        };
        vueObj.$Modal.confirm(modalConfig);
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
