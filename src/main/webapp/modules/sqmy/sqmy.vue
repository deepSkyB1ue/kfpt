<template>
    <div>
        <div style="height:100px"></div>
        <div class="g-mn sqmy">
            <gaea-tabs type="card" value="register" @on-click="tabpaneclick">
                <gaea-tab-pane label="申请注册" name="register">
                    <h4 style="margin-bottom: 10px;">提示: 申请密钥需要获取您的基本信息，请确认登录</h4>
                    <gaea-form ref="formInline" :model="formInline" :rules="ruleInline" :label-width="150">
                        <gaea-form-item label="安卓MD5：" prop="androidmd5">
                            <gaea-input v-model="formInline.androidmd5" maxlength="50"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item label="包名：" prop="packageName">
                            <gaea-input v-model="formInline.packageName" maxlength="50"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item label="应用网址：" prop="url">
                            <gaea-input v-model="formInline.url" maxlength="50"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item label="应用名称：" prop="appName">
                            <gaea-input v-model="formInline.appName" maxlength="50"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item label="公司名称：" prop="company">
                            <gaea-input v-model="formInline.company" maxlength="50"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item label="联系人姓名：" prop="contactName">
                            <gaea-input v-model="formInline.contactName" maxlength="20"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item label="联系人电话：" prop="contactNumber">
                            <gaea-input v-model="formInline.contactNumber" maxlength="20"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item>
                            <gaea-button type="primary" @click="handleSubmit('formInline')">注册</gaea-button>
                            <gaea-button type="default" @click="reset">重置</gaea-button>
                        </gaea-form-item>
                    </gaea-form>
                </gaea-tab-pane>
                <gaea-tab-pane label="待审核" name="list">
                    <gaea-table :columns="columns" :data="data" stripe no-data-text="暂无" highlight-row="true"
                                border="true"></gaea-table>
                    <gaea-page :total="totalsize" :current="pagenum" :page-size="pagesize" show-total
                               @on-change="changePage"></gaea-page>
                </gaea-tab-pane>
            </gaea-tabs>
        </div>
    </div>
</template>

<script>
    var sqmyobj;
module.exports = {
    data() {
        return {
            formInline: {
                pid: '',
                androidmd5: '',
                packageName: '',
                url: '',
                appName: '',
                company: '',
                contactName: '',
                contactNumber: ''
            },
            ruleInline: {
                androidmd5: [
                    {
                        required: true,
                        message: '请填写长度不超过50的安卓MD5码',
                        trigger: 'blur',
                        max: 50
                    }
                ],
                packageName: [
                    {
                        required: true,
                        message: '请填写长度不超过50的包名',
                        trigger: 'blur',
                        max: 50
                    }
                ],
                url: [
                    {
                        required: true,
                        message: '请填写长度不超过50的应用网址',
                        trigger: 'blur',
                        max: 50
                    }
                ],
                appName: [
                    {
                        required: true,
                        message: '请填写长度不超过50的应用名称',
                        trigger: 'blur',
                        max: 50
                    }
                ],
                company: [
                    {
                        required: true,
                        message: '请填写长度不超过50的公司名称',
                        trigger: 'blur',
                        max: 50
                    }
                ],
                contactName: [
                    {
                        required: true,
                        message: '请填写长度不超过20的联系人姓名',
                        trigger: 'blur',
                        max: 20
                    }
                ],
                contactNumber: [
                    {
                        required: true,
                        message: '请填写长度不超过20的联系人电话',
                        trigger: 'blur',
                        max: 20
                    }
                ]
            },
            columns: [
                {
                    title: '安卓MD5',
                    key: 'androidmd5'
                },
                {
                    title: '包名',
                    key: 'packagename'
                },
                {
                    title: '密钥',
                    key: 'servermd5'
                },
                {
                    title: '应用网址',
                    key: 'url'
                },
                {
                    title: '应用名称',
                    key: 'appname'
                },
                {
                    title: '公司名称',
                    key: 'company'
                },
                {
                    title: '联系人姓名',
                    key: 'contactname'
                },
                {
                    title: '联系电话',
                    key: 'contactnumber'
                },
                {
                    title: '操作',
                    key: 'action',
                    width: 150,
                    align: 'center',
                    render: function(h, params) {
                        let renderArr = [
                            h(
                                'gaea-button',
                                {
                                    props: {
                                        type: 'info',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            $(
                                                $('.sqmy .ivu-tabs-tab')[0]
                                            ).click();
                                            sqmyobj.formInline = {
                                                pid: params.row.pid,
                                                androidmd5: params.row.androidmd5,
                                                packageName: params.row.packagename,
                                                url: params.row.url,
                                                appName: params.row.appname,
                                                company: params.row.company,
                                                contactName: params.row.contactname,
                                                contactNumber: params.row.contactnumber
                                            };
                                        }
                                    }
                                },
                                '编辑'
                            ),
                            h(
                                'gaea-button',
                                {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            commonUtils.modal(
                                                vm,
                                                '警告',
                                                '即将为您删除当前选中行, 是否确认?',
                                                function () {
                                                    const rowindex =
                                                        params.index;
                                                    commonUtils.httpPost(
                                                        './rest/applyForKey/delete',
                                                        params.row.pid,
                                                        function (data) {
                                                            sqmyobj.data.splice(
                                                                rowindex,
                                                                1
                                                            );
                                                            sqmyobj.totalsize -= 1;
                                                            vm.$Message.info(
                                                                data
                                                            );
                                                        },
                                                        function (data1) {
                                                            vm.$Message.error(
                                                                data1
                                                            );
                                                        }
                                                    );
                                                }
                                            );
                                        }
                                    }
                                },
                                '删除'
                            )
                        ];
                        let adminRenderArr = [
                            h(
                                'gaea-button',
                                {
                                    props: {
                                        type: 'success',
                                        size: 'small'
                                    },
                                    on: {
                                        click: function () {
                                            commonUtils.modal(
                                                vm,
                                                '提示',
                                                '是否确认当前记录审核通过?',
                                                function () {
                                                    const rowindex =
                                                        params.index;
                                                    const postObj = {
                                                        pid: params.row.pid,
                                                        auditpersonid: commonUtils.getSessionObj(
                                                            'userInfo'
                                                        ).username
                                                    };
                                                    commonUtils.httpPost(
                                                        './rest/applyForKey/audit',
                                                        postObj,
                                                        function (data) {
                                                            sqmyobj.data.splice(
                                                                rowindex,
                                                                1
                                                            );
                                                            sqmyobj.totalsize -= 1;
                                                            vm.$Message.info(
                                                                data
                                                            );
                                                        },
                                                        function (data1) {
                                                            vm.$Message.error(
                                                                data1
                                                            );
                                                        }
                                                    );
                                                }
                                            );
                                        }
                                    }
                                },
                                '审核'
                            )
                        ];
                        if (
                            commonUtils.sessionExist('userInfo') &&
                            'admin' ===
                            commonUtils.getSessionObj('userInfo').identity
                        ) {
                            renderArr = [...renderArr, ...adminRenderArr];
                        }
                        return h('div', renderArr);
                    }
                }
            ],
            data: [],
            totalsize: 0,
            pagenum: 1,
            pagesize: 6
        };
    },
    methods: {
        handleSubmit(name) {
            this.$refs[name].validate(valid => {
                if (valid) {
                    if (!commonUtils.sessionExist('userInfo')) {
                        this.$Message.info(
                            '申请密钥需要获取您的基本信息，请先登录!'
                        );
                        let d_sqmy1 = setTimeout(() => {
                            window.location.href = './login.html';
                        }, 2000);
                        return;
                    }
                    let sqmyInsert = {
                        androidmd5: this.formInline.androidmd5,
                        appname: this.formInline.appName,
                        auditpersonid: '',
                        audittime: '',
                        company: this.formInline.company,
                        contactname: this.formInline.contactName,
                        contactnumber: this.formInline.contactNumber,
                        createrid: commonUtils.getSessionObj('userInfo')
                            .username,
                        packagename: this.formInline.packageName,
                        pid: this.formInline.pid,
                        servermd5: '',
                        status: '0',
                        url: this.formInline.url
                    };
                    let that = this;
                    commonUtils.httpPost(
                        './rest/applyForKey/insert',
                        sqmyInsert,
                        function (data) {
                            commonUtils.modal(
                                vm,
                                '提示',
                                '注册成功, 您的密钥是: ' + data,
                                function () {
                                    that.reset();
                                },
                                function () {
                                    that.reset();
                                }
                            );
                        },
                        function (data1) {
                            that.$Message.error(data1);
                        }
                    );
                } else {
                    this.$Message.error('请完善注册信息!');
                }
            });
        },
        reset() {
            commonUtils.clearObjValues(this.formInline);
        },
        tabpaneclick(name) {
            if ('register' === name) {
                this.reset();
            }
            if ('list' === name) {
                if (!commonUtils.sessionExist('userInfo')) {
                    this.$Message.info('无法获取您的基本信息，请先登录!');
                    let d_sqmy2 = setTimeout(() => {
                        window.location.href = './login.html';
                    }, 2000);
                    return;
                } else {
                    this.changePage(1);
                }
            }
        },
        changePage(pagenum) {
            const username = commonUtils.getSessionObj('userInfo').username;
            const identity = commonUtils.getSessionObj('userInfo').identity;
            let sqmyUrl = './rest/applyForKey/' + username + '/page_' + pagenum;
            let that = this;
            commonUtils.httpGet(
                sqmyUrl,
                function (data) {
                    that.data = data.pageData;
                    that.pagenum = data.pageNum;
                    that.totalsize = data.totalSize;
                },
                function () {
                    that.data = [];
                }
            );
        }
    },
    watch: {},
    mounted: function() {
        console.log('sqmy');
        sqmyobj = this;
        commonUtils.setGbdHeight();
        this.$Message.config({
            top: 100,
            duration: 3
        });
    },
    beforeDestroy: function() {}
};
</script>

<style>
.sqmy {
}
.sqmy .ivu-tabs-bar{
    margin-bottom:5px;
}
.sqmy .pane1 {
    width: 500px;
}
.sqmy .ivu-tabs-tabpane {
    text-align: center;
}
.sqmy .ivu-form {
    width: 500px;
    display: inline-block;
}
.sqmy .ivu-form .ivu-form-item-label {
    font-size: 15px;
}
.sqmy .ivu-tabs.ivu-tabs-card > .ivu-tabs-bar .ivu-tabs-tab {
    width: 510px;
    text-align: center;
}
.sqmy .ivu-table{
    max-height: 400px;
    overflow-y: auto;
    margin-bottom: 15px;
}
.sqmy .ivu-table-cell{
    padding-left:5px;
    padding-right:5px;
    text-align:center;
}
.sqmy th .ivu-table-cell{
    display:block;
}
.sqmy .ivu-table-body{
    user-select:text;
}
</style>