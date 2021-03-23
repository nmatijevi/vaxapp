package hr.java.matijevic.vaxapp;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class RepositoryClass implements VaccineRepository {

    private VaccineRepository vaccineRepository;

    private final List<Vaccine> Vaccine = Arrays.asList(
            new Vaccine("Phizer", "Phizer-BioTech", "grey",
                    2, 3000),
            new Vaccine("Moderna", "Moderna", "blue",
                    1, 3200),
            new Vaccine("AZD123", "Astra", "red",
                                3, 789456)
    );


    @Override
    public List<Vaccine> findAll() {
        return Vaccine;
    }

    @Override
    public Optional<Vaccine> findVaccineByResearchName(final String researchName) {
        return Vaccine.stream().filter(it -> Objects.equals(it.getResearchName(), researchName)).findAny();
    }
}
