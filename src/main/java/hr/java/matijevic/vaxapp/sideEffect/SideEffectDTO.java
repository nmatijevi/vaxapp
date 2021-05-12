package hr.java.matijevic.vaxapp.sideEffect;

public class SideEffectDTO {

    private String shortDescription;
    private Number frequency;
    private String description;

    public SideEffectDTO(String shortDescription, Number frequency, String description) {
        this.shortDescription = shortDescription;
        this.frequency = frequency;
        this.description = description;
    }


    public String getShortDescription() { return shortDescription; }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Number getFrequency() {
        return frequency;
    }

    public void setFrequency(Number frequency) {
        this.frequency = frequency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
