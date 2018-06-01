package com.example.localquartz;

import com.example.demo.job.BaseJob;
import com.example.demo.job.HelloJob;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class LocalHelloJob  implements BaseJob{

    private static Logger logger = LoggerFactory.getLogger(HelloJob.class);

    public LocalHelloJob() {

    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException {

        JobKey key = context.getJobDetail().getKey();

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String jobSays = dataMap.getString("jobSays");
        float myFloatValue = dataMap.getFloat("myFloatValue");

        System.err.println("====Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
        logger.info("LocalHello Job执行时间: " + new Date());

    }
}
