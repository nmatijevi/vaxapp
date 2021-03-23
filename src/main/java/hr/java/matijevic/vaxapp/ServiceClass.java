package hr.java.matijevic.vaxapp;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
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

    private VaccineDTO mapVaccineToDTO(final Vaccine vaccine){
        return new VaccineDTO(vaccine.getProducerName(), vaccine.getNecessaryNumVacine());
    }
}
