package hr.java.matijevic.vaxapp;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RepositoryClass implements VaccineRepository, Serializable {

    private VaccineRepository vaccineRepository;

    private final List<Vaccine> vaccines = new
            ArrayList<>(
                    Arrays.asList(
            new Vaccine("Phizer", "Phizer-BioTech", "grey",
                    2, 3000),
            new Vaccine("Moderna", "Moderna", "red",
                    1, 3200),
            new Vaccine("AZD123", "Astra", "red",
                    3, 789456),
            new Vaccine("AZD123", "Sinopharm", "red",
                                    3, 789456)
                    )
    );

    @Override
    public List<Vaccine> findAll() {
        return vaccines;
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(final String researchName) {
        return vaccines.stream().filter(it -> Objects.equals(it.getScienceName(), researchName)).findAny();
    }

    @Override
    public List<Vaccine> findVaccineByTypeOfVaccine(final String typeOfVaccine) {
        return vaccines.stream().filter(it -> Objects.equals(it.getTypeOfVaccine(), typeOfVaccine))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteByScienceName(String scienceName) {

        return vaccines.removeIf(v -> v.getScienceName().equals(scienceName));
    }


    @Override
    public Optional<Vaccine> save(final Vaccine vaccine) {
        boolean check = true;
            for(Vaccine v: vaccines){
                if (v.getScienceName().equals(vaccine.getScienceName())) {
                    check = false;
                    break;
                }
            }
            if(check){
                vaccines.add(vaccine);
                return Optional.of(vaccine);
            }
            else {

                return Optional.empty();
            }
    }

    @Override
    public Optional<Vaccine> update(String producerName, Vaccine vaccine) {
        boolean check = true;
        for(Vaccine v : vaccines){
            if(v.getProducerName().equals(producerName)){
                v.setScienceName(vaccine.getScienceName());
                v.setNecessaryNumOfVaccine(vaccine.getNecessaryNumOfVaccine());
                v.setProducerName(vaccine.getProducerName());
                v.setTypeOfVacine(vaccine.getTypeOfVaccine());
                v.setAvailableVaccine(vaccine.getAvailableVaccine());
                check = false;
                break;

            }
        }
        if(check){
            return Optional.of(vaccine);
        }
        else{
            return Optional.empty();
        }
    }


    private VaccineDTO mapVaccineToVaccineDTO(final Vaccine command) {
        return new VaccineDTO(command.getScienceName(),command.getProducerName(), command.getNecessaryNumOfVaccine());
    }


}