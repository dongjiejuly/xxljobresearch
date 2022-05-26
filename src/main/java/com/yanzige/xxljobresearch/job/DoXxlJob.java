package com.yanzige.xxljobresearch.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DoXxlJob {

    // 注：XxlJob("doFirstJob") 中的名字doFirstJob为执行器JobHandler的名字，需要在调度中心进行配置
    @XxlJob("doFirstJob")
    public void doFirstJob(){
        log.info("通过定时任务执行开始");
        // 编写业务逻辑
        log.info("通过定时任务执行结束");
    }
}
