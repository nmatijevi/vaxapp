package hr.java.matijevic.vaxapp;

import java.util.List;
import java.util.Optional;

interface VaccineRepository {

    List<Vaccine> findAll();

    Optional<Vaccine> findVaccineByResearchName(String researchName);

    Optional<Vaccine> findVaccineByTypeOfVaccine(String typeOfVaccine);

}
