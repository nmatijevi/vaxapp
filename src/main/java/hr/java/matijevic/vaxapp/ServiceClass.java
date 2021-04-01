package hr.java.matijevic.vaxapp;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceClass implements VaccineService, Serializable {

    private final VaccineRepository vaccineRepository;

    public ServiceClass(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public List<VaccineDTO> findAll() {
        return vaccineRepository.findAll().stream().map(this::mapVaccineToDTO).collect(Collectors.toList());
    }

    @Override
    public VaccineDTO findVaccineByResearchName(String researchName) {
        return vaccineRepository.findVaccineByResearchName(researchName).map(this::mapVaccineToDTO).orElse(null);
    }

    public List<Vaccine> findVaccineByTypeOfVaccine(String typeOfVaccine) {
      return vaccineRepository.findVaccineByTypeOfVaccine(typeOfVaccine);
    }

    @Override
    public boolean deleteByScienceName(String scienceName) {
       return vaccineRepository.deleteByScienceName(scienceName);
    }

    @Override
    public Optional<VaccineDTO> save(VaccineCommand command) {
      return vaccineRepository.save(mapCommandToVaccine(command)).map(this::mapVaccineToDTO);
     }

    @Override
    public Optional<VaccineDTO> update(String producerName, VaccineCommand command) {
        return vaccineRepository.update(producerName, mapCommandToVaccine(command)).map(this::mapVaccineToDTO);
    }


    private VaccineDTO mapVaccineToVaccineDTO(final Vaccine command) {
        return new VaccineDTO(command.getProducerName(), command.getNecessaryNumVaccine());
    }
    private Vaccine mapCommandToVaccine(final VaccineCommand command){
        return new Vaccine(command.getScienceName(),command.getProducerName(),command.getTypeOfVaccine(),
                command.getNecessaryNumVaccine(),command.getAvailableVaccine());
    }
    private VaccineDTO mapCommandToVaccineDTO(final VaccineCommand command){
        return new VaccineDTO(command.getProducerName(),command.getNecessaryNumVaccine());
    }

    private VaccineDTO mapVaccineToDTO(final Vaccine vaccine){
        return new VaccineDTO(vaccine.getProducerName(), vaccine.getNecessaryNumVaccine());
    }

}
