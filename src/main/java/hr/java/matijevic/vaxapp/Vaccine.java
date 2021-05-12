package hr.java.matijevic.vaxapp;

import hr.java.matijevic.vaxapp.sideEffect.SideEffect;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Vaccines")
public class Vaccine {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "research_name")
    private String researchName;

    @Column(name = "producer_name")
    private String manufacturerName;

    @Column(name = "type_vaccine")
    private String type;

    @Column(name = "necessary_vaccine")
    private Integer numberOfShots;

    @Column(name = "available_vaccine")
    private Integer availableDoses;

    @OneToMany(mappedBy = "vaccine", fetch = FetchType.LAZY)
    private List<SideEffect> sideEffectList;

    public Vaccine() {

    }
    public Vaccine(long id, String researchName, String manufacturerName, String type, Integer numberOfShots, Integer availableDoses) {
        this.id = id;
        this.researchName = researchName;
        this.manufacturerName = manufacturerName;
        this.type = type;
        this.numberOfShots = numberOfShots;
        this.availableDoses = availableDoses;

    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public void setType(String typeOfVaccine) {
        this.type = typeOfVaccine;
    }
    public String getResearchName() {
        return researchName;
    }

    public void setResearchName(String scienceName) {
        this.researchName = scienceName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String producerName) {
        this.manufacturerName = producerName;
    }

    public String getType() {
        return type;
    }

    public void setTypeOfVacine(String typeOfVacine) {
        this.type = typeOfVacine;
    }

    public Integer getNumberOfShots() {
        return numberOfShots;
    }

    public void setNumberOfShots(Integer necessaryNumOfVaccine) {
        this.numberOfShots = necessaryNumOfVaccine;
    }
    public Integer getAvailableDoses() {
        return availableDoses;
    }
    public void setAvailableDoses(Integer availableVaccine) {
        this.availableDoses = availableVaccine;
    }

    public List<SideEffect> getSideEffectList() {
        return sideEffectList;
    }

    public void setSideEffectList(List<SideEffect> sideEffectList) {
        this.sideEffectList = sideEffectList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vaccine)) return false;
        Vaccine vaccine = (Vaccine) o;
        return getId() == vaccine.getId() && Objects.equals(getResearchName(), vaccine.getResearchName()) && Objects.equals(getManufacturerName(), vaccine.getManufacturerName()) && Objects.equals(getType(), vaccine.getType()) && Objects.equals(getNumberOfShots(), vaccine.getNumberOfShots()) && Objects.equals(getAvailableDoses(), vaccine.getAvailableDoses()) && Objects.equals(sideEffectList, vaccine.sideEffectList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getResearchName(), getManufacturerName(), getType(), getNumberOfShots(), getAvailableDoses(), sideEffectList);
    }
}
