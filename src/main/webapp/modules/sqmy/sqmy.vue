<template>
    <div>
        <div style="height:100px"></div>
        <div class="g-mn sqmy">
            <gaea-tabs type="card" value="name1">
                <gaea-tab-pane label="申请注册" name="name1">
                    <gaea-form :model="formInline" :rules="ruleInline" :label-width="150">
                        <gaea-form-item label="安卓MD5：" prop="androidmd5">
                            <gaea-input v-model="formItem.input"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item label="包名：" prop="packageName">
                            <gaea-input v-model="formItem.input"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item label="应用网址：" prop="url">
                            <gaea-input v-model="formItem.input"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item label="应用名称：" prop="appName">
                            <gaea-input v-model="formItem.input"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item label="公司名称：" prop="company">
                            <gaea-input v-model="formItem.input"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item label="联系人姓名：" prop="contactName">
                            <gaea-input v-model="formItem.input"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item label="联系人电话：" prop="contactNumber">
                            <gaea-input v-model="formItem.input"></gaea-input>
                        </gaea-form-item>
                        <gaea-form-item>
                            <gaea-button type="primary">立即注册</gaea-button>
                        </gaea-form-item>
                    </gaea-form>
                </gaea-tab-pane>
                <gaea-tab-pane label="待审核" name="name2">
                    <gaea-table :columns="columns" :data="data"></gaea-table>
                    <gaea-page :total="100" show-total></gaea-page>

                </gaea-tab-pane>
            </gaea-tabs>

        </div>
    </div>
</template>

<script>
module.exports = {
    data() {
        return {
            formInline: {
                user: '',
                password: ''
            },
            ruleInline: {
                androidmd5: [
                    {
                        required: true,
                        message: '请填写安卓MD5',
                        trigger: 'blur'
                    }
                ],
                packageName: [
                    {
                        required: true,
                        message: '请填写包名',
                        trigger: 'blur'
                    }
                ],
                url: [
                    {
                        required: true,
                        message: '请填写应用网址',
                        trigger: 'blur'
                    }
                ],
                appName: [
                    {
                        required: true,
                        message: '请填写应用名称',
                        trigger: 'blur'
                    }
                ],
                company: [
                    {
                        required: true,
                        message: '请填写公司名称',
                        trigger: 'blur'
                    }
                ],
                contactName: [
                    {
                        required: true,
                        message: '请填写联系人姓名',
                        trigger: 'blur'
                    }
                ],
                contactNumber: [
                    {
                        required: true,
                        message: '请填写联系人电话',
                        trigger: 'blur'
                    }
                ]
            },
            formItem: {
                input: '',
                select: '',
                radio: 'male',
                checkbox: [],
                switch: true,
                date: '',
                time: '',
                slider: [20, 50],
                textarea: ''
            },
            columns: [
                {
                    title: '安卓MD5',
                    key: 'androidMD5'
                },
                {
                    title: '包名',
                    key: 'packageName'
                },
                {
                    title: '服务器MD5',
                    key: 'serverMD5'
                },
                {
                    title: '应用网址',
                    key: 'url'
                },
                {
                    title: '应用名称',
                    key: 'appName'
                },
                {
                    title: '公司名称',
                    key: 'company'
                },
                {
                    title: '联系人姓名',
                    key: 'contactName'
                },
                {
                    title: '联系电话',
                    key: 'contactNumber'
                },
                {
                    title: '操作',
                    key: 'action',
                    width: 150,
                    align: 'center',
                    render: function(h, params) {
                        return h('div', [
                            h(
                                'gaea-button',
                                {
                                    props: {
                                        type: 'primary',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: function() {
                                            v.show(params.index);
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
                                    on: {
                                        click: function() {
                                            v.remove(params.index);
                                        }
                                    }
                                },
                                '删除'
                            )
                        ]);
                    }
                }
            ],
            data: [
                {
                    name: '王小明',
                    age: 18,
                    address: '北京市朝阳区芍药居'
                },
                {
                    name: '张小刚',
                    age: 25,
                    address: '北京市海淀区西二旗'
                },
                {
                    name: '李小红',
                    age: 30,
                    address: '上海市浦东新区世纪大道'
                },
                {
                    name: '周小伟',
                    age: 26,
                    address: '深圳市南山区深南大道'
                }
            ]
        };
    },
    methods: {},
    watch: {},
    mounted: function() {
        console.log('sqmy');
        commonUtils.setGbdHeight();
    },
    beforeDestroy: function() {}
};
</script>

<style>
.sqmy {
    /* position: relative;
    top: 100px;
    left: 0;
    right: 0; */
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
</style>