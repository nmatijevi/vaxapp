package hr.java.matijevic.vaxapp.sideEffect;

import hr.java.matijevic.vaxapp.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SideEffectRepository extends JpaRepository<SideEffect, Long> {

    List<SideEffect> findAll();
    Optional<SideEffect> findByShortDescription(String shortDescription);
    Optional<SideEffect> findByResearchName(String researchName);
    List<SideEffect> findAllByFrequencyBetween(Integer from, Integer to);


    // Optional<SideEffect> findByIdVaccine(Integer id);

}
