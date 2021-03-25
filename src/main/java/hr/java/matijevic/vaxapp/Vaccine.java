package hr.java.matijevic.vaxapp;

public class Vaccine {

    private String researchName;
    private String producerName;
    private String typeOfVaccine;
    private Integer necessaryNumVacine;
    private Integer availableVacine;

    public Vaccine(String researchName, String producerName, String typeOfVaccine, Integer necessaryNumVacine, Integer availableVacine) {
        this.researchName = researchName;
        this.producerName = producerName;
        this.typeOfVaccine = typeOfVaccine;
        this.necessaryNumVacine = necessaryNumVacine;
        this.availableVacine = availableVacine;
    }

    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getTypeOfVaccine() {
        return typeOfVaccine;
    }

    public void setTypeOfVacine(String typeOfVacine) {
        this.typeOfVaccine = typeOfVacine;
    }

    public Integer getNecessaryNumVacine() {
        return necessaryNumVacine;
    }

    public void setNecessaryNumVacine(Integer necessaryNumVacine) {
        this.necessaryNumVacine = necessaryNumVacine;
    }

    public Integer getAvailableVacine() {
        return availableVacine;
    }

    public void setAvailableVacine(Integer availableVacine) {
        this.availableVacine = availableVacine;
    }
}
