package hr.java.matijevic.vaxapp;

import org.springframework.stereotype.Repository;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

@Repository
public interface SideEffectRepository {

    List<SideEffect> findAll();

    Optional<SideEffect> findSideEffectByShortDescription(String shortDescription);


}
