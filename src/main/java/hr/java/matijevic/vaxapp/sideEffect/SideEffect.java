package hr.java.matijevic.vaxapp.sideEffect;


import hr.java.matijevic.vaxapp.Vaccine;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Sideeffects")
public class SideEffect implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "percentage")
    private int frequency;

    @Column(name = "long_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "idvaccine")
    private Vaccine vaccine;

    private String researchName;

    public SideEffect(long id, String shortDescription, int frequency, String description) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.frequency = frequency;
        this.description = description;

    }

    public SideEffect() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int percentageOfEffect) {
        this.frequency = percentageOfEffect;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String longDescription) {
        this.description = longDescription;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public String getResearchName() {
        return researchName;
    }

    public void setScienceName(String researchName) {
        this.researchName = researchName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SideEffect)) return false;
        SideEffect that = (SideEffect) o;
        return getId() == that.getId() && getFrequency() == that.getFrequency() && Objects.equals(getShortDescription(), that.getShortDescription()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getVaccine(), that.getVaccine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getShortDescription(), getFrequency(), getDescription(), getVaccine());
    }
}
