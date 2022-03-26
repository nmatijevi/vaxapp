package hr.java.matijevic.vaxapp;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class SampleJob extends QuartzJobBean {

    private VaccineRepositoryJdbc vaccineRepositoryJdbc = null;

    @Autowired
    public SampleJob(VaccineRepositoryJdbc vaccineRepositoryJdbc) {
        this.vaccineRepositoryJdbc = vaccineRepositoryJdbc;
    }

    private String name;

    public void setName(String name){
        this.name = name;
    }

    @Override
    //@Scheduled(cron = "0 12 * * 1-5")
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<Vaccine> vaccines = vaccineRepositoryJdbc.findAll();
        System.out.println("Ovo su trenutno dostupna cjepiva:");
        System.out.println("--------------------");
        for(Vaccine vaccine: vaccines){
            System.out.print(vaccine.getManufacturerName());
            System.out.println(" - " + vaccine.getAvailableDoses());
        }
        System.out.println("--------------------");

    }
}
