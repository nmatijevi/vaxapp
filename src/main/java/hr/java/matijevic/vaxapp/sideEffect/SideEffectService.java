package hr.java.matijevic.vaxapp.sideEffect;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SideEffectService {

    List<SideEffectDTO> findAll();

    SideEffectDTO findByShortDescription(String shortDescription);
    SideEffectDTO findByResearchName(String ResearchName);
    List<SideEffectDTO>findAllByFrequencyBetween(Integer from, Integer to);
   // SideEffectDTO findByIdVaccine(Integer id);

}
