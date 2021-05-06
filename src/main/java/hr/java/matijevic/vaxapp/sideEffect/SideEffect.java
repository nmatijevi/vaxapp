package hr.java.matijevic.vaxapp.sideEffect;


import hr.java.matijevic.vaxapp.Vaccine;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
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
    private int percentageOfEffect;

    @Column(name = "long_description")
    private String longDescription;

    @ManyToOne
    @JoinColumn(name = "idvaccine")
    private Vaccine vaccine;

    private String scienceName;

    public SideEffect( long id,String shortDescription, int percentageOfEffect, String longDescription) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.percentageOfEffect = percentageOfEffect;
        this.longDescription = longDescription;

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

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public String getScienceName() {
        return scienceName;
    }

    public void setScienceName(String scienceName) {
        this.scienceName = scienceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SideEffect)) return false;
        SideEffect that = (SideEffect) o;
        return getId() == that.getId() && getPercentageOfEffect() == that.getPercentageOfEffect() && Objects.equals(getShortDescription(), that.getShortDescription()) && Objects.equals(getLongDescription(), that.getLongDescription()) && Objects.equals(getVaccine(), that.getVaccine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getShortDescription(), getPercentageOfEffect(), getLongDescription(), getVaccine());
    }
}
