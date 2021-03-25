package hr.java.matijevic.vaxapp;

import java.util.List;

public interface VaccineService {

    List<VaccineDTO> findAll();

    VaccineDTO findVaccineByResearchName(String researchName);

    List<Vaccine> findVaccineByTypeOfVaccine(String typeOfVaccine);
}
