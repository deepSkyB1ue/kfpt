package com.gaeainfo.module.base.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Rock on 2017/3/16.
 */
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void onApplicationEvent(ContextRefreshedEvent event){
        //root application context 没有parent，他就是老大.
        if(event.getApplicationContext().getParent() == null){
            //todo 应用启动后自动执行该部分代码
            logger.info("start application after system started");
        }
    }
}
