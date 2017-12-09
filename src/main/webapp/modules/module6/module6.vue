<template>
    <div>
        <div class="hello">Hello {{who}}</div>
        <div class="hello">
            <button @click="showMsg">Click me</button>
        </div>
        {{paramData}}
    </div>
</template>

<script>
    module.exports = {
        props: ['paramData'],
        data: function () {
            return {
                who: 'module6'
            }
        },
        methods: {
            showMsg: function () {
                showAbc();
            }
        },
        mounted: function () {
        },
        beforeDestroy: function () {
        }
    }
</script>

<style>
    .hello {
        background-color: #ffe;
    }
</style>