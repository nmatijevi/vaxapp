package hr.java.matijevic.vaxapp.sideEffect;

import hr.java.matijevic.vaxapp.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SideEffectRepository extends JpaRepository<SideEffect, Long> {


    Optional<SideEffect> findByShortDescription(String shortDescription);
    Optional<SideEffect> findByScienceName(String scienceName);
    List<SideEffect> findAllByPercentageOfEffectBetween(Integer from, Integer to);


    // Optional<SideEffect> findByIdVaccine(Integer id);

}
