package hr.java.matijevic.vaxapp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VaccineService {

    List<VaccineDTO> findAll();

    VaccineDTO findVaccineByResearchName(String researchName);

    List<Vaccine> findVaccineByTypeOfVaccine(String typeOfVaccine);

    boolean deleteByScienceName(String scienceName);

    Optional<VaccineDTO> save(VaccineCommand command);

}
