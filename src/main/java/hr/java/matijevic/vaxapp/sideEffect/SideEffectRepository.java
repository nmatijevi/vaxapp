package hr.java.matijevic.vaxapp.sideEffect;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SideEffectRepository extends JpaRepository<SideEffect, Long> {


    //Optional<SideEffect> findByShortDescription(String shortDescription);
    Optional<SideEffect> findByIdVaccine(Integer id);

}
