package hr.java.matijevic.vaxapp;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class VaccineDTO {

    private String producerName;
    private String scienceName;
    private int necessaryNumOfVaccine;



    public VaccineDTO(String scienceName, String producerName, int neccesaryNumVacine) {
        this.scienceName = scienceName;
        this.producerName = producerName;
        this.necessaryNumOfVaccine = neccesaryNumVacine;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public int getNecessaryNumOfVaccine() {
        return necessaryNumOfVaccine;
    }

    public void setNecessaryNumOfVaccine(int necessaryNumOfVaccine) {
        this.necessaryNumOfVaccine = necessaryNumOfVaccine;
    }

    public String getScienceName() {
        return scienceName;
    }

    public void setScienceName(String scienceName) {
        this.scienceName = scienceName;
    }
}
