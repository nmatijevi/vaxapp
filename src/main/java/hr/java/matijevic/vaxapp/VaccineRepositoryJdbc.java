package hr.java.matijevic.vaxapp;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepositoryJdbc {

    List<Vaccine> findAll();
    Optional<Vaccine> save(Vaccine vaccine);

    Vaccine findOne(Integer id);
    List<Vaccine> findVaccineByTypeOfVaccine(String typeOfVaccine);
    Optional<Vaccine> findVaccineByResearchName(String scienceName);
    boolean deleteByScienceName(String scienceName);
    Optional<Vaccine> update(String producerName, Vaccine vaccine);
}
