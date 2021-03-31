package hr.java.matijevic.vaxapp;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class VaccineDTO {

    private String producerName;
    private int neccesaryNumVacine;

    public VaccineDTO(String producerName, int neccesaryNumVacine) {
        this.producerName = producerName;
        this.neccesaryNumVacine = neccesaryNumVacine;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public int getNeccesaryNumVacine() {
        return neccesaryNumVacine;
    }

    public void setNeccesaryNumVacine(int neccesaryNumVacine) {
        this.neccesaryNumVacine = neccesaryNumVacine;
    }


}
