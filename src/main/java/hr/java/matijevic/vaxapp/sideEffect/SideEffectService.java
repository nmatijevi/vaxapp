package hr.java.matijevic.vaxapp.sideEffect;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SideEffectService {

    List<SideEffectDTO> findAll();

    SideEffectDTO findSideEffectByShortDescription(String shortDescription);

}
