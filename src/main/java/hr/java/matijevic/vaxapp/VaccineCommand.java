package hr.java.matijevic.vaxapp;

import javax.validation.constraints.*;

public class VaccineCommand {

    @NotNull(message = "Must not be empty")
    private long id;

    @NotBlank(message = "Must not be empty")
    private String researchName;

    @NotBlank(message = "Must not be empty")
    private String manufacturerName;

    @NotBlank(message = "Must not be empty")
    private String type;

    @NotNull(message = "Must not be null")
    private Integer numberOfShots;

    @PositiveOrZero(message = "Must be positive number or zero")
    @NotNull(message = "Must not be null")
    private Integer availableDoses;



    public long getId() { return id;}
    public String getResearchName() {
        return researchName;
    }
    public String getManufacturerName() {
        return manufacturerName;
    }
    public String getType() {
        return type;
    }
    public Integer getNumberOfShots() {
        return numberOfShots;
    }
    public Integer getAvailableDoses() {
        return availableDoses;
    }


}
