package hr.java.matijevic.vaxapp;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceClass implements VaccineService, Serializable {

    private final VaccineRepositoryJdbc vaccineRepositoryJdbc;

    public ServiceClass(VaccineRepositoryJdbc vaccineRepositoryJdbc) {
        this.vaccineRepositoryJdbc = vaccineRepositoryJdbc;
    }

    @Override
    public List<VaccineDTO> findAll() {
        return vaccineRepositoryJdbc.findAll().stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }

    @Override
    public VaccineDTO findVaccineByResearchName(String researchName) {
        return vaccineRepositoryJdbc.findVaccineByResearchName(researchName).map(this::mapVaccineToDTO).orElse(null);
    }

    public List<Vaccine> findVaccineByTypeOfVaccine(String typeOfVaccine) {
      return vaccineRepositoryJdbc.findVaccineByTypeOfVaccine(typeOfVaccine);
    }

    @Override
    public List<VaccineDTO> findVaccineInsideVaccineBoundaries(Integer lowerNum, Integer higherNum) {
        return vaccineRepositoryJdbc.findVaccineInsideVaccineBoundaries(lowerNum, higherNum).stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }


    @Override
    public boolean deleteByScienceName(String scienceName) {
       return vaccineRepositoryJdbc.deleteByScienceName(scienceName);
    }

    @Override
    public Optional<VaccineDTO> save(VaccineCommand command) {
      return vaccineRepositoryJdbc.save(mapCommandToVaccine(command)).map(this::mapVaccineToDTO);
     }

    @Override
    public Optional<VaccineDTO> update(String producerName, VaccineCommand command) {
        return vaccineRepositoryJdbc.update(producerName, mapCommandToVaccine(command)).map(this::mapVaccineToDTO);
    }



    private Vaccine mapCommandToVaccine(final VaccineCommand command){
        return new Vaccine(command.getId(),command.getScienceName(),command.getProducerName(),command.getTypeOfVaccine(),
                command.getNecessaryNumOfVaccine(),command.getAvailableVaccine());
    }


    private VaccineDTO mapVaccineToDTO(final Vaccine vaccine){
        return new VaccineDTO(vaccine.getScienceName(),vaccine.getProducerName(), vaccine.getNecessaryNumOfVaccine());
    }

}
