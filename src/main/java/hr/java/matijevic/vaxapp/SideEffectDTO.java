package hr.java.matijevic.vaxapp;

public class SideEffectDTO {

    private String shortDescription;
    private Number percentageOfEffect;
    private String longDescription;

    public SideEffectDTO(String shortDescription, Number percentageOfEffect, String longDescription) {
        this.shortDescription = shortDescription;
        this.percentageOfEffect = percentageOfEffect;
        this.longDescription = longDescription;
    }


    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Number getPercentageOfEffect() {
        return percentageOfEffect;
    }

    public void setPercentageOfEffect(Number percentageOfEffect) {
        this.percentageOfEffect = percentageOfEffect;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

}
