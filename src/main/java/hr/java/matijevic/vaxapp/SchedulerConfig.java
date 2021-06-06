package hr.java.matijevic.vaxapp;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(SampleJob.class).withIdentity("objavaJob").storeDurably().build();

    }

    @Bean
    public Trigger objavaJobTrigger(){
        SimpleScheduleBuilder schedulerBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();

        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("objavaTrigger").withSchedule(schedulerBuilder).build();
    }
}

