package hr.java.matijevic.vaxapp;

public class SideEffect {

    private String shortDescription;
    private int percentageOfEffect;
    private String longDescription;

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getPercentageOfEffect() {
        return percentageOfEffect;
    }

    public void setPercentageOfEffect(int percentageOfEffect) {
        this.percentageOfEffect = percentageOfEffect;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public SideEffect(String shortDescription, int percentageOfEffect, String longDescription) {
        this.shortDescription = shortDescription;
        this.percentageOfEffect = percentageOfEffect;
        this.longDescription = longDescription;
    }
}
