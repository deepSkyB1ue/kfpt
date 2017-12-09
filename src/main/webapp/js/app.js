let vm = new Vue({
    router: router,
    data: {
        systemName: '徐州PGIS开放平台',
        userName: '欢迎，请登录啊',
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
            alert('登录跳转');
            this.needLogin = false;
        },
        logout() {
            // alert('确定要退出登录?');
            this.needLogin = true;
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
    mounted: function() {}
}).$mount('#app');
