package hr.java.matijevic.vaxapp.sideEffect;


import hr.java.matijevic.vaxapp.Vaccine;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Sideeffects")
public class SideEffect implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idside")
    private long id;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "percentage")
    private int percentageOfEffect;

    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "idvaccineside")
    private int idVaccine;

    @ManyToOne
    @JoinColumn(name = "id")
    private Vaccine vaccine;



    public SideEffect( long id,String shortDescription, int percentageOfEffect, String longDescription, int idVaccine) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.percentageOfEffect = percentageOfEffect;
        this.longDescription = longDescription;
        this.idVaccine = idVaccine;
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

    public int getIdVaccine() {
        return idVaccine;
    }

    public void setIdVaccine(int idVaccine) {
        this.idVaccine = idVaccine;
    }
}
