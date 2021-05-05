package hr.java.matijevic.vaxapp;

import hr.java.matijevic.vaxapp.sideEffect.SideEffect;

import javax.validation.constraints.*;
import java.util.Date;

public class VaccineCommand {

    @NotNull(message = "Must not be empty")
    private long id;

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


    public long getId() { return id;}
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


}
