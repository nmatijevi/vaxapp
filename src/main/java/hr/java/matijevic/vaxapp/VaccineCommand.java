package hr.java.matijevic.vaxapp;

import javax.validation.constraints.*;

public class VaccineCommand {


    @NotBlank(message = "Must not be empty")
    private String scienceName;

    @NotBlank(message = "Must not be empty")
    private String producerName;

    @NotBlank(message = "Must not be empty")
    private String typeOfVaccine;

    @NotNull(message = "Must not be null")
    private Integer necessaryNumOfVaccine;

    @PositiveOrZero(message = "Must be positive number or zero")
    @NotNull(message = "Must not be null")
    private Integer availableVaccine;

    private SideEffect sideEffect;

    public String getScienceName() {
        return scienceName;
    }
    public String getProducerName() {
        return producerName;
    }
    public String getTypeOfVaccine() {
        return typeOfVaccine;
    }
    public Integer getNecessaryNumOfVaccine() {
        return necessaryNumOfVaccine;
    }
    public Integer getAvailableVaccine() {
        return availableVaccine;
    }
    public SideEffect getSideEffect() {return sideEffect;}
}
