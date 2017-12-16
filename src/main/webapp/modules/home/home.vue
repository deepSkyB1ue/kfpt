<template>
    <div>
        <div class="g-mn">
            <div>
                <gaea-carousel v-model="value3" :autoplay="setting.autoplay" :autoplay-speed="setting.autoplaySpeed" :dots="setting.dots" :trigger="setting.trigger" :arrow="setting.arrow">
                    <gaea-carousel-item>
                        <div class="g-carousel pic1">
                            <div class="i1">Android&nbsp;地图PGIS&nbsp;V3.42上线</div>
                            <div class="i2">个性化地图细化元素 更新反地理编码服务数据接口</div>
                        </div>
                    </gaea-carousel-item>
                    <!-- <gaea-carousel-item>
                    <div class="g-carousel pic2">12</div>
                </gaea-carousel-item>-->
                </gaea-carousel>
            </div>
            <div class="home2">
                <h1>平台的六大功能与服务</h1>
                <h2>平台始终以优质的服务满足您对地图的所有需求</h2>
                <div class="m-link">
                    <div class="icon1">图层服务</div>
                    <div class="icon2">条线应用</div>
                    <div class="icon3">地图工具集</div>
                    <div class="icon4">二次开发</div>
                    <div class="icon5">重点路口全景数据</div>
                    <div class="icon6">二次开发注册</div>
                </div>
            </div>
            <div class="home3">
                <h3>PGIS位置智能图层服务</h3>
                <ul class="ul1">
                    <li>派出所图层</li>
                    <li>警务室图层</li>
                    <li>查报站图层</li>
                    <li>治安岗亭图层</li>
                    <li>治安卡口图层</li>
                </ul>
                <ul class="ul2">
                    <li>高清卡口图层</li>
                    <li>重点单位图层</li>
                    <li>业务数据图层</li>
                    <li>视频监控点位图层</li>
                    <li style="cursor:default;">&nbsp;</li>
                </ul>
            </div>
            <div class="home4">
                <h1>各种警类都在用PGIS系统</h1>
                <h2>提供丰富的解决方案，结合核心场景快速接入地图能力</h2>
                <div class="link">
                    <div class="link-item1">
                        <span style="overflow:hidden;">
                            <transition name="bounce">
                                <img src="./assets/images/home4_pic1.png">
                            </transition>
                        </span>
                        <h2>标准地址系统</h2>
                        <p>标准地址综合管理系统,实现标准地址的采集和查询,并对外提供标准地址公共服务</p>
                    </div>
                    <div class="link-item2">
                        <span>
                            <img src="./assets/images/img_yibiaosanshi.png">
                        </span>
                        <h2>一标三实数据采集系统</h2>
                        <p>标准地址、实有人口、实有单位、实有房屋数据采集查询系统</p>
                    </div>
                </div>
            </div>
            <div class="home5">
                <h1>地图工具集</h1>
                <h2>专业地图,稳定服务</h2>
                <ul>
                    <li class="li1">
                        <h1>PGIS视频监控系统</h1>
                        <p>一体化的图像综合信息共享应用平台，为交通管理、治安管控、侦查破案、巡逻防范、防火处突、应急救援等全市各项社会管理工作提供服务保障</p>
                    </li>
                    <li class="li2">
                        <h1>PGIS视频监控系统</h1>
                        <p>一体化的图像综合信息共享应用平台，为交通管理、治安管控、侦查破案、巡逻防范、防火处突、应急救援等全市各项社会管理工作提供服务保障</p>
                    </li>
                    <li class="li3">
                        <h1>PGIS视频监控系统</h1>
                        <p>一体化的图像综合信息共享应用平台，为交通管理、治安管控、侦查破案、巡逻防范、防火处突、应急救援等全市各项社会管理工作提供服务保障</p>
                    </li>
                    <li class="li4">
                        <h1>PGIS视频监控系统</h1>
                        <p>一体化的图像综合信息共享应用平台，为交通管理、治安管控、侦查破案、巡逻防范、防火处突、应急救援等全市各项社会管理工作提供服务保障</p>
                    </li>
                    <li class="li5">
                        <h1>PGIS视频监控系统</h1>
                        <p>一体化的图像综合信息共享应用平台，为交通管理、治安管控、侦查破案、巡逻防范、防火处突、应急救援等全市各项社会管理工作提供服务保障</p>
                    </li>
                    <li class="li6">
                        <h1>PGIS视频监控系统</h1>
                        <p>一体化的图像综合信息共享应用平台，为交通管理、治安管控、侦查破案、巡逻防范、防火处突、应急救援等全市各项社会管理工作提供服务保障</p>
                    </li>
                </ul>
            </div>
            <div class="home6">
                <h1>开发文档</h1>
                <h2>PGIS开放平台为开发者提供给了覆盖全平台的API服务、开发文档及在线功能体验</h2>
                <div class="m1">
                    <div class="title1">Web端开发</div>
                    <ul>
                        <li>地图显示</li>
                        <li>地图定位</li>
                        <li>地图工具栏控制</li>
                        <li>点线面</li>
                        <li>子图源显示</li>
                        <li>图层操作</li>
                        <li>轨迹回放</li>
                        <li>区域数据</li>
                    </ul>
                </div>
                <div class="m2">
                    <div class="title2">移动端开发</div>
                    <ul>
                        <li>地图显示</li>
                        <li>图层操作</li>
                        <li>点线面操作</li>
                        <li>定位</li>
                        <li>图标库</li>
                        <li>分析服务</li>
                        <li>轨迹回放</li>
                        <li style="cursor:default;">&nbsp;</li>
                    </ul>
                </div>
            </div>
            <div class="home7">
                <h1>重点路口全景数据</h1>
                <h2>从任意一个角度互动性地观察场景,犹如身临其境,体验最真实的感受</h2>
                <span>
                    <img src="./assets/images/img_zhongdianlukou.png">
                </span>
            </div>
            <div class="home8">
                <div class="btn">申请密匙</div>
                <p>注册为开发者,申请相应服务</p>
            </div>
        </div>
    </div>
</template>

<script>
module.exports = {
    //        props: ['paramData'],
    data: function() {
        return {
            who: 'home',
            value3: '',
            setting: {
                autoplay: false,
                autoplaySpeed: 2000,
                dots: 'inside',
                trigger: 'hover',
                arrow: 'hover'
            }
        };
    },
    methods: {
        showMsg: function() {
            /*VueScript2.load('js/test.js').then(function () {
                 showAbc();
                 });*/
        }
    },
    mounted: function() {
        console.log('home');
        commonUtils.setGbdHeight();
        $('.g-mn .home4 .link div[class*="link-item"]').hover(
            function() {
                $(this)
                    .children()
                    .find('img')
                    .animate({
                        height: '120%',
                        width: '120%',
                        margin: '-10% 0 0 -10%'
                    });
            },
            function() {
                $(this)
                    .children()
                    .find('img')
                    .animate({
                        height: '100%',
                        width: '100%',
                        margin: '0'
                    });
            }
        );
    },
    beforeDestroy: function() {}
};
</script>

<style>
.g-carousel {
    height: 510px;
    text-align: center;
    color: #fff;
}
.g-mn h1 {
    text-align: center;
    font-size: 50px;
    font-weight: normal;
    letter-spacing: 5px;
    line-height: 56px;
}
.g-mn h2 {
    text-align: center;
    padding-top: 20px;
    font-weight: normal;
    letter-spacing: 1px;
    font-size: 21px;
}
.g-mn div[class*='home'] {
    padding: 60px 25px 30px;
}
.g-mn .pic1 {
    background: url('../../assets/images/home_pic1.png') no-repeat;
    background-size: cover;
}
.g-mn .pic2 {
    background: url('../../assets/images/11.png') no-repeat;
    background-size: cover;
}
.g-mn .pic1 .i1 {
    padding-top: 145px;
    font-size: 60px;
    line-height: 60px;
    color: #fff;
}
.g-mn .pic1 .i2 {
    padding-top: 65px;
    font-size: 25px;
    line-height: 65px;
    color: #fff;
}
.g-mn .home2 .m-link {
    margin-top: 73px;
    text-align: center;
}
.g-mn .home2 .m-link div[class*='icon'] {
    display: inline-block;
    padding: 82px 0 0 0;
    width: 136px;
    font-size: 16px;
    cursor: pointer;
}
.g-mn .home2 .m-link div[class*='icon']:hover {
    display: inline-block;
    padding: 82px 0 0 0;
    width: 136px;
    font-size: 17px;
    cursor: pointer;
    color: #026acb;
}
.g-mn .home2 .m-link .icon1 {
    background: url(../../assets/images/icon_tucheng_gray.png)top center no-repeat;
}
.g-mn .home2 .m-link .icon1:hover {
    background: url(../../assets/images/home2_tcfw.png)top center no-repeat;
}
.g-mn .home2 .m-link .icon2 {
    background: url(../../assets/images/icon_tiaoxian_gray.png)top center no-repeat;
}
.g-mn .home2 .m-link .icon2:hover {
    background: url(../../assets/images/icon_tiaoxian.png)top center no-repeat;
}
.g-mn .home2 .m-link .icon3 {
    background: url(../../assets/images/icon_ditugongju_gray.png)top center no-repeat;
}
.g-mn .home2 .m-link .icon3:hover {
    background: url(../../assets/images/icon_ditugongju.png)top center no-repeat;
}
.g-mn .home2 .m-link .icon4 {
    background: url(../../assets/images/icon_ercikaifa_gray.png)top center no-repeat;
}
.g-mn .home2 .m-link .icon4:hover {
    background: url(../../assets/images/icon_ercikaifa.png)top center no-repeat;
}
.g-mn .home2 .m-link .icon5 {
    background: url(../../assets/images/icon_quanjingshuju_gray.png)top center no-repeat;
}
.g-mn .home2 .m-link .icon5:hover {
    background: url(../../assets/images/icon_quanjingshuju.png)top center no-repeat;
}
.g-mn .home2 .m-link .icon6 {
    background: url(../../assets/images/icon_ercikaifazuce_gray.png)top center no-repeat;
}
.g-mn .home2 .m-link .icon6:hover {
    background: url(../../assets/images/icon_ercikaifazuce.png)top center no-repeat;
}
.g-mn .home3 {
    height: 400px;
    background: url(../../assets/images/home3_bg.png) 85% center no-repeat
        #2a2d32;
    color: #fff;
}
.g-mn .home3 h3 {
    padding: 0 60px;
    font-size: 28px;
    letter-spacing: 2px;
}
.g-mn .home3 .ul1 {
    display: inline-block;
    padding-left: 80px;
}
.g-mn .home3 .ul2 {
    padding-left: 50px;
    display: inline-block;
}
.g-mn .home3 li {
    padding-top: 35px;
    font-size: 17px;
}
.g-mn .home3 li:hover {
    padding-top: 35px;
    font-size: 17px;
    color: #026acb;
    cursor: pointer;
}
.g-mn .home3 .ul2 .btn {
    width: 100px;
    line-height: 32px;
}
.g-mn .home3 .ul2 .btn:hover {
    width: 100px;
    line-height: 32px;
    background: #026acb;
    border: 1px solid #026acb;
}
.g-mn .home4 .link {
    padding-top: 30px;
    text-align: center;
}
.bounce-enter-active,
.bounce-leave-active {
    transition: opacity 0.5s;
}
.bounce-enter,
.bounce-leave-to {
    opacity: 0;
}
.g-mn .home4 .link div {
    display: inline-block;
    margin: 0 20px;
    padding-bottom: 10px;
    width: 290px;
    height: 370px;
}
.g-mn .home4 .link .link-item1 {
    background: url(../../assets/images/icon_biaozhundizhi_red.png) center 95%
        no-repeat #f0f0f0;
    background-size: 35px;
}
.g-mn .home4 .link span {
    display: inline-block;
    width: 100%;
    height: 212px;
    overflow: hidden;
}
.g-mn .home4 .link img {
    width: 100%;
    height: 100%;
}
.g-mn .home4 .link .link-item2 {
    background: url(../../assets/images/icon_shujucaiji_red.png) center 95%
        no-repeat #f0f0f0;
    background-size: 50px;
}
.g-mn .home4 .link h2 {
    padding-top: 18px;
    font-weight: bolder;
    font-size: 18px;
}
.g-mn .home4 .link p {
    padding: 10px 15px 0 15px;
    font-size: 13px;
}
.g-mn .home5 {
    background: #2a2d32;
}
.g-mn .home5 h1,
.g-mn .home5 h2,
.g-mn .home5 p {
    color: #fff;
}
.g-mn .home5 li {
    display: inline-block;
    padding: 3px 25px;
    width: 264px;
    height: 235px;
    cursor: pointer;
}
.g-mn .home5 li:hover {
    box-shadow: 0px 0px 9px #000;
}
.g-mn .home5 ul {
    padding-top: 30px;
    text-align: center;
}
.g-mn .home5 li h1 {
    padding-top: 72px;
    text-align: center;
    font-size: 20px;
    font-weight: bolder;
    letter-spacing: 1px;
    line-height: 46px;
    color: #de522e;
}
.g-mn .home5 .li1 {
    background: url(../../assets/images/icon_shipingjiankong.png) center 8%
        no-repeat;
}
.g-mn .home5 .li2 {
    background: url(../../assets/images/icon_gpszhuanfapingtai.png) center 8%
        no-repeat;
}
.g-mn .home5 .li3 {
    background: url(../../assets/images/icon_mianqucaiji.png) center 8%
        no-repeat;
}
.g-mn .home5 .li4 {
    background: url(../../assets/images/icon_zhongdianrenyuan.png) center 8%
        no-repeat;
}
.g-mn .home5 .li5 {
    background: url(../../assets/images/icon_tusou.png) center 8% no-repeat;
}
.g-mn .home5 .li6 {
    background: url(../../assets/images/icon_zhituxitong.png) center 8%
        no-repeat;
}
.g-mn .home6 {
    text-align: center;
}
.g-mn .home6 .m1,
.g-mn .home6 .m2 {
    display: inline-block;
    width: 300px;
    height: 430px;
    border-radius: 18px;
    text-align: center;
    margin: 30px 10px 0;
    background: #f5f7f7;
}
.g-mn .home6 .title1 {
    background: url(../../assets/images/icon_webkaifa.png)65px center no-repeat #3f76b1;
    height: 70px;
    border-top-left-radius: 18px;
    border-top-right-radius: 18px;
    font-size: 23px;
    color: #fff;
    line-height: 70px;
    padding-left: 60px;
}
.g-mn .home6 .title2 {
    background: url(../../assets/images/icon_yidongkaifa.png)65px center no-repeat #3f76b1;
    height: 70px;
    border-top-left-radius: 18px;
    border-top-right-radius: 18px;
    font-size: 23px;
    color: #fff;
    line-height: 70px;
    padding-left: 60px;
}
.g-mn .home6 li {
    font-size: 19px;
    margin-top: 23px;
    cursor: pointer;
}
.g-mn .home6 li:hover {
    color: #026acb;
    font-size: 20px;
    margin-top: 23px;
    cursor: pointer;
}
.g-mn .home7 {
    padding: 60px 0 0 0 !important;
    background: #2a2d32;
    color: #fff;
}
.g-mn .home7 span {
    display:inline-block;
    width:100%;
    height:360.8px;
    margin:50px 0 0 0;
    overflow: hidden;
}
.g-mn .home7 span img {
    width: 1024px;
    height:360.8px;
    transition: all 0.6s;
}
.g-mn .home7 span img:hover {
    transform: scale(1.2);
}
.g-mn .home8 {
    margin-top:-8px;
    padding: 0 !important;
    text-align: center;
    height: 450px;
    background: url(../../assets/images/img_shengqingmishi.png);
}
.g-mn .home8 .btn {
    display: inline-block;
    margin: 194px 0 25px;
    width: 185px;
    height: 50px;
    line-height: 43px;
    font-size: 23px;
    border-radius: 25px;
    border: 2px solid;
    font-weight: 100;
}
.g-mn .home8 .btn:hover {
    background: #026acb;
    border: 2px solid #026acb;
}
.g-mn .home8 p {
    display: block;
    font-size: 20px;
    color: #fff;
}
</style>