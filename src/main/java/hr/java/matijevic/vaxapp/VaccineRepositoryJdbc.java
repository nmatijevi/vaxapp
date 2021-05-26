package hr.java.matijevic.vaxapp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public interface VaccineRepositoryJdbc {

    List<Vaccine> findAll();
    Optional<Vaccine> save(Vaccine vaccine);

    Vaccine findOne(Integer id);
    List<Vaccine> findVaccineByTypeOfVaccine(String typeOfVaccine);
    Optional<Vaccine> findVaccineByResearchName(String scienceName);
    Optional<Vaccine> findVaccineByManufacturerName(String producerName);
    boolean deleteByScienceName(String scienceName);
    List<Vaccine>findVaccineInsideVaccineBoundaries(Integer lowerNum, Integer higherNum);

    Optional<Vaccine> update(String producerName, Vaccine vaccine);
}
