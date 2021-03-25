package hr.java.matijevic.vaxapp;

import java.util.List;

public interface VaccineService {

    List<VaccineDTO> findAll();

    VaccineDTO findVaccineByResearchName(String researchName);

    VaccineDTO findVaccineByTypeOfVaccine(String typeOfVaccine);
}
