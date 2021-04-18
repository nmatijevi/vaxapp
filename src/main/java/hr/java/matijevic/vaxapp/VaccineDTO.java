package hr.java.matijevic.vaxapp;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class VaccineDTO {

    private String producerName;
    private String scienceName;
    private int necessaryNumOfVaccine;
    private SideEffect sideEffect;



    public VaccineDTO(String scienceName, String producerName, int neccesaryNumVacine, SideEffect sideEffect ) {
        this.scienceName = scienceName;
        this.producerName = producerName;
        this.necessaryNumOfVaccine = neccesaryNumVacine;
        this.sideEffect = sideEffect;
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
    public SideEffect sideEffect(){ return sideEffect;}
    public void setSideEffect(SideEffect sideEffect) { this.sideEffect = sideEffect;}
}
