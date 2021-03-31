package hr.java.matijevic.vaxapp;

public class Vaccine {

    private String scienceName;
    private String producerName;
    private String typeOfVaccine;
    private Integer necessaryNumVaccine;
    private Integer availableVaccine;

    public Vaccine(String scienceName, String producerName, String typeOfVaccine, Integer necessaryNumVaccine, Integer availableVaccine) {
        this.scienceName = scienceName;
        this.producerName = producerName;
        this.typeOfVaccine = typeOfVaccine;
        this.necessaryNumVaccine = necessaryNumVaccine;
        this.availableVaccine = availableVaccine;
    }



    public String getScienceName() {
        return scienceName;
    }

    public void setScienceName(String scienceName) {
        this.scienceName = scienceName;
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

    public Integer getNecessaryNumVaccine() {
        return necessaryNumVaccine;
    }

    public void setNecessaryNumVaccine(Integer necessaryNumVaccine) {
        this.necessaryNumVaccine = necessaryNumVaccine;
    }

    public Integer getAvailableVaccine() {
        return availableVaccine;
    }

    public void setAvailableVaccine(Integer availableVaccine) {
        this.availableVaccine = availableVaccine;
    }
}
