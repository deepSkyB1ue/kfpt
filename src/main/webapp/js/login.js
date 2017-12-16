let v = new Vue({
    el: '.g-login-dic',
    data: {
        formInline: {
            user: '',
            password: ''
        },
        ruleInline: {
            user: [
                {
                    required: true,
                    message: '请填写用户名',
                    trigger: 'blur'
                }
            ],
            password: [
                {
                    required: true,
                    message: '请填写密码',
                    trigger: 'blur'
                }
            ]
        }
    },
    methods: {
        focusPwd() {
            $('#loginPwd input').focus();
        },
        handleSubmit(name) {
            this.$refs[name].validate(valid => {
                if (valid) {
                    const params = {
                        username: this.formInline.user,
                        password: this.formInline.password
                    };
                    let that = this;

                    commonUtils.httpPost(
                        './rest/login/login',
                        params,
                        function (data) {
                            sessionStorage.setItem(
                                'userInfo',
                                JSON.stringify(data)
                            );
                            that.$Message.success('登录成功，正在跳转!');
                            let d_login = setTimeout(() => {
                                window.location.href = './app.html';
                            }, 1000);
                        },
                        function (data) {
                            that.$Message.error(data);
                        }
                    );
                } else {
                    this.$Message.error('请完善登录信息!');
                }
            });
        }
    }
});
