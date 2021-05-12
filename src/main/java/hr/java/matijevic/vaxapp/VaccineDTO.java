package hr.java.matijevic.vaxapp;

public class VaccineDTO {

    private String researchName;
    private String manufacturerName;
    private String type;
    private Integer numberOfShots;
    private Integer availableDoses;


    public VaccineDTO(String researchName, String manufacturerName, String type, Integer numberOfShots, Integer availableDoses) {
        this.researchName = researchName;
        this.manufacturerName = manufacturerName;
        this.type = type;
        this.numberOfShots = numberOfShots;
        this.availableDoses = availableDoses;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public int getNumberOfShots() {
        return numberOfShots;
    }

    public void setNumberOfShots(int numberOfShots) {
        this.numberOfShots = numberOfShots;
    }

    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNecessaryNumOfVaccine(Integer necessaryNumOfVaccine) {
        this.numberOfShots = necessaryNumOfVaccine;
    }

    public Integer getAvailableDoses() {
        return availableDoses;
    }

    public void setAvailableDoses(Integer availableDoses) {
        this.availableDoses = availableDoses;
    }
}
