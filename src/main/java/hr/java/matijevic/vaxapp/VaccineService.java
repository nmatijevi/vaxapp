package hr.java.matijevic.vaxapp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VaccineService {

    List<VaccineDTO> findAll();

    VaccineDTO findVaccineByResearchName(String researchName);

    List<Vaccine> findVaccineByTypeOfVaccine(String typeOfVaccine);
    List<VaccineDTO>findVaccineInsideVaccineBoundaries(Integer lowerNum, Integer higherNum);

    boolean deleteByScienceName(String scienceName);

    Optional<VaccineDTO> save(VaccineCommand command);

    Optional<VaccineDTO> update(String producerName, VaccineCommand command);

}
