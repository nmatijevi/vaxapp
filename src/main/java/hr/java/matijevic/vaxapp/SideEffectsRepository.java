package hr.java.matijevic.vaxapp;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.*;

@Repository
public class SideEffectsRepository implements SideEffectRepository, Serializable {

    private final List<SideEffect> sideEffects = new
            ArrayList<>(
            Arrays.asList(
                    new SideEffect("Agresija", 2, "jako agresivno ponasanje"),
                    new SideEffect("drugaagresija", 3, "nesto posve novo")));

    @Override
    public List<SideEffect> findAll() {
        return sideEffects;
    }

    @Override
    public Optional<SideEffect> findSideEffectByShortDescription(final String shortDescription) {
        return sideEffects.stream().filter(it -> Objects.equals(it.getShortDescription(), shortDescription)).findAny();
    }


}
