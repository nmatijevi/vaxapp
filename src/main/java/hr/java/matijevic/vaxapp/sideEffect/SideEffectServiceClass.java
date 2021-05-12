package hr.java.matijevic.vaxapp.sideEffect;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SideEffectServiceClass implements SideEffectService{

    private final SideEffectRepository sideEffectRepository;

    public SideEffectServiceClass(SideEffectRepository sideEffectRepository) {
        this.sideEffectRepository = sideEffectRepository;
    }

    @Override
    public List<SideEffectDTO> findAll() {
        return sideEffectRepository.findAll().stream().map(this::mapSideEffectToDTO).collect(Collectors.toList());
    }

    @Override
    public SideEffectDTO findByShortDescription(String shortDescription) {
        return sideEffectRepository.findByShortDescription(shortDescription).map(this::mapSideEffectToDTO).orElse(null);
    }

  //  @Override
 //   public SideEffectDTO findByIdVaccine(Integer id) {
 //       return sideEffectRepository.findByIdVaccine(id).map(this::mapSideEffectToDTO).orElse(null);

 //   }

    @Override
       public SideEffectDTO findByResearchName(String ResearchName) {
           return sideEffectRepository.findByResearchName(ResearchName).map(this::mapSideEffectToDTO).orElse(null);
              }

    @Override
    public List<SideEffectDTO> findAllByFrequencyBetween(Integer from, Integer to) {
        return sideEffectRepository.findAllByFrequencyBetween(from, to).stream().map(this::mapSideEffectToDTO).collect(Collectors.toList());
    }


    private SideEffectDTO mapSideEffectToDTO(final SideEffect sideEffect){
        return new SideEffectDTO(sideEffect.getShortDescription(), sideEffect.getFrequency(), sideEffect.getDescription());
    }
}
