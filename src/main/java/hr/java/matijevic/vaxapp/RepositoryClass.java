package hr.java.matijevic.vaxapp;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RepositoryClass implements VaccineRepository, Serializable {
    @Override
    public List<Vaccine> findAll() {
        return null;
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(String researchName) {
        return Optional.empty();
    }

    @Override
    public List<Vaccine> findVaccineByTypeOfVaccine(String typeOfVaccine) {
        return null;
    }

    @Override
    public boolean deleteByScienceName(String scienceName) {
        return false;
    }

    @Override
    public Optional<Vaccine> save(Vaccine vaccine) {
        return Optional.empty();
    }

    @Override
    public Optional<Vaccine> update(String producerName, Vaccine vaccine) {
        return Optional.empty();
    }

    /*
    private VaccineRepository vaccineRepository;


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



     */


}