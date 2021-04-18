package hr.java.matijevic.vaxapp;

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
    public SideEffectDTO findSideEffectByShortDescription(String shortDescription) {
        return sideEffectRepository.findSideEffectByShortDescription(shortDescription).map(this::mapSideEffectToDTO).orElse(null);
    }




    private SideEffectDTO mapSideEffectToDTO(final SideEffect sideEffect){
        return new SideEffectDTO(sideEffect.getShortDescription(), sideEffect.getPercentageOfEffect(), sideEffect.getLongDescription());
    }
}
