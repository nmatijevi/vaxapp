package hr.java.matijevic.vaxapp;

import hr.java.matijevic.vaxapp.sideEffect.SideEffect;
import org.hibernate.annotations.Fetch;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Vaccines")
public class Vaccine {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "science_name")
    private String scienceName;

    @Column(name = "producer_name")
    private String producerName;

    @Column(name = "type_vaccine")
    private String typeOfVaccine;

    @Column(name = "necessary_vaccine")
    private Integer necessaryNumOfVaccine;

    @Column(name = "available_vaccine")
    private Integer availableVaccine;

    @OneToMany(mappedBy = "vaccine", fetch = FetchType.LAZY)
    private List<SideEffect> sideEffectList;

    public Vaccine() {

    }
    public Vaccine(long id, String scienceName, String producerName, String typeOfVaccine, Integer necessaryNumOfVaccine, Integer availableVaccine) {
        this.id = id;
        this.scienceName = scienceName;
        this.producerName = producerName;
        this.typeOfVaccine = typeOfVaccine;
        this.necessaryNumOfVaccine = necessaryNumOfVaccine;
        this.availableVaccine = availableVaccine;

    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public void setTypeOfVaccine(String typeOfVaccine) {
        this.typeOfVaccine = typeOfVaccine;
    }
    public String getScienceName() {
        return scienceName;
    }

    public void setScienceName(String scienceName) {
        this.scienceName = scienceName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getTypeOfVaccine() {
        return typeOfVaccine;
    }

    public void setTypeOfVacine(String typeOfVacine) {
        this.typeOfVaccine = typeOfVacine;
    }

    public Integer getNecessaryNumOfVaccine() {
        return necessaryNumOfVaccine;
    }

    public void setNecessaryNumOfVaccine(Integer necessaryNumOfVaccine) {
        this.necessaryNumOfVaccine = necessaryNumOfVaccine;
    }
    public Integer getAvailableVaccine() {
        return availableVaccine;
    }
    public void setAvailableVaccine(Integer availableVaccine) {
        this.availableVaccine = availableVaccine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vaccine)) return false;
        Vaccine vaccine = (Vaccine) o;
        return getId() == vaccine.getId() && Objects.equals(getScienceName(), vaccine.getScienceName()) && Objects.equals(getProducerName(), vaccine.getProducerName()) && Objects.equals(getTypeOfVaccine(), vaccine.getTypeOfVaccine()) && Objects.equals(getNecessaryNumOfVaccine(), vaccine.getNecessaryNumOfVaccine()) && Objects.equals(getAvailableVaccine(), vaccine.getAvailableVaccine()) && Objects.equals(sideEffectList, vaccine.sideEffectList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getScienceName(), getProducerName(), getTypeOfVaccine(), getNecessaryNumOfVaccine(), getAvailableVaccine(), sideEffectList);
    }
}
