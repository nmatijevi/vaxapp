package hr.java.matijevic.vaxapp;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface VaccineRepository {

    List<Vaccine> findAll();

    Optional<Vaccine> findVaccineByResearchName(String researchName);

    List<Vaccine> findVaccineByTypeOfVaccine(String typeOfVaccine);

    boolean deleteByScienceName(String scienceName);

    Optional<Vaccine> save(Vaccine vaccine);
}
