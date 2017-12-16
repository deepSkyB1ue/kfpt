<template>
    <div>
        <div style="width: 100%;background-color: #262834;">
            <div class="header_background">
                <div class="header_txt">
                    <div style="margin-left: 4%;">
                        <p style="font-size: 32px;height: 80px;line-height: 90px;">开发文档</p>
                        <p style="font-size: 12px;height: 60px;line-height: 40px;">
                            基于互联网环境,抓取互联网的全景地图数据,经数据处理后形成图层供PGIS平台调用</p>
                    </div>
                </div>
                <div class="headerImg">
                    <img src="assets/images/home3_bg.png"/>
                </div>
            </div>
        </div>
        <div id="container">
            <div id="main">/
                <!--导航栏-->
                <div class="navContainer">
                    <div class="navContainerStyle">
                        <div class="webStyle">
                            <p>Web服务API</p>
                        </div>
                        <div class="navStyle">
                            <gaea-Menu mode="vertical" theme="light" @on-select="openModule" active-name="dataDefine"
                                       accordion>
                                <gaea-menu-item name="dataDefine">数据类型和格式</gaea-menu-item>
                                <gaea-menu-item name="yuanData">元数据规范</gaea-menu-item>
                                <gaea-menu-item name="callBack_explain">回调函数（事件）说明</gaea-menu-item>
                                <gaea-menu-item name="jkUseSample">接口调用示例</gaea-menu-item>

                                <gaea-Submenu name="1">
                                    <template slot="title">
                                        <!--<gaea-Icon type="stats-bars"></gaea-Icon>-->
                                        图层示例
                                    </template>
                                    <gaea-menu-item name="pointShow">点位显示</gaea-menu-item>
                                    <gaea-menu-item name="polylineShow">线显示</gaea-menu-item>
                                    <gaea-menu-item name="polygonShow">面显示</gaea-menu-item>
                                    <gaea-menu-item name="circleShow">圆显示</gaea-menu-item>
                                    <gaea-menu-item name="rectangleShow">矩形显示</gaea-menu-item>
                                    <gaea-menu-item name="baseLayer">地图底图显示</gaea-menu-item>
                                    <!--<gaea-menu-item name="ztyuan">子图源显示(暂时移除)</gaea-menu-item>-->
                                    <gaea-menu-item name="mapInfo">图层信息</gaea-menu-item>
                                </gaea-Submenu>
                                <gaea-Submenu name="4">
                                    <template slot="title">
                                        <!--<gaea-Icon type="stats-bars"></gaea-Icon>-->
                                        接口数据规范
                                    </template>
                                    <gaea-menu-item name="setPlayback">设置轨迹回放</gaea-menu-item>

                                </gaea-Submenu>
                            </gaea-Menu>
                        </div>
                    </div>
                </div>
                <!--content-->
                <div class="particularsContainer">
                    <gaea-breadcrumb class="breadcrumbStyle" separator=">">
                        <gaea-breadcrumb-item>您现在的位置</gaea-breadcrumb-item>
                        <gaea-breadcrumb-item>二次开发</gaea-breadcrumb-item>
                        <gaea-breadcrumb-item>Web</gaea-breadcrumb-item>
                        <gaea-breadcrumb-item>{{content_mbx}}</gaea-breadcrumb-item>
                    </gaea-breadcrumb>
                    <div class="textTitle">
                        <p>{{content_title}}</p>
                    </div>
                    <div class="verticalLayout_father" v-if="content_src!=''">
                        <!--<div class="detailIcon">-->
                        <!--<img src="" alt="详情">-->
                        <!--</div>-->
                        <div class="detailImg">
                            <img width=100% height=100% :src="content_src">
                        </div>
                    </div>
                    <div v-html="content_html">
                        {{content_html}}
                    </div>

                </div>

            </div>
        </div>
    </div>
</template>
<script>
    const menList = [
        {
            name: 'dataDefine',
            dataContent: {
                mbx: '基本数据类型和格式定义',
                title: '基本数据类型和格式定义',
                src: '',
                html: './modules/documents/web/contentDoc/dataDefine.html'
            }
        },
        {
            name: 'yuanData',
            dataContent: {
                mbx: '元数据规范',
                title: '元数据规范',
                src: '',
                html: './modules/documents/web/contentDoc/yuanData.html'
            }
        },
        {
            name: 'callBack_explain',
            dataContent: {
                mbx: '回调函数（事件）说明',
                title: '回调函数（事件）说明',
                src: '',
                html: './modules/documents/web/contentDoc/callBack_explain.html'
            }
        },
        {
            name: 'jkUseSample',
            dataContent: {
                mbx: '接口调用示例',
                title: '接口调用示例',
                src: '',
                html: './modules/documents/web/contentDoc/jkUseSample.html'
            }
        },
        {
            name: 'pointShow',
            dataContent: {
                mbx: '点位显示',
                title: '点位显示',
                src: 'assets/images/drawPoint.png',
                html: './modules/documents/web/contentDoc/pointShow.html'
            }
        },
        {
            name: 'polylineShow',
            dataContent: {
                mbx: '线显示',
                title: '线显示',
                src: 'assets/images/drawPolyline.png',
                html: './modules/documents/web/contentDoc/polylineShow.html'
            }
        },
        {
            name: 'polygonShow',
            dataContent: {
                mbx: '面显示',
                title: '面显示',
                src: 'assets/images/drawPolygon.png',
                html: './modules/documents/web/contentDoc/polygonShow.html'
            }
        },
        {
            name: 'circleShow',
            dataContent: {
                mbx: 'circleShow',
                title: '圆显示',
                src: 'assets/images/drawCircle.png',
                html: './modules/documents/web/contentDoc/circleShow.html'
            }
        },
        {
            name: 'rectangleShow',
            dataContent: {
                mbx: '矩形显示',
                title: '矩形显示',
                src: 'assets/images/drawRectangle.png',
                html: './modules/documents/web/contentDoc/rectangleShow.html'
            }
        },
        {
            name: 'baseLayer',
            dataContent: {
                mbx: '底图显示',
                title: '底图显示',
                src: 'assets/images/addMapObj.png',
                html: './modules/documents/web/contentDoc/baseLayer.html'
            }
        },
//        {
//            name: 'ztyuan',
//            dataContent: {
//                mbx: '子图源显示',
//                title: '子图源显示',
//                src: '',
//                html: './modules/documents/web/contentDoc/ztyuan.html'
//            }
//        },
        {
            name: 'mapInfo',
            dataContent: {
                mbx: '图层信息',
                title: '图层信息',
                src: '',
                html: './modules/documents/web/contentDoc/mapInfo.html'
            }
        },
        {
            name: 'setPlayback',
            dataContent: {
                mbx: '设置轨迹回放',
                title: '设置轨迹回放',
                src: 'assets/images/map_playBack.png',
                html: './modules/documents/web/contentDoc/setPlayback.html'
            }
        },


    ];
    module.exports = {
        data: function () {
            return {
                content_mbx: '',
                content_title: '',
                content_src: '',
                content_html: ''
            }
        },
        methods: {
            openModule (name) {
                console.log(name);
                if (menList.find(n => n.name === name)) {
                    let arr = menList.find(n => n.name === name);
                    this.content_mbx = arr.dataContent.mbx;
                    this.content_title = arr.dataContent.title;
                    this.content_src = arr.dataContent.src;
                    let that = this;
                    commonUtils.loadHtml(arr.dataContent.html, function (data) {
                        that.content_html = data;
                    });
                }
            }
        },
        mounted: function () {//初始化
            console.log('init');
            if (menList.find(n => n.name === 'dataDefine')) {
                let arr = menList.find(n => n.name === 'dataDefine');
                this.content_mbx = arr.dataContent.mbx;
                this.content_title = arr.dataContent.title;
                this.content_src = arr.dataContent.src;
                let that = this;
                commonUtils.loadHtml(arr.dataContent.html, function (data) {
                    that.content_html = data;
                });
            }
            commonUtils.setGbdHeight();//计算页面高度
        },
        beforeDestroy: function () {//关闭
            console.log('close');
        }
    };
</script>
<style>
    .header_background{
        background-color:#262834;
        width:1024px;
        margin:0 auto;
        display:flex;
        align-items:flex-start;
        color:#ffffff;
    }
    .header_txt{
        display:flex;
        flex-direction:column;
        justify-content:space-between;
        width:70%;
    }
    .headerImg{
        vertical-align:middle;
        text-align:left;
        width:30%;
    }
    .headerImg img{
        width:17.375em;
        height:12.5em;
    }
    #container{
        height:calc(100vh - 132px);
        width:1024px;
        margin:0 auto;
        font-family:'Source Sans Pro', 'Helvetica Neue', Arial, sans-serif;
        font-size:1em;
        -webkit-font-smoothing:antialiased;
        -moz-osx-font-smoothing:grayscale;
        color:#34495e;
        background-color:#fff;
    }
    /*
    flex新方案
    */
    #main{
        width:100%;
        height:100%;
        padding:20px 0;
        background-color:#ffffff;
        display:flex;
        align-items:flex-start;
    }
    #main .navContainer{
        flex:0 0 auto;
        overflow-x:hidden;
        overflow-y:auto;
        -webkit-overflow-scrolling:touch;
        -ms-overflow-style:none;
        user-select:none;
        background-color:#ffffff;
        height:100%;
    }
    .navContainerStyle{
        display:flex;
        flex-direction:column;
        justify-content:space-between;
    }
    .webStyle{
        text-align:center;
        background-color:#2db7f5;
    }
    .webStyle p{
        font-size:26px;
        color:#ffffff;
        height:48px;
        line-height:48px;
    }
    .navStyle ul{
        width:200px !important;
    }
    #main .particularsContainer{
        flex:1 1 auto;
        height:100%;
        /*background-color:  #C7EDCC;*/
        background-color:#ffffff;
        margin-left:20px;
        overflow-x:hidden;
        overflow-y:auto;
        -webkit-overflow-scrolling:touch;
        -ms-overflow-style:none;
    }
    /*
    垂直布局,父亲
    */
    .verticalLayout_father{
        display:flex;
        flex-direction:column;
        justify-content:space-between;
    }
    .breadcrumbStyle{
        display:block;
    }
    .textTitle{
        margin-top:16px;
    }
    .textTitle p{
        color:#1c2438;
        font-family:"Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
        font-size:16px;
        font-style:normal;
        font-weight:bolder;
    }
    .textBody{
        padding:16px 0;
    }
    .textBody p{
        /*text-indent: 2em;*/
        color:#1c2438;
        font-family:"Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
        font-size:14px;
        font-style:normal;
        font-weight:bolder;
        word-wrap:break-word;
        text-align:left;
        letter-spacing:2px;
        line-height:24px;
        Vertical-align:baseline;
        text-transform:none;
        text-shadow:none;
    }
    .textBody_explain p{
        /*text-indent: 2em;*/
        color:#1c2438;
        font-family:"Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
        font-size:13px;
        font-style:normal;
        font-weight:normal;
        word-wrap:break-word;
        text-align:left;
        letter-spacing:2px;
        line-height:24px;
        Vertical-align:baseline;
        text-transform:none;
        text-shadow:none;
        padding:16px 0 0 0;
    }
    .detailIcon{
        width:auto;
        height:40px;
    }
    .detailIcon img{
        float:right;
        _position:relative;
        width:120px;
        height:40px;
    }
    .detailImg{
        width:auto;
        height:400px;
        background-color:aliceblue;
    }
    .boxFlex{
        display:-moz-box; /* Firefox */
        display:-webkit-box; /* Safari and Chrome */
        width:100%;
        padding:5px 0;
    }
    .boxFlex p:nth-child(1){
        /*-moz-box-flex:1.0; !* Firefox *!*/
        /*-webkit-box-flex:1.0; !* Safari and Chrome *!*/
        width:10%;
    }
    .boxFlex p:nth-child(2){
        /*-moz-box-flex:8.0; !* Firefox *!*/
        /*-webkit-box-flex:8.0; !* Safari and Chrome *!*/
        width:90%;
    }
    .textBodyData p{
        padding:5px 0;
    }
    tbody td, thead td{
        vertical-align:middle;
        text-align:center;
    }
</style>

