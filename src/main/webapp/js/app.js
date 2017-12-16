let vm = new Vue({
    router: router,
    data: {
        systemName: '徐州公安地理大数据平台',
        userName: '请登录',
        popupArray: [],
        paramData: '',
        needLogin: true,
        navs: navList,
        navItems: [],
        navItemsShow: false,
        name2: '',
        showFooter: true,
        footerItem1: '国家测绘地理信息局监制国家基础地理信息中心版权所有',
        footerItem2: '甲测资字1100471京ICP备12009443号-2公网安备1101080201345号'
    },
    methods: {
        toggleNav: function() {
            this.nav.open = !this.nav.open;
        },
        navSelect: function(name) {
            // this.paramData = { aaa: 'aaa', bbb: 'bbb' };
            if ('' !== commonUtils.validateValue(name)) {
                // 申请密钥必须登录
                if ('/sqmy' === name && !commonUtils.sessionExist('userInfo')) {
                    this.$Message.info(
                        '申请密钥需要获取您的基本信息，请先登录!'
                    );
                    let d_sqmy = setTimeout(() => {
                        window.location.href = './login.html';
                    }, 2000);
                    return;
                }
                router.push(name);
            }
        },
        showNavItem(name) {
            if ('selectNavItem' === name) {
                this.navItemsShow = true;
                return;
            }
            if (typeof navList.find(n => n.name === name) === 'undefined') {
                this.navItemsShow = false;
                return;
            }
            this.name2 = name;
            const arr = navList.find(n => n.name === name).children;
            if (typeof arr !== 'undefined' && arr !== []) {
                this.navItems = arr;
                this.navItemsShow = true;
            } else {
                this.navItemsShow = false;
            }
        },
        hideNavItem() {
            this.navItemsShow = false;
        },
        login() {
            sessionStorage.removeItem('userInfo');
            commonUtils.authInfo = {};
            window.location.href = './login.html';
            this.needLogin = false;
        },
        logout() {
            sessionStorage.removeItem('userInfo');
            commonUtils.authInfo = {};
            window.location.href = './login.html';
            let d_home = setTimeout(() => {
                this.userName = '请登录';
                this.needLogin = true;
            }, 1000);
        }
    },
    computed: {
        navWidth: function() {
            return this.nav.open ? this.nav.maxWidth : this.nav.minWidth;
        },
        searchBtn: function() {
            return this.search.loading ? { 'background-color': '#fff' } : {};
        }
    },
    mounted: function () {
        this.$Message.config({
            top: 100,
            duration: 3
        });
        if (commonUtils.sessionExist('userInfo')) {
            this.userName = commonUtils.getSessionObj('userInfo').realname;
            this.needLogin = false;
        }
    }
}).$mount('#app');
