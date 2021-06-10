package hr.java.matijevic.vaxapp;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(SampleJob.class).withIdentity("objavaJob").storeDurably().build();

    }

    @Bean
    public Trigger objavaJobTrigger(){
        
        Trigger trigger = newTrigger()
                .withIdentity("objavaJob")
                .withSchedule(cronSchedule("0 0 12 ? * MON-FRI"))
                .forJob(jobDetail())
                .build();

      //  SimpleScheduleBuilder schedulerBuilder = SimpleScheduleBuilder.simpleSchedule()
       //         .withIntervalInSeconds(10).repeatForever();

        /*return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("objavaTrigger").withSchedule(trigger).build();
        */
        return trigger;
    }
}

