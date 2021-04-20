package hr.java.matijevic.vaxapp.sideEffect;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SideEffectRepository {

    List<SideEffect> findAll();

    Optional<SideEffect> findSideEffectByShortDescription(String shortDescription);


}
