var router = new VueRouter({
    //routes:[{ path: '/module6', component: httpVueLoader('modules/module6/module7.vue') }]    // （缩写）相当于 routes: routes
});

router.beforeEach(function (to, from, next) {
    if (routersMap[to.path] == undefined) {
        next(false);
    }
    //如果路由中不存在所要加载的组件
    if (router.getMatchedComponents(to).length < 1) {
        //获取组件并加载到路由中
        var _temp = httpVueLoader(routersMap[to.path]);
        router.addRoutes([{path: to.path, component: _temp}]);
        //终止当前路由，再次跳转到目标地址
        next(to.path);
    }
    next();
});

const routersMap = {
    '/': 'modules/home/home.vue',
    '/home': 'modules/home/home.vue',
    '/module5': 'modules/module5/module5.vue',
    '/module6': 'modules/module6/module6.vue',
    '/module7': 'modules/module7/module7.vue',
    '/module8': 'modules/module8/module8.vue',
    '/module9': 'modules/module9/module9.vue',
    '/station': 'modules/station/station.vue',
    '/webkf': 'modules/station/station.vue',
    '/sqmy': 'modules/sqmy/sqmy.vue',
};

const navList = [
    {
        name: '/home',
        value: '首页'
    },
    {
        name: 'tcfw',
        value: '图层服务',
        children: [
            {name: '1', value: '派出所图层'},
            {name: '2', value: '治安岗亭图层'},
            {name: '3', value: '警务室图层'},
            {name: '4', value: '查报站图层'},
            {name: '5', value: '治安卡口图层'},
            {name: '6', value: '高清卡口图层'},
            {name: '7', value: '重点单位图层'},
            {name: '8', value: '业务数据图层'},
            {name: '8', value: '视频监控点位图层'}
        ]
    },
    {
        name: '3',
        value: '条线应用',
        children: [
            {name: '11', value: '标准地址系统'},
            {name: '21', value: '一标三实数据采集系统'}
        ]
    },
    {
        name: '4',
        value: '地图工具集',
        children: [
            {name: '1', value: 'PGIS视频监控系统'},
            {name: '2', value: 'GPS转发平台'},
            {name: '3', value: '面区采集系统'},
            {name: '4', value: '重点人员查询系统'},
            {name: '5', value: '图搜系统'},
            {name: '6', value: '警用制图系统'}
        ]
    },
    {
        name: '5',
        value: '二次开发',
        children: [
            {name: 'webkf', value: 'Web端开发'},
            {name: '2', value: '移动端开发'}
        ]
    },
    {
        name: '6',
        value: '重点路口全景数据'
    },
    {
        name: '/sqmy',
        value: '申请密匙'
    }
];
