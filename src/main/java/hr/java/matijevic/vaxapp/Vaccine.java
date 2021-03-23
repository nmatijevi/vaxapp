package hr.java.matijevic.vaxapp;

public class Vaccine {

    private String researchName;
    private String producerName;
    private String typeOfVacine;
    private Integer necessaryNumVacine;
    private Integer availableVacine;

    public Vaccine(String researchName, String producerName, String typeOfVacine, Integer necessaryNumVacine, Integer availableVacine) {
        this.researchName = researchName;
        this.producerName = producerName;
        this.typeOfVacine = typeOfVacine;
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

    public String getTypeOfVacine() {
        return typeOfVacine;
    }

    public void setTypeOfVacine(String typeOfVacine) {
        this.typeOfVacine = typeOfVacine;
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
